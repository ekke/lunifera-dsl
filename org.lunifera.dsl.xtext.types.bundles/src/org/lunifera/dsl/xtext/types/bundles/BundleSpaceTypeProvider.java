/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 * 
 * Based on Xtext org.eclipse.xtext.common.types.access.reflect.ReflectionTypeProvider
 * 
 */
package org.lunifera.dsl.xtext.types.bundles;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClassMirror;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.reflect.ReflectURIHelper;
import org.eclipse.xtext.common.types.access.reflect.ReflectionTypeFactory;

@SuppressWarnings({ "restriction", "deprecation" })
public class BundleSpaceTypeProvider extends AbstractRuntimeJvmTypeProvider {

	private final BundleSpace classFinder;

	private final ReflectionTypeFactory reflectionTypeFactory;

	private final ReflectURIHelper uriHelper;

	public BundleSpaceTypeProvider(BundleSpace classFinder,
			ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		super(resourceSet, indexedJvmTypeAccess);
		this.classFinder = classFinder;
		uriHelper = createClassURIHelper();
		reflectionTypeFactory = createDeclaredTypeFactory();
	}

	protected ReflectionTypeFactory createDeclaredTypeFactory() {
		return new ReflectionTypeFactory(uriHelper);
	}

	protected ReflectURIHelper createClassURIHelper() {
		return new ReflectURIHelper();
	}

	public ReflectURIHelper getClassURIHelper() {
		return uriHelper;
	}

	public ReflectionTypeFactory getDeclaredTypeFactory() {
		return reflectionTypeFactory;
	}

	public BundleSpace getClassFinder() {
		return classFinder;
	}

	@Override
	public JvmType findTypeByName(String name) {
		try {
			// seems to be the only reliable way to locate nested types
			// since dollar signs are a quite good indicator but not necessarily
			// the best
			Class<?> clazz = classFinder.forName(name);
			return findTypeByClass(clazz);
		} catch (ClassNotFoundException e) {
			return tryFindTypeInIndex(name, true);
		} catch (NoClassDefFoundError e) {
			/*
			 * Error will be thrown if the contents of the binary class file
			 * does not match the expectation (transitively). See
			 * java.lang.ClassLoader.defineClass(String, byte[], int, int,
			 * ProtectionDomain)
			 */
			return tryFindTypeInIndex(name, true);
		}
	}

	/**
	 * @since 2.4
	 */
	@Override
	public JvmType findTypeByName(String name, boolean binaryNestedTypeDelimiter) {
		if (isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter)) {
			return findTypeByName(name);
		}
		return doFindTypeByName(name);
	}

	private JvmType doFindTypeByName(String name) {
		try {
			// seems to be the only reliable way to locate nested types
			// since dollar signs are a quite good indicator but not necessarily
			// the best
			Class<?> clazz = findClassByName(name);
			return findTypeByClass(clazz);
		} catch (ClassNotFoundException e) {
			return tryFindTypeInIndex(name, false);
		} catch (NoClassDefFoundError e) {
			/*
			 * Error will be thrown if the contents of the binary class file
			 * does not match the expectation (transitively). See
			 * java.lang.ClassLoader.defineClass(String, byte[], int, int,
			 * ProtectionDomain)
			 */
			return tryFindTypeInIndex(name, false);
		}
	}

	private JvmType findTypeByClass(Class<?> clazz) {
		IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
		URI resourceURI = uriHelper.createResourceURI(clazz);
		if (indexedJvmTypeAccess != null) {
			URI proxyURI = resourceURI.appendFragment(uriHelper
					.getFragment(clazz));
			EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(
					proxyURI, getResourceSet());
			if (candidate instanceof JvmType)
				return (JvmType) candidate;
		}
		TypeResource result = (TypeResource) getResourceSet().getResource(
				resourceURI, true);
		return findTypeByClass(clazz, result);
	}

	private Class<?> findClassByName(String name) throws ClassNotFoundException {
		try {
			Class<?> clazz = classFinder.forName(name);
			return clazz;
		} catch (ClassNotFoundException exception) {
			int index = name.lastIndexOf('.');
			if (index <= 0) {
				throw exception;
			}
			String baseName = name.substring(0, index);
			try {
				Class<?> resolvedOuterClass = findClassByName(baseName);
				baseName = resolvedOuterClass.getName();
			} catch (ClassNotFoundException baseNameException) {
				throw exception;
			}
			Class<?> clazz = classFinder.forName(baseName + '$'
					+ name.substring(index + 1));
			return clazz;
		}
	}

	protected JvmType tryFindTypeInIndex(String name,
			boolean binaryNestedTypeDelimiter) {
		TypeInResourceSetAdapter adapter = (TypeInResourceSetAdapter) EcoreUtil
				.getAdapter(getResourceSet().eAdapters(),
						TypeInResourceSetAdapter.class);
		if (adapter != null) {
			return adapter.tryFindTypeInIndex(name, this,
					binaryNestedTypeDelimiter);
		} else {
			return doTryFindInIndex(name, binaryNestedTypeDelimiter);
		}
	}

	@Override
	protected IMirror createMirrorForFQN(String name) {
		try {
			Class<?> clazz = classFinder.forName(name);
			return createMirror(clazz);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public ClassMirror createMirror(Class<?> clazz) {
		return ClassMirror.createClassMirror(clazz, reflectionTypeFactory);
	}

	public JvmType findTypeByClass(Class<?> clazz, Resource resource) {
		String fragment = uriHelper.getFragment(clazz);
		JvmType result = (JvmType) resource.getEObject(fragment);
		if (result == null) {
			throw new IllegalStateException("Resource has not been loaded");
		}
		return result;
	}

}
