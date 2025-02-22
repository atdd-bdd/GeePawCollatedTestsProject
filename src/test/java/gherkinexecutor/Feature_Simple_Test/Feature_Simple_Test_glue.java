package gherkinexecutor.Feature_Simple_Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class Feature_Simple_Test_glue {


    void Given_table_is(List<ATest> values ) {
        System.out.println("---  " + "Given_table_is");
        for (ATest value : values){
            System.out.println(value);
            try {
                ATestInternal i = value.toATestInternal();
                System.out.println(i);
            }
            catch(Exception e){
                System.err.println("Argument Error " + value.toString() + ATestInternal.toDataTypeString());
            }
        }
        fail("Must implement");
    }

}
