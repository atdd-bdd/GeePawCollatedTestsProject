package geepaw;

import java.util.*;

public class CollatedTests {
    DataStorage ds = new DataStorage();
    public void add(String testName, TestStatus testStatus) {
        if (ds.currentlyExist(testName)) {
            ds.update(testName, testStatus);
        } else {
            ds.create(testName, testStatus);
        }
    }

    public List<TestResult> endRun() {
        List<TestResult> list = new ArrayList<>();

        ds.getTestNames().forEach(testName -> list.add(ds.read(testName)));

        list.sort(Comparator.comparingLong(testResult -> testResult.sequenceNumber));

        setupForNextRun();
        return list;
    }

    void setupForNextRun() {
        ds.getTestNames().forEach(testName ->
            ds.update(testName, TestStatus.NotRun, false));
    }

    static class DataStorage {
        // Notes:  could use LinkedHashMap to retain the order,
        // Then no need for sequenceNumber
        // But sequenceNumber could be replaced by TimeStamp
        // if that were useful.
        Map<String, TestResult> map = new HashMap<>();

        private Set<String> getTestNames() {
            return map.keySet();
        }

        private void create(String testName, TestStatus status) {
            map.put(testName, new TestResult(testName, status, true, SequenceNumber.next()));
        }

        private TestResult read(String testName) {
            return map.get(testName).copy();
        }

        private void update(String key, TestStatus testStatus, boolean isNew) {
            TestResult value = map.get(key);
            value.testStatus = testStatus;
            value.isNew = isNew;
        }

        private void update(String key, TestStatus testStatus) {
            TestResult value = map.get(key);
            value.testStatus = testStatus;
        }

        private boolean currentlyExist(String testName) {
            return map.containsKey(testName);
        }
    }


}
