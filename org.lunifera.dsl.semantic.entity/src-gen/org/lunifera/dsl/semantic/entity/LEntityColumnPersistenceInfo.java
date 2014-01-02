/**
 */
package org.lunifera.dsl.semantic.entity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LEntity Column Persistence Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo#getColumnName <em>Column Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityColumnPersistenceInfo()
 * @model
 * @generated
 */
public interface LEntityColumnPersistenceInfo extends EObject
{
  /**
   * Returns the value of the '<em><b>Column Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Column Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Column Name</em>' attribute.
   * @see #setColumnName(String)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityColumnPersistenceInfo_ColumnName()
   * @model unique="false"
   * @generated
   */
  String getColumnName();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityColumnPersistenceInfo#getColumnName <em>Column Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Column Name</em>' attribute.
   * @see #getColumnName()
   * @generated
   */
  void setColumnName(String value);

} // LEntityColumnPersistenceInfo
