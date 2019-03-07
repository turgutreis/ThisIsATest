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
import java.util.Collection;
import java.util.List;

import com.piketec.tpt.api.TestCaseExecutionStatus.TestCaseStatus;

/**
 * This object provides an interface to the current state of the test execution.
 * <p>
 * </p>
 * This interface basically represent the information as provided by the Run Progress Dialog.
 *
 * @author Copyright (c) 2014 Piketec GmbH - All rights reserved.
 */
public interface ExecutionStatus extends TptRemote {

  /**
   * @return Indicates whether the test execution is interrupted by user interaction, paused or has
   *         not started yet.
   *
   */
  public boolean isPending() throws ApiException, RemoteException;

  /**
   * @return Indicates whether the test execution is currently running (and not queued, interrupted
   *         or finished).
   *
   */
  public boolean isRunning() throws ApiException, RemoteException;

  /**
   * Cancels the current test execution.
   * <p>
   * The outcome of this operation depends on the platform. In the most cases, the execution of the
   * current test case is finished.
   * </p>
   */
  public void cancel() throws ApiException, RemoteException;

  /**
   * Returns a list containing the execution state ({@link TestCaseExecutionStatus}) for each test
   * case that are part of this test execution.
   *
   * @return A list containing the states of the executed test cases or an empty list, if no test
   *         execution have been started so far.
   */
  public Collection<TestCaseExecutionStatus> getAllTestCases() throws ApiException, RemoteException;

  /**
   * Returns the number of all test cases of the current test execution. Test cases that are part of
   * the test set in more that one {@link ExecutionConfigurationItem} (e.g. in a Back2Back test
   * scenario), will be counted for each {@link ExecutionConfigurationItem} separately.
   *
   * @return Number of total test cases executed
   */
  public int getNumberOfAllTestCases() throws ApiException, RemoteException;

  /**
   * Returns the number of test cases that are part of the current test execution that are currently
   * not finished (with state {@link TestCaseStatus#Pending}).
   * <p>
   * </p>
   * Test cases that are part of the test set in more that one {@link ExecutionConfigurationItem}
   * (e.g. in a Back2Back test scenario), will be counted for each
   * {@link ExecutionConfigurationItem} separately.
   *
   * @return The number of currently not executed test cases.
   */
  public int getNumberOfPendingTestCases() throws ApiException, RemoteException;

  /**
   * Return the test case that is currently running (with the state {@link TestCaseStatus#Running}).
   * 
   * @return The currently executed test case or <code>null</code> if no test case is running.
   */
  public Scenario getCurrentTestCase() throws ApiException, RemoteException;

  /**
   * Returns the current (cumulative) execution state of the overall test execution.
   * <p>
   * The cumulative execution state of all test cases is derived from the following priority (from
   * high to low): ResultError, ResultFailed, ResultUnknown, ResultSuccess, Running, Pending
   * </p>
   * The cumulative state is derived from at highest priority set for at least one of all test
   * cases.
   * 
   * @return The test case execution state with the highest priority.
   * 
   * @throws ApiException
   *           If there are no test in the executed test set.
   */
  public TestCaseStatus getTotalExecutionStatus() throws ApiException, RemoteException;

  /**
   * @return Returns a list of log entries as <code>String</code>
   * @throws ApiException
   * @throws RemoteException
   */
  public List<String> getExecutionLog() throws ApiException, RemoteException;
}
