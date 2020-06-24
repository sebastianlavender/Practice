package Lottery;

public class Result {

    private final int numbersMatched;
    private final boolean bonusBallMatched;

    public Result(int numbersMatched, boolean bonusBallMatched) {
        this.numbersMatched = numbersMatched;
        this.bonusBallMatched = bonusBallMatched;
    }

    public int getNumbersMatched() {
        return numbersMatched;
    }

    public boolean isBonusBallMatched() {
        return bonusBallMatched;
    }
}
