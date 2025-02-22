package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class LogResultInternal{
     String name;
     TestStatus testStatus;
     String notes;
     
    public static String toDataTypeString() {
        return "LogResultInternal {"
        +"String " 
        +"TestStatus " 
        +"String " 
            + "} "; }  
    LogResult toLogResult() {
        return new LogResult(
        name
        ,testStatus.toString()
        ,notes
        ); }
    public LogResultInternal(
        String name
        ,TestStatus testStatus
        ,String notes
        )  {
        this.name = name;
        this.testStatus = testStatus;
        this.notes = notes;
        }
    @Override
    public String toString() {
        return "LogResultInternal {"
        +"name = " + name + " "
        +"testStatus = " + testStatus + " "
        +"notes = " + notes + " "
            + "} "; }  
    }
