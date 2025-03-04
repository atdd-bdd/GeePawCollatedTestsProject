package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class ValueValid{
    String value = "";
    String valid = "true";
    String notes = "";
    public ValueValid() { }
    public ValueValid(
        String value
        ,String valid
        ,String notes
        ){
        this.value = value;
        this.valid = valid;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueValid _ValueValid = (ValueValid) o;
         if (
             !this.value.equals("?DNC?")
                && !_ValueValid.value.equals("?DNC?"))
                return ( _ValueValid.value.equals(this.value));
         if (
             !this.valid.equals("?DNC?")
                && !_ValueValid.valid.equals("?DNC?"))
                return ( _ValueValid.valid.equals(this.valid));
         if (
             !this.notes.equals("?DNC?")
                && !_ValueValid.notes.equals("?DNC?"))
                return ( _ValueValid.notes.equals(this.notes));
             return true;  }
    public static class Builder {
        private String value = "";
        private String valid = "true";
        private String notes = "";
        public Builder value(String value) {
            this.value = value;
            return this;
            }
        public Builder valid(String valid) {
            this.valid = valid;
            return this;
            }
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
            }
        public Builder  setCompare() {
            value = "?DNC?";
            valid = "?DNC?";
            notes = "?DNC?";
            return this;
            }
        public ValueValid build(){
             return new ValueValid(
                 value
                 ,valid
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "ValueValid {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    ValueValidInternal toValueValidInternal() throws IllegalArgumentException {
        return new ValueValidInternal(
         value
        , Boolean.parseBoolean(valid)
        , notes
        ); }
    }
