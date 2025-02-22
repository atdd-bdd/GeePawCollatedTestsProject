package gherkinexecutor.Feature_Collator;
import java.util.*;
import geepaw.*;
class DomainTermValues{
    String value = "";
    String valid = "true";
    String notes = "";
    public DomainTermValues() { }
    public DomainTermValues(
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
        DomainTermValues _DomainTermValues = (DomainTermValues) o;
         if (
             !this.value.equals("?DNC?")
                && !_DomainTermValues.value.equals("?DNC?"))
                return ( _DomainTermValues.value.equals(this.value));
         if (
             !this.valid.equals("?DNC?")
                && !_DomainTermValues.valid.equals("?DNC?"))
                return ( _DomainTermValues.valid.equals(this.valid));
         if (
             !this.notes.equals("?DNC?")
                && !_DomainTermValues.notes.equals("?DNC?"))
                return ( _DomainTermValues.notes.equals(this.notes));
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
        public DomainTermValues build(){
             return new DomainTermValues(
                 value
                 ,valid
                 ,notes
                );   } 
        } 
    @Override
    public String toString() {
        return "DomainTermValues {"
        +"value = " + value + " "
        +"valid = " + valid + " "
        +"notes = " + notes + " "
            + "} "; }  
    DomainTermValuesInternal toDomainTermValuesInternal() throws Exception {
        return new DomainTermValuesInternal(
         value
        , Boolean.parseBoolean(valid)
        , notes
        ); }
    }
