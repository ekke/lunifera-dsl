/**
 * Copyright (c) 2011 - 2012, Florian Pirchner - lunifera.org
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Sources partially based on org.eclipse.emf.ecore.xcore.scoping.XcoreScopeProvider
 * 
 * Contributors:
 * 		Hans Georg Gl??ckler - Initial implementation
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.dto.xtext.scope;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.xbase.annotations.scoping.XbaseWithAnnotationsScopeProvider;
import org.lunifera.dsl.semantic.common.types.LClass;
import org.lunifera.dsl.semantic.common.types.LFeature;
import org.lunifera.dsl.semantic.common.types.LFeaturesHolder;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.dto.DtoPackage;
import org.lunifera.dsl.semantic.dto.LDto;
import org.lunifera.dsl.semantic.dto.LDtoWrappedReference;
import org.lunifera.dsl.semantic.entity.EntityPackage;
import org.lunifera.dsl.semantic.entity.LBean;
import org.lunifera.dsl.semantic.entity.LBeanReference;

import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
@SuppressWarnings("restriction")
public class DtoScopeProvider extends XbaseWithAnnotationsScopeProvider {
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private IQualifiedNameProvider fqnProvider;

	@Override
	public IScope getScope(final EObject context, EReference reference) {
		if (reference == DtoPackage.Literals.LDTO_WRAPPED_REFERENCE__FEATURE) {
			return getScope_LDtoWrappedReference_feature((LDtoWrappedReference) context);
		} else if (reference == EntityPackage.Literals.LBEAN_REFERENCE__OPPOSITE) {
			return getScope_LFeature_Opposite((LBeanReference) context);
		}
		return super.getScope(context, reference);
	}

	private IScope getScope_LDtoWrappedReference_feature(
			final LDtoWrappedReference prop) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
				if (prop.getDTO() != null) {
					LDto propClass = prop.getDTO();

					LType wrappedType = propClass.getWrappedType();
					if (wrappedType != null
							&& wrappedType instanceof LFeaturesHolder) {
						LFeaturesHolder holder = (LFeaturesHolder) wrappedType;

						for (LFeature feature : holder.getAllFeatures()) {
							result.add(new EObjectDescription(fqnProvider
									.getFullyQualifiedName(feature), feature,
									null));
						}
					}
				}
				return result;
			}
		};
	}

	private IScope getScope_LFeature_Opposite(final LBeanReference prop) {
		return new AbstractScope(IScope.NULLSCOPE, false) {
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
				if (prop.getType() != null && prop.getType() instanceof LClass) {
					LBean propClass = prop.getBean();
					LBean type = prop.getType();
					for (LBeanReference oppositeProp : type.getReferences()) {
						if (oppositeProp.getType() == propClass) {
							String name = oppositeProp.getName();
							if (name != null) {
								result.add(new EObjectDescription(
										qualifiedNameConverter
												.toQualifiedName(name),
										oppositeProp, null));
							}
						}
					}
				}
				return result;
			}
		};
	}
	//
	// /**
	// * Returns the scope for the opposite reference of LReference
	// *
	// * @param a_refers
	// * @return
	// */
	// private IScope getScope_LReference_Opposite(final LRefers a_refers) {
	// return new AbstractScope(IScope.NULLSCOPE, false) {
	// @Override
	// protected Iterable<IEObjectDescription> getAllLocalElements() {
	// ArrayList<IEObjectDescription> result = new
	// ArrayList<IEObjectDescription>();
	// LClass a_type = a_refers.getType();
	// if (a_type != null) {
	// LClass a_containingRefersType = (LClass) a_refers
	// .eContainer();
	// // iterate all memeber in the opposite type
	// for (LEntityMember member : a_type.getEntityMembers()) {
	// if (member instanceof LRefers) {
	// LRefers x_otherRefers = (LRefers) member;
	// LClass x_otherRefersType = x_otherRefers.getType();
	// // test if the name of the
	// // a_refers-eContainer (==
	// // LClass)
	// // matches the name of the
	// // x_otherRefers-type from the
	// // iterated members
	// if (modelExtensions.nameEquals(x_otherRefersType,
	// a_containingRefersType)) {
	// String name = x_otherRefers.getName();
	// if (name != null) {
	// result.add(new EObjectDescription(
	// qualifiedNameConverter
	// .toQualifiedName(name),
	// member, null));
	// }
	// }
	// }
	// }
	// }
	// return result;
	// }
	// };
	// }
	//
	// /**
	// * Returns the scope for the opposite reference of LContainer
	// *
	// * @param a_container
	// * @return
	// */
	// private IScope getScope_LContainer_Opposite(final LContainer a_container)
	// {
	// return new AbstractScope(IScope.NULLSCOPE, false) {
	// @Override
	// protected Iterable<IEObjectDescription> getAllLocalElements() {
	// ArrayList<IEObjectDescription> result = new
	// ArrayList<IEObjectDescription>();
	// LClass a_type = a_container.getType();
	// if (a_type != null) {
	// LClass a_containingContainerType = (LClass) a_container
	// .eContainer();
	// // iterate all memeber in the opposite type
	// for (LEntityMember member : a_type.getEntityMembers()) {
	// if (member instanceof LContains) {
	// LContains x_contains = (LContains) member;
	// LClass x_containsType = x_contains.getType();
	// // test if the name of the
	// // a_container-eContainer (==
	// // LClass)
	// // matches the name of the
	// // x_contains-type from the
	// // iterated members
	// if (modelExtensions.nameEquals(x_containsType,
	// a_containingContainerType)) {
	// String name = x_contains.getName();
	// if (name != null) {
	// result.add(new EObjectDescription(
	// qualifiedNameConverter
	// .toQualifiedName(name),
	// member, null));
	// }
	// }
	// }
	// }
	// }
	// return result;
	// }
	// };
	// }
	//
	// /**
	// * Returns the scope for the opposite reference of bidirectional
	// associations.
	// */
	// private IScope getScope_LContains_Opposite(final LFeature prop) {
	// return new AbstractScope(IScope.NULLSCOPE, false) {
	// @Override
	// // springt zu EntityProposalProvider
	// protected Iterable<IEObjectDescription> getAllLocalElements() {
	// ArrayList<IEObjectDescription> result = new
	// ArrayList<IEObjectDescription>();
	// LClass type = prop.getType();
	// if (type != null) {
	// for (LEntityMember opposite : type.getEntityMembers()) {
	// if (opposite instanceof LContainer) {
	// String name = ((LContainer) opposite).getName();
	// if (name != null) {
	// result.add(new EObjectDescription(
	// qualifiedNameConverter
	// .toQualifiedName(name),
	// opposite, null));
	// }
	// }
	// }
	// }
	// return result;
	// }
	// };
	// }

}
