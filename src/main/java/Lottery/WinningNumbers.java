package Lottery;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusBall;

    WinningNumbers(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public Result checkAgainstTicket(LotteryTicket ticket) {
        int matchingNumbers = 0;
        boolean bonusBallMatched = false;

        for (Integer number : ticket.getNumbers()) {
            for (Integer winningNumber : winningNumbers) {
                if (number == winningNumber) {
                    matchingNumbers++;
                }
            }

            if (number == bonusBall) {
                bonusBallMatched = true;
            }
        }

        return new Result(matchingNumbers, bonusBallMatched);
    }
}
