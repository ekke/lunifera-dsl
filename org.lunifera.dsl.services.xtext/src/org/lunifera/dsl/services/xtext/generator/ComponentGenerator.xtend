


/**
 * Copyright (c) 2011 - 2015, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         Florian Pirchner - Initial implementation
 */


package org.lunifera.dsl.services.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.lunifera.dsl.dto.xtext.extensions.MethodNamingExtensions
import org.lunifera.dsl.semantic.service.LCardinality
import org.lunifera.dsl.semantic.service.LDTOService
import org.lunifera.dsl.semantic.service.LService

class ComponentGenerator {

	@Inject extension MethodNamingExtensions
	@Inject extension IQualifiedNameProvider

	def dispatch getServiceContent(LDTOService service) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<scr:component xmlns:scr="http://www.osgi.org/xmlns/scr/v1.1.0" name="«service.fullyQualifiedName.toLowerCase»">
		       <implementation class="«service.fullyQualifiedName»"/>
		       <service>
		       	<provide interface="org.lunifera.dsl.dto.lib.services.IDTOService"/>
		       </service>
		       <property name="dto" type="String" value="«service.dto.fullyQualifiedName.toString»"/>
		       <property name="service.pid" type="String" value="«service.fullyQualifiedName.toLowerCase»"/>
		       «IF service.injectedServices != null && !service.injectedServices.services.empty»
		       	«FOR ref : service.injectedServices.services»
		       		<reference name="«ref.attributeName.toFirstLower»" interface="«ref.service.type?.qualifiedName.toString»" 
		       				cardinality="«ref.cardinality.cardinalityString»" policy="dynamic" bind="bind«ref.attributeName.
			toFirstUpper»" unbind="unbind«ref.attributeName.toFirstUpper»/>
		       	«ENDFOR»
		       «ELSE»
		       	«IF !service.mutablePersistenceId»
		       	<reference name="emf" interface="javax.persistence.EntityManagerFactory" cardinality="1..1" 
		       			policy="dynamic" bind="bindEmf" unbind="unbindEmf" «IF (service.persistenceId != null &&
					!service.persistenceId.equals(""))»target="(osgi.unit.name=«service.persistenceId»)"«ENDIF»/>
				«ENDIF»
		       	<reference name="mapperAccess" interface="org.lunifera.dsl.dto.lib.IMapperAccess" cardinality="1..1" 
		       			policy="dynamic" bind="bindMapperAccess" unbind="unbindMapperAccess"/>
		       «ENDIF»
		</scr:component>
	'''

	def dispatch getServiceContent(LService service) '''
«««		<?xml version="1.0" encoding="UTF-8"?>
«««		<components xmlns:scr="http://www.osgi.org/xmlns/scr/v1.0.0">
«««		   <scr:component name="«service.fullyQualifiedName.toLowerCase»">
«««		       <implementation class="«service.fullyQualifiedName»"/>
«««		       <service>
«««		       	<provide interface="org.lunifera.dsl.service.lib.IDTOService"/>
«««		       </service>
«««		       <property name="dto" value="«service.dto.fullyQualifiedName.toString»"/>
«««		       <property name="service.pid" value="«service.fullyQualifiedName.toLowerCase»"/>
«««		       «FOR ref : service.injectedServices.services»
«««		       	<reference name="«ref.attributeName.toFirstLower»" interface="«ref.service.qualifiedName.toString»" 
«««		       			cardinality="«ref.cardinality.cardinalityString»" policy="dynamic" bind="bind«ref.attributeName.
«««			toFirstUpper»" unbind="unbind«ref.attributeName.toFirstUpper»"/>
«««		       «ENDFOR»
«««		   </scr:component>
«««		</components>
	'''

	def String cardinalityString(LCardinality cardinality) {
		switch (cardinality) {
			case ZERO_TO_ONE:
				return "0..1"
			case ZERO_TO_MANY:
				return "0..n"
			case ONE_TO_ONE:
				return "1..1"
			case ONE_TO_MANY:
				return "1..n"
			default:
				return "0..1"
		}
	}

}
