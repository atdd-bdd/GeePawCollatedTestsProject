package gherkinexecutor.Feature_Simple_Test;
import java.util.*;
import geepaw.*;
class ATestInternal{
     Integer anInt;
     String aString;
     Double aDouble;
     
    public static String toDataTypeString() {
        return "ATestInternal {"
        +"Integer " 
        +"String " 
        +"Double " 
            + "} "; }  
    ATest toATest() {
        return new ATest(
        String.valueOf(anInt)
        ,aString
        ,String.valueOf(aDouble)
        ); }
    public ATestInternal(
        Integer anInt
        ,String aString
        ,Double aDouble
        )  {
        this.anInt = anInt;
        this.aString = aString;
        this.aDouble = aDouble;
        }
    @Override
    public String toString() {
        return "ATestInternal {"
        +"anInt = " + anInt + " "
        +"aString = " + aString + " "
        +"aDouble = " + aDouble + " "
            + "} "; }  
    }
