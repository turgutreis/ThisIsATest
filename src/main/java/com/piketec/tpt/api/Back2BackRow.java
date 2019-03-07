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
 * 
 * @author Copyright (c) 2016-2019 Piketec GmbH - MIT License (MIT)
 *
 */
public interface Back2BackRow extends IdentifiableRemote {

  /**
   * @return <code>true</code> if the row was created when auto-mode was enabled.
   * @see Back2BackSettings#setAutoUpdate(com.piketec.tpt.api.Back2BackSettings.VariableType,
   *      boolean)
   */
  public boolean createdByAutoMode() throws RemoteException, ApiException;

  /**
   * @return the corresponding variable to this {@link Back2BackRow}.
   */
  public String getVariable() throws RemoteException, ApiException;

  /**
   * Change the corresponding variable to this {@link Back2BackRow}.
   * 
   * @param channel
   *          the new attribute value
   */
  public void setVariable(String channel) throws RemoteException, ApiException;

  /**
   * @return the corresponding reference-signal-name or <code>null</code>.
   * 
   */
  public String getReferenceSignalNameOrNull() throws RemoteException, ApiException;

  /**
   * Change the corresponding reference-signal-name or <code>null</code>.
   * 
   * @param referenceSignalNameOrNull
   *          the new attribute value
   */
  public void setReferenceSignalNameOrNull(String referenceSignalNameOrNull)
      throws RemoteException, ApiException;

  /**
   * @return the {@link String} representing the time tolerance.
   */
  public String getTimeTolerance() throws RemoteException, ApiException;

  /**
   * Change the {@link String} representing the time tolerance.
   * 
   * @param timeTolerance
   *          the new attribute value
   */
  public void setTimeTolerance(String timeTolerance) throws RemoteException, ApiException;

  /**
   * @return the {@link String} representing the absolute tolerance.
   */
  public String getAbsoluteTolerance() throws RemoteException, ApiException;

  /**
   * Change the {@link String} representing the absolute tolerance.
   * 
   * @param absoluteTolerance
   *          the new attribute value
   */
  public void setAbsoluteTolerance(String absoluteTolerance) throws RemoteException, ApiException;

  /**
   * @return the {@link String} representing the relative tolerance.
   */
  public String getRelativeTolerance() throws RemoteException, ApiException;

  /**
   * Change the {@link String} representing the relative tolerance.
   * 
   * @param relativeTolerance
   *          the new attribute value
   */
  public void setRelativeTolerance(String relativeTolerance) throws RemoteException, ApiException;

  /**
   * @return the {@link String} representing the lsb-tolerance.
   */
  public String getLsbTolerance() throws RemoteException, ApiException;

  /**
   * Change the {@link String} representing the lsb-tolerance.
   * 
   * @param lsbTolerance
   *          the new attribute value
   */
  public void setLsbTolerance(String lsbTolerance) throws RemoteException, ApiException;

  /**
   * @return <code>true</code> if this {@link Back2BackRow} is disabled.
   */
  public boolean isDisabled() throws RemoteException, ApiException;

  /**
   * Change if this {@link Back2BackRow} is disabled.
   * 
   * @param disabled
   *          the new attribute value
   */
  public void setDisabled(boolean disabled) throws RemoteException, ApiException;

  /**
   * @return <code>true</code> if float precision for comparison instead of double precision is
   *         enforced.
   */
  public boolean isFloatPrecision() throws RemoteException, ApiException;

  /**
   * Change if the float precision for comparison instead of double precision is enforced.
   * 
   * @param floatPrecision
   *          the new attribute value
   */
  public void setFloatPrecision(boolean floatPrecision) throws RemoteException, ApiException;

}
