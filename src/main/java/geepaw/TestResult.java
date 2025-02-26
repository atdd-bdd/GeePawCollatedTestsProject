package geepaw;


    public class TestResult {
        public String name;
       public TestStatus testStatus;
        public boolean isNew;

        public long sequenceNumber;

        public TestResult(
                String name
                , TestStatus testStatus
                , boolean isNew
                , long sequenceNumber
        ) {
            this.name = name;
            this.testStatus = testStatus;
            this.isNew = isNew;
            this.sequenceNumber = sequenceNumber;
        }
//        public TestResult(
//                String name
//                , TestStatus testStatus
//                , boolean isNew
//                , long sequenceNumber
//        ){
//            this.name = name;
//            this.testStatus = testStatus;
//            this.isNew = isNew;
//            this.sequenceNumber = sequenceNumber;
//        }

        @Override
        public String toString() {
            return "TestResult{"
                    + "name = " + name + " "
                    + "testStatus = " + testStatus + " "
                    + "isNew = " + isNew + " "
                    + "sequenceNumber = " + sequenceNumber+ " "                    + "} ";
        }

        public TestResult copy() {
            return new TestResult(name, testStatus, isNew, sequenceNumber);
        }
    }
