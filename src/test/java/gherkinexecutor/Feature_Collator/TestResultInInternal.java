package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class TestResultInInternal{
     String name;
     TestStatus testStatus;
     boolean is_New;
     
    public static String toDataTypeString() {
        return "TestResultInInternal {"
        +"String " 
        +"TestStatus " 
        +"boolean " 
            + "} "; }  
    TestResultIn toTestResultIn() {
        return new TestResultIn(
        name
        ,testStatus.toString()
        ,String.valueOf(is_New)
        ); }
    public TestResultInInternal(
        String name
        ,TestStatus testStatus
        ,boolean is_New
        )  {
        this.name = name;
        this.testStatus = testStatus;
        this.is_New = is_New;
        }
    @Override
    public String toString() {
        return "TestResultInInternal {"
        +"name = " + name + " "
        +"testStatus = " + testStatus + " "
        +"is_New = " + is_New + " "
            + "} "; }  
    }
