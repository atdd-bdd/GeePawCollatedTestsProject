package gherkinexecutor.Feature_Collator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Feature_Collator{


    @Test
    void test_Scenario_Domain_Term_TestStatus(){
         Feature_Collator_glue feature_Collator_glue_object = new Feature_Collator_glue();

        List<ValueValid> objectList1 = List.of(
             new ValueValid.Builder()
                .value("Pass")
                .notes("")
                .build()
            , new ValueValid.Builder()
                .value("Fail")
                .notes("")
                .build()
            , new ValueValid.Builder()
                .value("Disable")
                .notes("")
                .build()
            , new ValueValid.Builder()
                .value("Abort")
                .notes("Status has not been seen")
                .build()
            , new ValueValid.Builder()
                .value("NotRun")
                .notes("test was not run in prior run")
                .build()
            );
        feature_Collator_glue_object.Star_Outcomes(objectList1);
        }
    @Test
    void test_Scenario_Two_Runs(){
         Feature_Collator_glue feature_Collator_glue_object = new Feature_Collator_glue();

        List<LogResult> objectList1 = List.of(
             new LogResult.Builder()
                .name("TestA")
                .testStatus("Pass")
                .notes("isNew will be true")
                .build()
            , new LogResult.Builder()
                .name("TestB")
                .testStatus("Fail")
                .notes("isNew will be true")
                .build()
            );
        feature_Collator_glue_object.Given_log_contains(objectList1);

        List<TestResultIn> objectList2 = List.of(
             new TestResultIn.Builder()
                .name("TestA")
                .testStatus("Pass")
                .is_New("true")
                .build()
            , new TestResultIn.Builder()
                .name("TestB")
                .testStatus("Fail")
                .is_New("true")
                .build()
            );
        feature_Collator_glue_object.When_end_run_results_are(objectList2);

        List<LogResult> objectList3 = List.of(
             new LogResult.Builder()
                .name("TestC")
                .testStatus("Pass")
                .notes("new test, will be last in report")
                .build()
            , new LogResult.Builder()
                .name("TestA")
                .testStatus("Fail")
                .notes("old test, status changed")
                .build()
            );
        feature_Collator_glue_object.Given_log_contains(objectList3);

        List<TestResultIn> objectList4 = List.of(
             new TestResultIn.Builder()
                .name("TestA")
                .testStatus("Fail")
                .is_New("false")
                .build()
            , new TestResultIn.Builder()
                .name("TestB")
                .testStatus("NotRun")
                .is_New("false")
                .build()
            , new TestResultIn.Builder()
                .name("TestC")
                .testStatus("Pass")
                .is_New("true")
                .build()
            );
        feature_Collator_glue_object.When_end_run_results_are(objectList4);
        }
    }

