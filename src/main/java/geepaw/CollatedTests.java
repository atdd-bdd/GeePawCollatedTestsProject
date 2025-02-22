package geepaw;

import java.util.*;

public class CollatedTests {
    Map<String, TestResult> map = new HashMap<>();

    // Notes:  could use LinkedHashMap to retain the order,
    // Then no need for sequenceNumber
    // But sequenceNumber could be replaced by TimeStamp
    // if that were useful.
    public void add(String testname, TestStatus status) {
        if (!map.containsKey(testname)) {
            map.put(testname, new TestResult(testname, status, true, SequenceNumber.next()));
        } else {
            TestResult current = map.get(testname);
            current = new TestResult(current.name, current.testStatus, false, current.sequenceNumber);
        }
    }

    public List<TestResult> endRun() {
        List<TestResult> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingLong(testResult -> testResult.sequenceNumber));
        setupForNextRun();
        return list;
    }

    void setupForNextRun() {
        map.forEach((key, value) -> map.put(key, new TestResult(value.name, value.testStatus, false, value.sequenceNumber)));
    }
}
