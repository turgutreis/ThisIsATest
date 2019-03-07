/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2016-2019 PikeTec GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.piketec.tpt.api;

import java.rmi.RemoteException;

/**
 * A <code>Declaration</code> is either a signal or a parameter or a constant.
 * 
 * @author Copyright (c) 2016-2019 Piketec GmbH - MIT License (MIT)
 */
public interface Declaration extends NamedObject, IdentifiableRemote {

  /**
   * @return The group the declaration belongs to. Empty String if no Group is defined.
   * @throws ApiException
   * @throws RemoteException
   */
  String getGroup() throws ApiException, RemoteException;

  /**
   * Set the group the declaration should belong to.
   * 
   * @param group
   *          The new group. <code>Null</code> or an string containing only whitespaces will be
   *          reduced to an empty string.
   * @throws ApiException
   * @throws RemoteException
   */
  void setGroup(String group) throws ApiException, RemoteException;

  /**
   * @return The unit of the declaration, if unit was set for primitive types, for complex types
   *         units of subvariables are united.
   * @throws ApiException
   * @throws RemoteException
   */
  String getUnit() throws ApiException, RemoteException;

  /**
   * @return The unit of the declaration, if unit was set, else implicit unit, which unites units of
   *         subvariables.
   * @deprecated Use {@link #getUnit()} instead.
   * @throws ApiException
   * @throws RemoteException
   */
  @Deprecated
  String getImplicitUnit() throws ApiException, RemoteException;

  /**
   * Set the unit of the declaration. For structs, maps and curves provide a comma separated list of
   * units in braces, which fits their structure.
   * 
   * @param unit
   *          The new unit of the declaration. <code>Null</code> will be reduced to an empty string.
   * @throws ApiException
   *           If the provided string is not allowed as unit and, in case of structs, maps and
   *           curves, if it does not fit their structure.
   * @throws RemoteException
   */
  void setUnit(String unit) throws ApiException, RemoteException;

  /**
   * Get the default value of the declaration. The format is the same as seen in tptaif or the
   * declaration editor.
   * 
   * @return The default value string.
   * @throws ApiException
   * @throws RemoteException
   */
  String getDefaultValue() throws ApiException, RemoteException;

  /**
   * Set the default value of the declaration. The format is the same as seen in tptaif or the
   * declaration editor.
   * 
   * @param defaultValue
   *          The new default value.
   * @throws ApiException
   *           If the given <code>defaultValue</code> string could not be parsed.
   * @throws RemoteException
   */
  void setDefaultValue(String defaultValue) throws ApiException, RemoteException;

  /**
   * Get the type of the declaration.
   * 
   * @return The type of the declaration.
   * @throws ApiException
   * @throws RemoteException
   */
  Type getType() throws ApiException, RemoteException;

  /**
   * Set the type of the declaration. Anonymous types are copied so the following code will return
   * false:
   * 
   * <pre>
   * Type anonymousType = project.createType(null, "float[]");
   * Channel channel = project.createChannel("myChannel");
   * channel.setType(anonymousType);
   * return channel.getType().equals(anonymousType); // false
   * </pre>
   * 
   * If the new type is a struct, map or curve and the declaration has a unit set, the unit will be
   * removed since units are not allowed for declarations of these types.
   * 
   * @param type
   *          The new type of the declaration. This will reset the default value.
   * @throws ApiException
   *           If the given type is unknown in the TPT project.
   * @throws RemoteException
   */
  void setType(Type type) throws ApiException, RemoteException;

  /**
   * Get the description of the declaration.
   * 
   * @return The description of the declaration.
   * @throws ApiException
   * @throws RemoteException
   */
  String getDescription() throws ApiException, RemoteException;

  /**
   * Set the description of the declaration.
   * 
   * @param description
   *          The new description of the declaration. <code>Null</code> will be reduced to an empty
   *          string.
   * @throws ApiException
   * @throws RemoteException
   */
  void setDescription(String description) throws ApiException, RemoteException;

}
