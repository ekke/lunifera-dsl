/*******************************************************************************
 * Copyright (c) 2011, 2012 Cristiano Gavião - Lunifera.org.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cristiano Gavião - initial API and implementation
 *******************************************************************************/
/*
 * generated by Xtext
 */
package org.lunifera.dsl.organization.xtext.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.lunifera.dsl.organization.xtext.ui.hover.OrganizationGrammarEObjectDocumentationProvider;
import org.lunifera.dsl.organization.xtext.ui.hover.OrganizationGrammarEObjectHoverProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OrganizationGrammarUiModule
		extends
		org.lunifera.dsl.organization.xtext.ui.AbstractOrganizationGrammarUiModule {
	public OrganizationGrammarUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return OrganizationGrammarEObjectHoverProvider.class;
	}

	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
		return OrganizationGrammarEObjectDocumentationProvider.class;
	}
}
