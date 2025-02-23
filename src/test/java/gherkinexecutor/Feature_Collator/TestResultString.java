package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class TestResultString{
    String name = "";
    String testStatus = "Pass";
    String is_New = "false";
    public TestResultString() { }
    public TestResultString(
        String name
        ,String testStatus
        ,String is_New
        ){
        this.name = name;
        this.testStatus = testStatus;
        this.is_New = is_New;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResultString _TestResultString = (TestResultString) o;
         if (
             !this.name.equals("?DNC?")
                && !_TestResultString.name.equals("?DNC?"))
                return ( _TestResultString.name.equals(this.name));
         if (
             !this.testStatus.equals("?DNC?")
                && !_TestResultString.testStatus.equals("?DNC?"))
                return ( _TestResultString.testStatus.equals(this.testStatus));
         if (
             !this.is_New.equals("?DNC?")
                && !_TestResultString.is_New.equals("?DNC?"))
                return ( _TestResultString.is_New.equals(this.is_New));
             return true;  }
    public static class Builder {
        private String name = "";
        private String testStatus = "Pass";
        private String is_New = "false";
        public Builder name(String name) {
            this.name = name;
            return this;
            }
        public Builder testStatus(String testStatus) {
            this.testStatus = testStatus;
            return this;
            }
        public Builder is_New(String is_New) {
            this.is_New = is_New;
            return this;
            }
        public Builder  setCompare() {
            name = "?DNC?";
            testStatus = "?DNC?";
            is_New = "?DNC?";
            return this;
            }
        public TestResultString build(){
             return new TestResultString(
                 name
                 ,testStatus
                 ,is_New
                );   } 
        } 
    @Override
    public String toString() {
        return "TestResultString {"
        +"name = " + name + " "
        +"testStatus = " + testStatus + " "
        +"is_New = " + is_New + " "
            + "} "; }  
    TestResult toTestResult() throws Exception {
        return new TestResult(
         name
        , TestStatus.valueOf(testStatus)
        , Boolean.parseBoolean(is_New)
        ); }
    }
