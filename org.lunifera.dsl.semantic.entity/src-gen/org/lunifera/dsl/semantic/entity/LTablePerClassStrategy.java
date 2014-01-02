/**
 */
package org.lunifera.dsl.semantic.entity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LTable Per Class Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorColumn <em>Discriminator Column</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorType <em>Discriminator Type</em>}</li>
 *   <li>{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorValue <em>Discriminator Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLTablePerClassStrategy()
 * @model
 * @generated
 */
public interface LTablePerClassStrategy extends LEntityInheritanceStrategy
{
  /**
   * Returns the value of the '<em><b>Discriminator Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Discriminator Column</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Discriminator Column</em>' attribute.
   * @see #setDiscriminatorColumn(String)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLTablePerClassStrategy_DiscriminatorColumn()
   * @model unique="false"
   * @generated
   */
  String getDiscriminatorColumn();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorColumn <em>Discriminator Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Discriminator Column</em>' attribute.
   * @see #getDiscriminatorColumn()
   * @generated
   */
  void setDiscriminatorColumn(String value);

  /**
   * Returns the value of the '<em><b>Discriminator Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.lunifera.dsl.semantic.entity.LDiscriminatorType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Discriminator Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Discriminator Type</em>' attribute.
   * @see org.lunifera.dsl.semantic.entity.LDiscriminatorType
   * @see #setDiscriminatorType(LDiscriminatorType)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLTablePerClassStrategy_DiscriminatorType()
   * @model unique="false"
   * @generated
   */
  LDiscriminatorType getDiscriminatorType();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorType <em>Discriminator Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Discriminator Type</em>' attribute.
   * @see org.lunifera.dsl.semantic.entity.LDiscriminatorType
   * @see #getDiscriminatorType()
   * @generated
   */
  void setDiscriminatorType(LDiscriminatorType value);

  /**
   * Returns the value of the '<em><b>Discriminator Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Discriminator Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Discriminator Value</em>' attribute.
   * @see #setDiscriminatorValue(String)
   * @see org.lunifera.dsl.semantic.entity.EntityPackage#getLTablePerClassStrategy_DiscriminatorValue()
   * @model unique="false"
   * @generated
   */
  String getDiscriminatorValue();

  /**
   * Sets the value of the '{@link org.lunifera.dsl.semantic.entity.LTablePerClassStrategy#getDiscriminatorValue <em>Discriminator Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Discriminator Value</em>' attribute.
   * @see #getDiscriminatorValue()
   * @generated
   */
  void setDiscriminatorValue(String value);

} // LTablePerClassStrategy
