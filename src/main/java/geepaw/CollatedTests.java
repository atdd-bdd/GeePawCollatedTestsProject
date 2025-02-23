package geepaw;

import java.util.*;

public class CollatedTests {
    Map<String, TestResult> map = new HashMap<>();

    // Notes:  could use LinkedHashMap to retain the order,
    // Then no need for sequenceNumber
    // But sequenceNumber could be replaced by TimeStamp
    // if that were useful.

    // Should the constructor for TestResult do the sequenceNumber assignment?
    public void add(String testname, TestStatus status) {
        if (!map.containsKey(testname)) {
            map.put(testname, new TestResult(testname, status, true, SequenceNumber.next()));
        } else {
            TestResult current = map.get(testname);
            current.testStatus = status;
            current.isNew = false;
        }
    }

    public List<TestResult> endRun() {
        List<TestResult> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingLong(testResult -> testResult.sequenceNumber));
        setupForNextRun();
        return list;
    }

    void setupForNextRun() {
        for (String key : map.keySet()){
            TestResult value = map.get(key);
            // This changes the value in the list that is returned.
          //  value.testStatus = TestStatus.NotRun;
            map.put(key, new TestResult(value.name, TestStatus.NotRun, false, value.sequenceNumber));
        }
    }
}
