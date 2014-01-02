/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.lunifera.dsl.entity.xtext;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EntityGrammarInjectorSingleton {
	public final static Injector INJECTOR = new EntityGrammarStandaloneSetup()
			.createInjectorAndDoEMFRegistration();
}
