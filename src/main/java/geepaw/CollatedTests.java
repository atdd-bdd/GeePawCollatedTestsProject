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
            map.put(testname, new TestResult(current.name, status, false, current.sequenceNumber));
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
            map.put(key, new TestResult(value.name, TestStatus.NotRun, false, value.sequenceNumber));
        }
    }
}
