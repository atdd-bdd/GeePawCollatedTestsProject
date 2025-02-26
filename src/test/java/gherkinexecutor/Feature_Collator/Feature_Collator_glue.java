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
        for (ValueValid value : values) {
            try {
                ValueValidInternal i = value.toValueValidInternal();
                TestStatus.valueOf(i.value);
            } catch (IllegalArgumentException e) {
                fail(" Invalid value " + value.value);
            }
        }
    }

    void Given_log_contains(List<LogResult> values) {
        for (LogResult value : values) {
                LogResultInternal i = value.toLogResultInternal();
                ct.add(i.name, i.testStatus);
        }
    }

    void When_end_run_results_are(List<TestResultIn> values) {
        List<TestResult> results = ct.endRun();
        List<TestResultInInternal> actuals = new ArrayList<>();
        results.forEach(element -> actuals.add(new TestResultInInternal(element.name,
                element.testStatus, element.isNew)));
        List<TestResultInInternal> expected = new ArrayList<>();
        values.forEach( value ->
                expected.add(value.toTestResultInInternal()));
        assertEquals(expected.size(), actuals.size(), "Size of lists");
        assertEquals(expected, actuals);
    }

}
