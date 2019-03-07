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
package com.piketec.tpt.api.steplist;

import java.rmi.RemoteException;

import com.piketec.tpt.api.ApiException;
import com.piketec.tpt.api.RemoteList;
import com.piketec.tpt.api.Scenario;
import com.piketec.tpt.api.Testlet;

/**
 * A <code>StepListScenario</code> contains a list of {@link Step steps} and can be a variant of a
 * {@link Testlet}.
 * 
 * @see Testlet#createSLVariant(String, com.piketec.tpt.api.ScenarioGroup)
 */
public interface StepListScenario extends Scenario {

  /**
   * @return The list of {@link Step Steps} in their given order.
   */
  public RemoteList<Step> getSteps() throws ApiException, RemoteException;

  /**
   * Create a step of a given type at the given position.
   * 
   * @param index
   *          Indicates the position where the new step shall be inserted in the step list
   *          represented by this object.
   * @param type
   *          The type of the newly created Step as String
   * @return The newly created Step.
   * @throws ApiException
   *           If the given <code>type</code> does not exist.
   */
  public Step createStep(int index, String type) throws ApiException, RemoteException;

  /**
   * Set the do assessment variable from a step list scenario. When it is set to true, all the
   * compare steps will be considered during the execution, otherwise they will be ignored. If the
   * variable is set to false, it will automatically deactivate the report always variable.
   * 
   * @param active
   *          true if the do assessment variable should be turned on.
   * @throws ApiException
   *           If the scenario is not a step list scenario
   * @throws RemoteException
   */
  void setDoAssessment(boolean active) throws ApiException, RemoteException;

  /**
   * Get the value from the do assessment variable for the given scenario.
   * 
   * @return True if the do assessment variable is on, otherwise false.
   * @throws ApiException
   * @throws RemoteException
   */
  boolean isDoAssessment() throws ApiException, RemoteException;

  /**
   * Set the report always variable from a step list scenario. When it is set to true, all the
   * compare steps will be appear in the report, otherwise they will be ignored. If this variable is
   * set to true, it will automatically activate the do assessment variable.
   * 
   * @param active
   *          true if the report always variable should be turned on.
   * @throws ApiException
   *           If the scenario is not a step list scenario
   * @throws RemoteException
   */
  void setReportAlways(boolean active) throws ApiException, RemoteException;

  /**
   * Get the value from the report always variable for the given scenario.
   * 
   * @return True if the report always variable is on, otherwise false.
   * @throws ApiException
   * @throws RemoteException
   */
  boolean isReportAlways() throws ApiException, RemoteException;

}
