package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class TestResultIn{
    String name = "";
    String testStatus = "Pass";
    String is_New = "false";
    public TestResultIn() { }
    public TestResultIn(
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
        TestResultIn _TestResultIn = (TestResultIn) o;
         if (
             !this.name.equals("?DNC?")
                && !_TestResultIn.name.equals("?DNC?"))
                return ( _TestResultIn.name.equals(this.name));
         if (
             !this.testStatus.equals("?DNC?")
                && !_TestResultIn.testStatus.equals("?DNC?"))
                return ( _TestResultIn.testStatus.equals(this.testStatus));
         if (
             !this.is_New.equals("?DNC?")
                && !_TestResultIn.is_New.equals("?DNC?"))
                return ( _TestResultIn.is_New.equals(this.is_New));
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
        public TestResultIn build(){
             return new TestResultIn(
                 name
                 ,testStatus
                 ,is_New
                );   } 
        } 
    @Override
    public String toString() {
        return "TestResultIn {"
        +"name = " + name + " "
        +"testStatus = " + testStatus + " "
        +"is_New = " + is_New + " "
            + "} "; }  
    TestResultInInternal toTestResultInInternal() throws IllegalArgumentException {
        return new TestResultInInternal(
         name
        , TestStatus.valueOf(testStatus)
        , Boolean.parseBoolean(is_New)
        ); }
    }
