package gherkinexecutor.Feature_Collator;

import geepaw.CollatedTests;
import geepaw.TestResult;
import geepaw.TestStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class Feature_Collator_glue {

    CollatedTests ct = new CollatedTests();

    void Star_Outcomes(List<ValueValid> values) {
        System.out.println("---  " + "Star_Outcomes");
        for (ValueValid value : values) {
            try {
                ValueValidInternal i = value.toValueValidInternal();
                TestStatus.valueOf(i.value);
            } catch (Exception e) {
                fail(" Invalid value " + value.value);
            }
        }
    }

    void Given_log_contains(List<LogResult> values) {
        System.out.println("---  " + "Given_log_contains");
        for (LogResult value : values) {
            System.out.println(value);
            try {
                LogResultInternal i = value.toLogResultInternal();
                System.out.println(i);
                ct.add(i.name, i.testStatus);
            } catch (Exception e) {
                System.err.println("Argument Error " + value.toString() + LogResultInternal.toDataTypeString());
            }
        }

    }

    void When_end_run_results_are(List<TestResultIn> values) {
        System.out.println("---  " + "When_end_run_results_are");
        List<TestResult> results = ct.endRun();
        System.out.println(" **** Actuals ");
        System.out.println(results);
        List<TestResultInInternal> actuals = new ArrayList<>();
        for (TestResult element : results) {
            actuals.add(new TestResultInInternal(element.name, element.testStatus, element.isNew));
        }
        System.out.println("Actuals converted ");
        System.out.println(actuals);
        System.out.println("**** Expected ****");
        System.out.println(values);
        List<TestResultInInternal> expected = new ArrayList<>();
        for (TestResultIn value : values) {
            try {
                expected.add(value.toTestResultInInternal());
            } catch (Exception e) {
                System.err.println("Invalid value in " + value + " " + TestResultInInternal.toDataTypeString());
            }
        }
        System.out.println("Expected converted");
        System.out.println(expected);
        assertEquals(expected.size(), actuals.size(), "Size of lists");
        assertEquals(expected, actuals);
    }

}
