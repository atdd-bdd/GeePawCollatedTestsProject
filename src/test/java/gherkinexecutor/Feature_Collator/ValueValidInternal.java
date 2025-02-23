package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class ValueValidInternal{
     String value;
     boolean valid;
     String notes;
     
    public static String toDataTypeString() {
        return "ValueValidInternal {"
        +"String " 
        +"boolean " 
        +"String " 
            + "} "; }  
    ValueValid toValueValid() {
        return new ValueValid(
        value
        ,String.valueOf(valid)
        ,notes
        ); }
    public ValueValidInternal(
        String value
        ,boolean valid
        ,String notes
        )  {
        this.value = value;
        this.valid = valid;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueValidInternal _ValueValidInternal = (ValueValidInternal) o;
         return 
                ( _ValueValidInternal.value.equals(this.value))
                 && ( _ValueValidInternal.valid == (this.valid))
                 && ( _ValueValidInternal.notes == (this.notes))
             ;  }
    @Override
    public String toString() {
        return "ValueValidInternal {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    }
