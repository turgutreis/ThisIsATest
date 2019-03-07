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
 * A attachment is nothing more than a file name and some content.
 */
public interface Attachment extends IdentifiableRemote {

  /**
   * Get the file name of the attachment.
   * 
   * @return The file name
   * @throws ApiException
   * @throws RemoteException
   */
  String getFileName() throws ApiException, RemoteException;

  /**
   * Set the file name of the attachment. The file name is used to create temporary files when
   * viewing the attachment and will be shown as tooltip in TPT.
   * 
   * @param fileName
   *          The new file name.
   * @throws ApiException
   *           If the new name is empty or null.
   * @throws RemoteException
   */
  void setFileName(String fileName) throws ApiException, RemoteException;

  /**
   * Get the attachment content as a byte array.
   * 
   * @return The attachment content.
   * @throws ApiException
   * @throws RemoteException
   */
  byte[] getContent() throws ApiException, RemoteException;

  /**
   * Set the content of the attachment.
   * 
   * @param content
   *          The new content of the attachment as byte array
   * @throws ApiException
   *           If the new content is <code>null</code>.
   * @throws RemoteException
   */
  void setContent(byte[] content) throws ApiException, RemoteException;

}
