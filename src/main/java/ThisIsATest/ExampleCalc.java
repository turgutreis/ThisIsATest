package ThisIsATest;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;
import java.util.List;

import com.piketec.tpt.api.*;
import com.piketec.tpt.api.TestCaseExecutionStatus.TestCaseStatus;
import com.piketec.tpt.api.properties.PropertyMap;

public class ExampleCalc {

// TODO: Adjust the file path
    /**
     * The TPT-File to load. Adjust this to an valid one!
     */
    private static final File TPT_FILE = new File("C:\\Users\\Andalusien\\Desktop\\TPT\\TPT\\tpt.tptz");

    private static final String HOST = "localhost";

    private static final int PORT = 1099;

    private static final String BINDING_NAME = "TptApi";

    public static void main(String[] args) {
        if (!(TPT_FILE.exists() && TPT_FILE.isFile())) {
            System.out.println("Please check that the field TPT_FILE points to a valid file");
            return;
        }
        try {
            Registry registry = LocateRegistry.getRegistry(HOST, PORT); // get Server/RMI-Registry
            TptApi remoteApi = (TptApi)registry.lookup(BINDING_NAME); // get TPT-API
            OpenResult openResult = remoteApi.openProject(TPT_FILE.getAbsoluteFile()); // open attached
            // tpt-File
            Project project = openResult.getProject(); // recieve the now open project

            RemoteCollection<ExecutionConfiguration> executionConfigurations =
                    project.getExecutionConfigurations();
            for (PlatformConfiguration pCfg : project.getPlatformConfigurations().getItems()) {
                PropertyMap properties = pCfg.getProperties();
                System.out.println(properties);
                System.out.println("------------------------------------------------");
            }
            for (ExecutionConfiguration execCfg : executionConfigurations.getItems()) {
                System.out.println("//// Running execution configuration " + execCfg.getName() + " ////");
                ExecutionStatus execStatus = remoteApi.run(execCfg); // execute the execution configuration

                while (execStatus.isPending()) { // wait so the execution has a chance to start
                    Thread.sleep(10000);
                }

                int pending;
                int size = execStatus.getAllTestCases().size();
                while (execStatus.isRunning()) {
                    pending = execStatus.getNumberOfPendingTestCases();
                    // print some status information
                    System.out.println(size - pending + " von " + execStatus.getNumberOfAllTestCases());
                    System.out.println(testCasesToStatusString(execStatus.getAllTestCases()));
                    System.out.println("Total Status: " + execStatus.getTotalExecutionStatus());
                    if (pending <= 2) { // cacel showcase: don't execute last 2 testcases (3rd last execution
                        // is likely to be interrupted and fails in this case)
                        System.out.println();
                        System.out.println("//////////////////////////");
                        System.out.println("//// CANCEL EXECUTION ////");
                        System.out.println("//////////////////////////");
                        System.out.println();
                        execStatus.cancel();
                    } else {
                        Thread.sleep(10000);
                    }
                }

                for (TestCaseExecutionStatus testCaseExecutionStatus : execStatus.getAllTestCases()) {
                    if (testCaseExecutionStatus.getStatus() == TestCaseExecutionStatus.TestCaseStatus.ResultSuccess) {
                        System.out.println(
                                "[Success] test case: \"" + testCaseExecutionStatus.getTestcase().getName() + "\"");
                        printStringList(testCaseExecutionStatus.getStatusLog());
                    }

                }

                // print the logs for failed testcases
                System.out.println();
                System.out.println("//// Printing logs of failed Testcases ////");
                for (TestCaseExecutionStatus testCaseExecutionStatus : execStatus.getAllTestCases()) {
                    if (testCaseExecutionStatus.getStatus() == TestCaseExecutionStatus.TestCaseStatus.ResultError
                            || testCaseExecutionStatus.getStatus() == TestCaseExecutionStatus.TestCaseStatus.ResultFailed) {
                        System.out.println(
                                "[FAILED] test case: \"" + testCaseExecutionStatus.getTestcase().getName() + "\"");
                        printStringList(testCaseExecutionStatus.getStatusLog());
                    }

                }
                System.out.println();
            }

            project.closeProject(); // close the project

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    /*
    File input = new File("C:\\Users\\Andalusien\\Desktop\\TPT\\TPT\\testdata\\summary.pdf");
    Desktop desktop = Desktop.getDesktop();
    try {
      desktop.open(input);
    } catch (IOException e) {
      e.printStackTrace();
    }
    */
    }

    private static String testCasesToStatusString(Collection<TestCaseExecutionStatus> stati) {
        StringBuilder sb = new StringBuilder();
        for (TestCaseExecutionStatus status : stati) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            try {
                sb.append(status.getStatus().toString());
            } catch (ApiException | RemoteException e) {
                sb.append("<error>");
            }
        }
        return sb.toString();
    }

    private static void printStringList(List<String> list) {
        for (String str : list) {
            System.out.println("   " + str);
        }
    }


}
