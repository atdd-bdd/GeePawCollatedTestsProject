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
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResultInInternal _TestResultInInternal = (TestResultInInternal) o;
         return 
                ( _TestResultInInternal.name.equals(this.name))
                 && ( _TestResultInInternal.testStatus.equals(this.testStatus))
                 && ( _TestResultInInternal.is_New == (this.is_New))
             ;  }
    @Override
    public String toString() {
        return "TestResultInInternal {"
        +"name = " + name + " "
        +"testStatus = " + testStatus + " "
        +"is_New = " + is_New + " "
            + "} "; }  
    }
