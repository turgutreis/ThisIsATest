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
 * A Constant is a value that stays the same during execution time.
 * 
 * @author Copyright (c) 2016-2019 Piketec GmbH - MIT License (MIT)
 */
public interface Constant extends Declaration {

  /**
   * Get if the constant is a system constant.
   * 
   * @return <code>true</code> if the constant is a system constant, <code>false</code> otherwise.
   * @throws ApiException
   * @throws RemoteException
   */
  boolean isSystemConstant() throws ApiException, RemoteException;

  /**
   * Set if the constant is a system constant.
   * 
   * @param on
   *          <code>true</code> if the constant should be system constant, <code>false</code>
   *          otherwise.
   * @throws ApiException
   * @throws RemoteException
   */
  void setSystemConstant(boolean on) throws ApiException, RemoteException;

}
