/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 * 
 *  Based on ideas from Xtext, Xtend, Xcore
 *    
 *  Contributors:  
 *  		Florian Pirchner - Initial implementation 
 *  
 */
package org.lunifera.dsl.semantic.dto;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LDto Mapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoMapper#getToDTO <em>To DTO</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.dto.LDtoMapper#getFromDTO <em>From DTO</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoMapper()
 * @model
 * @generated
 */
public interface LDtoMapper extends EObject
{
  /**
   * Returns the value of the '<em><b>To DTO</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To DTO</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To DTO</em>' containment reference.
   * @see #setToDTO(XExpression)
   * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoMapper_ToDTO()
   * @model containment="true"
   * @generated
   */
  XExpression getToDTO();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDtoMapper#getToDTO <em>To DTO</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To DTO</em>' containment reference.
   * @see #getToDTO()
   * @generated
   */
  void setToDTO(XExpression value);

  /**
   * Returns the value of the '<em><b>From DTO</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From DTO</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From DTO</em>' containment reference.
   * @see #setFromDTO(XExpression)
   * @see org.lunifera.dsl.semantic.dto.LunDtoPackage#getLDtoMapper_FromDTO()
   * @model containment="true"
   * @generated
   */
  XExpression getFromDTO();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.dto.LDtoMapper#getFromDTO <em>From DTO</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From DTO</em>' containment reference.
   * @see #getFromDTO()
   * @generated
   */
  void setFromDTO(XExpression value);

} // LDtoMapper