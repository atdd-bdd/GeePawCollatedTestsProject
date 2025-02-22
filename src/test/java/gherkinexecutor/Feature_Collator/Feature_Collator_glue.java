package gherkinexecutor.Feature_Collator;

import geepaw.CollatedTests;
import geepaw.TestResult;
import geepaw.TestStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class Feature_Collator_glue {

    CollatedTests ct = new CollatedTests();

    void Star_Outcomes(List<DomainTermValues> values) {
        System.out.println("---  " + "Star_Outcomes");
        for (DomainTermValues value : values) {
            try {
                DomainTermValuesInternal i = value.toDomainTermValuesInternal();
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
        System.out.println(results);
        for (TestResultIn value : values) {
            System.out.println(value);
        }
        boolean compare = compareLists(results, values);
        if (!compare) fail("Lists do not compare");
    }

    private boolean compareLists(List<TestResult> results, List<TestResultIn> expected) {
        // Compare the lists element by element
        if (results.size() == expected.size()) {
            for (int i = 0; i < expected.size(); i++) {
                TestResult element = results.get(i);
                TestResultInInternal actualIn = new TestResultInInternal(element.name, element.testStatus, element.isNew);
                TestResultIn actual = actualIn.toTestResultIn();
                TestResultIn expect = expected.get(i);
                if (!expect.equals(actual)) {
                    System.err.println(" For index in list " + i + expect + " " + actualIn);
                    return false;
                }

            }
        } else {
            System.err.println("Lists are of different sizes.");
            return false;
        }
        return true;
    }
}

