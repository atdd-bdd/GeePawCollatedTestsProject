package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class LogResult{
    String name = "";
    String testStatus = "Abort";
    String notes = "";
    public LogResult() { }
    public LogResult(
        String name
        ,String testStatus
        ,String notes
        ){
        this.name = name;
        this.testStatus = testStatus;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogResult _LogResult = (LogResult) o;
         if (
             !this.name.equals("?DNC?")
                && !_LogResult.name.equals("?DNC?"))
                return ( _LogResult.name.equals(this.name));
         if (
             !this.testStatus.equals("?DNC?")
                && !_LogResult.testStatus.equals("?DNC?"))
                return ( _LogResult.testStatus.equals(this.testStatus));
         if (
             !this.notes.equals("?DNC?")
                && !_LogResult.notes.equals("?DNC?"))
                return ( _LogResult.notes.equals(this.notes));
             return true;  }
    public static class Builder {
        private String name = "";
        private String testStatus = "Abort";
        private String notes = "";
        public Builder name(String name) {
            this.name = name;
            return this;
            }
        public Builder testStatus(String testStatus) {
            this.testStatus = testStatus;
            return this;
            }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
            }
        public Builder  setCompare() {
            name = "?DNC?";
            testStatus = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public LogResult build(){
             return new LogResult(
                 name
                 ,testStatus
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "LogResult {"
        +"name = " + name + " "
        +"testStatus = " + testStatus + " "
        +"notes = " + notes + " "
            + "} "; }  
    LogResultInternal toLogResultInternal() throws Exception {
        return new LogResultInternal(
         name
        , TestStatus.valueOf(testStatus)
        , notes
        ); }
    }
