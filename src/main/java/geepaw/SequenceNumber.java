package geepaw;

public class SequenceNumber {

    // Could be replace by TimeStamp
    static long currentNumber = 1;
    public static long next() {
        currentNumber++;
        return currentNumber;
    }
}
