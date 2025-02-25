package gherkinexecutor;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

        public static final boolean inTest = false;  // switch to true for development of Translator
        public static final boolean traceOn = false; // Set to true to see trace
        public static final char spaceCharacters = '~'; // Will replace with space in tables

        public static final String doNotCompare = "?DNC?";  // Value used for not comparing an attribute
        public static String currentDirectory = "";

        public static final String featureSubDirectory = "src/test/java/";
        public static final String packageName = "gherkinexecutor";
        public static final String testSubDirectory = "src/test/java/" + packageName + "/";
        public static final String dataDefinitionFileExtension = "java"; // "tmpl"; // change to java if altering data file

        public static final List<String> linesToAddForDataAndGlue = new ArrayList<>();

        // Must include  semicolon if needed
        static {
            linesToAddForDataAndGlue.add("import java.util.*;");
            linesToAddForDataAndGlue.add("import geepaw.*;");
        }

        public static final List<String> featureFiles = new ArrayList<>();

        static {
            featureFiles.add("collated_tests.feature");
        }
    }

