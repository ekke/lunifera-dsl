/**
 */
package org.lunifera.dsl.semantic.entity;

import org.lunifera.dsl.semantic.common.types.LReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LEntity Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityReference#getType <em>Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LEntityReference#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityReference()
 * @model
 * @generated
 */
public interface LEntityReference extends LEntityFeature, LReference
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(LEntity)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityReference_Type()
   * @model
   * @generated
   */
  LEntity getType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(LEntity value);

  /**
   * Returns the value of the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opposite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite</em>' reference.
   * @see #setOpposite(LEntityReference)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLEntityReference_Opposite()
   * @model
   * @generated
   */
  LEntityReference getOpposite();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LEntityReference#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' reference.
   * @see #getOpposite()
   * @generated
   */
  void setOpposite(LEntityReference value);

} // LEntityReference
