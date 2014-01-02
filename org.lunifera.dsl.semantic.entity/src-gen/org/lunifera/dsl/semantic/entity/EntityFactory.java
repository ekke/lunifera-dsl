/**
 */
package org.lunifera.dsl.semantic.entity;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.lunifera.dsl.semantic.entity.EntityPackage
 * @generated
 */
public interface EntityFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EntityFactory eINSTANCE = org.lunifera.dsl.semantic.entity.impl.EntityFactoryImpl.init();

  /**
   * Returns a new object of class '<em>LEntity Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEntity Model</em>'.
   * @generated
   */
  LEntityModel createLEntityModel();

  /**
   * Returns a new object of class '<em>LBean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LBean</em>'.
   * @generated
   */
  LBean createLBean();

  /**
   * Returns a new object of class '<em>LEntity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEntity</em>'.
   * @generated
   */
  LEntity createLEntity();

  /**
   * Returns a new object of class '<em>LEntity Persistence Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEntity Persistence Info</em>'.
   * @generated
   */
  LEntityPersistenceInfo createLEntityPersistenceInfo();

  /**
   * Returns a new object of class '<em>LEntity Column Persistence Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEntity Column Persistence Info</em>'.
   * @generated
   */
  LEntityColumnPersistenceInfo createLEntityColumnPersistenceInfo();

  /**
   * Returns a new object of class '<em>LTable Per Class Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LTable Per Class Strategy</em>'.
   * @generated
   */
  LTablePerClassStrategy createLTablePerClassStrategy();

  /**
   * Returns a new object of class '<em>LTable Per Subclass Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LTable Per Subclass Strategy</em>'.
   * @generated
   */
  LTablePerSubclassStrategy createLTablePerSubclassStrategy();

  /**
   * Returns a new object of class '<em>LEntity Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEntity Feature</em>'.
   * @generated
   */
  LEntityFeature createLEntityFeature();

  /**
   * Returns a new object of class '<em>LEntity Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEntity Attribute</em>'.
   * @generated
   */
  LEntityAttribute createLEntityAttribute();

  /**
   * Returns a new object of class '<em>LEntity Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LEntity Reference</em>'.
   * @generated
   */
  LEntityReference createLEntityReference();

  /**
   * Returns a new object of class '<em>LBean Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LBean Feature</em>'.
   * @generated
   */
  LBeanFeature createLBeanFeature();

  /**
   * Returns a new object of class '<em>LBean Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LBean Attribute</em>'.
   * @generated
   */
  LBeanAttribute createLBeanAttribute();

  /**
   * Returns a new object of class '<em>LBean Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LBean Reference</em>'.
   * @generated
   */
  LBeanReference createLBeanReference();

  /**
   * Returns a new object of class '<em>LE Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LE Operation</em>'.
   * @generated
   */
  LEOperation createLEOperation();

  /**
   * Returns a new object of class '<em>LIndex</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LIndex</em>'.
   * @generated
   */
  LIndex createLIndex();

  /**
   * Returns a new object of class '<em>LOperation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LOperation</em>'.
   * @generated
   */
  LOperation createLOperation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EntityPackage getEntityPackage();

} //EntityFactory
