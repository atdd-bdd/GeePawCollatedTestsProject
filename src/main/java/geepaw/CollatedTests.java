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
        }
    }

    public List<TestResult> endRun() {
        // If TestResult had clone() method, this could be shorter
        List<TestResult> list = new ArrayList<>();
        for (Map.Entry<String, TestResult> entry : map.entrySet()){
            TestResult current = entry.getValue();
            list.add(new TestResult(current.name, current.testStatus, current.isNew, current.sequenceNumber));
             }
        list.sort(Comparator.comparingLong(testResult -> testResult.sequenceNumber));
        setupForNextRun();
        return list;
    }

    void setupForNextRun() {
        for (String key : map.keySet()){
            TestResult value = map.get(key);
            value.testStatus = TestStatus.NotRun;
            value.isNew = false;
        }
    }
}
