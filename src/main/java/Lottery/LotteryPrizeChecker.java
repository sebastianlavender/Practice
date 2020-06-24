package Lottery;

public class LotteryPrizeChecker {

    public String check(WinningNumbers winningNumbers, LotteryTicket lotteryTicket) {
        Result result = winningNumbers.checkAgainstTicket(lotteryTicket);

        switch (result.getNumbersMatched()) {
            case 2:
                return "free ticket";
            case 3:
                return "£10";
            case 4:
                return "£100";
            case 5:
                if (result.isBonusBallMatched()) {
                    return "£10000";
                }
                return "£1000";
            case 6:
                return "Jackpot";
            default:
                return "no match";
        }
    }
}
