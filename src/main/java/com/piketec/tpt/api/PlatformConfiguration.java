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

import com.piketec.tpt.api.properties.Property;
import com.piketec.tpt.api.properties.PropertyMap;

/**
 * This object represents a configuration for a specific platform adapter.
 * <p>
 * The particular properties of the various platforms are mapped to a generic {@link PropertyMap}.
 * </p>
 * 
 * @author Copyright (c) 2014 Piketec GmbH - All rights reserved.
 */
public interface PlatformConfiguration extends NamedObject, PlatformOrExecutionItemEnabler {

  /**
   * Type String for ADTF Platform
   */
  public static final String ADTF_PLATFORM_TYPE = "adtf";

  /**
   * Type String for ASCET Platform
   */
  public static final String ASCET_PLATFORM_TYPE = "ascet";

  /**
   * Type String for ASCET@FUSION Platform
   */
  public static final String ASCET_AT_FUSION_PLATFORM_TYPE = "ascet2";

  /**
   * Type String for AUTOSAR Platform
   */
  public static final String AUTOSAR_PLATFORM_TYPE = "autosar";

  /**
   * Type String for Assessment Platform
   */
  public static final String ASSESSMENT_PLATFORM_TYPE = "assessment";

  /**
   * Type String for CANoe Platform
   */
  public static final String CANOE_PLATFORM_TYPE = "canoe";

  /**
   * Type String for CTB Platform
   */
  public static final String CTB_PLATFORM_TYPE = "daimler-ctb";

  /**
   * Type String for Concurrent HiL Platform
   */
  public static final String CONCURRENT_HIL_PLATFORM_TYPE = "concurrent-hil";

  /**
   * Type String for EXE Platform
   */
  public static final String EXE_PLATFORM_TYPE = "exe";

  /**
   * Type String for FUSION Platform
   */
  public static final String FUSION_PLATFORM_TYPE = "fusion";

  /**
   * Type String for LABCAR Platform
   */
  public static final String LABCAR_PLATFORM_TYPE = "labcar";

  /**
   * Type String for MATLAB/Simulink Platform
   */
  public static final String MATLAB_SIMULINK_PLATFORM_TYPE = "matlab";

  /**
   * Type String for RADARCAN Platform
   */
  public static final String RADARCAN_PLATFORM_TYPE = "radarcan";

  /**
   * Type String for Silver Platform
   */
  public static final String SILVER_PLATFORM_TYPE = "silver";

  /**
   * Type String for Simulink Real-Time Platform
   */
  public static final String SIMULINK_REAL_TIME_PLATFORM_TYPE = "matlab-rt";

  /**
   * Type String for Stand-alone Platform
   */
  public static final String STAND_ALONE_PLATFORM_TYPE = "stand-alone";

  /**
   * Type String for VW / Audi Platform
   */
  public static final String VW_AUDI_PLATFORM_TYPE = "vw-audi";

  /**
   * Type String for VeriStand Platform
   */
  public static final String VERISTAND_PLATFORM_TYPE = "veristand";

  /**
   * Type String for dSPACE HiL Platform
   */
  public static final String DSPACE_HIL_PLATFORM_TYPE = "dspace-hil";

  /**
   * Type String for dSPACE HiL@FUSION Platform
   */
  public static final String DSPACE_HIL_AT_FUSION_PLATFORM_TYPE = "dspaceXil";

  /**
   * Type String for dSPACE HiL@FUSION Platform
   */
  public static final String FEP = "fep";

  public String getType() throws ApiException, RemoteException;

  /**
   * @return Returns the platform timeout in microseconds.
   *
   */
  public long getTimeOut() throws ApiException, RemoteException;

  /**
   * Set the platform timeout.
   * 
   * @param timeOut
   *          Timeout in microseconds.
   *
   */
  public void setTimeOut(long timeOut) throws ApiException, RemoteException;

  /**
   * @return Returns the step size of the platform in microseconds.
   *
   */
  public long getStepSize() throws ApiException, RemoteException;

  /**
   * Set the step size for the platform.
   * 
   * @param stepSize
   *          Step size in microseconds.
   *
   */
  public void setStepSize(long stepSize) throws ApiException, RemoteException;

  /**
   * @return Returns the size of the ring buffer (history) that is used to enable access to signal
   *         values of preceding steps of a test case.
   *
   */
  public int getHistorySize() throws ApiException, RemoteException;

  /**
   * Set the size of the ring buffer (history) that is used to enable access to signal values of
   * preceding steps of a test case.
   * 
   * @param historySize
   *          The new size of the history in steps.
   */
  public void setHistorySize(int historySize) throws ApiException, RemoteException;

  /**
   * Returns the properties of the platform adapter as {@link PropertyMap}.
   * <p>
   * A PropertyMap maps the properties as follows: {@link String} -&gt; {@link Property}. A
   * <code>Property</code> is either a <code>ProperyMap</code> or a <code>String</code> value.
   * </p>
   * The structure of the PropertyMap depends on the type of the platform adapter.
   * 
   * @return A {@link com.piketec.tpt.api.properties.PropertyMap PropertyMap} with the settings for
   *         the platform adapter.
   */
  public PropertyMap getProperties() throws ApiException, RemoteException;

  /**
   * Set the configuration for the platform adapter via {@link PropertyMap}.
   * <p>
   * Since an incomplete <code>PropertyMap</code> could lead to unpredictable behavior, it is
   * generally recommended to modify the <code>PropertyMap</code> returned by
   * {@link #getProperties()}.
   * </p>
   * 
   * @param properties
   *          A PropertyMap for the respective platform adapter.
   */
  public void setProperties(PropertyMap properties) throws ApiException, RemoteException;

  /**
   * Run a function of this particular platform adapter (e.g., import-interface, ...). The available
   * functions depend on the actual platform represented by this object. Some platforms do not have
   * functions.
   * <p>
   * The function is identified by its name. The {@link PropertyMap} can be used to provide
   * additional parameters to the function.
   * </p>
   * If the function name is unknown or if the <code>PropertyMap</code> does not match the expected
   * structure, an {@link ApiException} is invoked. Often exception message contains a hint which
   * functions are available.
   * 
   * @param functionName
   *          Name of the function to be invoked
   * @param parameterOrNull
   *          A <code>PropertyMap</code> representing the function arguments or <code>null</code>
   * @throws ApiException
   *           If the function is not available or the PropertyMap is invalid for the invoked
   *           function.
   */
  public void invoke(String functionName, PropertyMap parameterOrNull)
      throws ApiException, RemoteException;

}
