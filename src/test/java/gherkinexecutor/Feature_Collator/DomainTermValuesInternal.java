package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class DomainTermValuesInternal{
     String value;
     boolean valid;
     String notes;
     
    public static String toDataTypeString() {
        return "DomainTermValuesInternal {"
        +"String " 
        +"boolean " 
        +"String " 
            + "} "; }  
    DomainTermValues toDomainTermValues() {
        return new DomainTermValues(
        value
        ,String.valueOf(valid)
        ,notes
        ); }
    public DomainTermValuesInternal(
        String value
        ,boolean valid
        ,String notes
        )  {
        this.value = value;
        this.valid = valid;
        this.notes = notes;
        }
    @Override
    public String toString() {
        return "DomainTermValuesInternal {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    }
