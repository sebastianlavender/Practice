package Lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryOddChecker {

    private final LotteryPrizeChecker lotteryPrizeChecker;

    public LotteryOddChecker(LotteryPrizeChecker lotteryPrizeChecker) {
        this.lotteryPrizeChecker = lotteryPrizeChecker;
    }

    public String check(WinningNumbers winningNumbers, List<LotteryTicket> lotteryTickets) {
        Map<String, Integer> results = new HashMap<>();

        for(LotteryTicket ticket : lotteryTickets) {
            results.compute(lotteryPrizeChecker.check(winningNumbers, ticket), (k, v) -> v == null ? 1 : ++v);
        }

        StringBuilder totalPrizes = new StringBuilder();

        for (Map.Entry<String, Integer> prize : results.entrySet()) {
            createTotalPrizesString(totalPrizes, prize);
        }

        deleteTrailingNewLine(totalPrizes);

        return totalPrizes.toString();
    }

    private void deleteTrailingNewLine(StringBuilder totalPrizes) {
        totalPrizes.deleteCharAt(totalPrizes.length() - 1);
    }

    private void createTotalPrizesString(StringBuilder totalPrizes, Map.Entry<String, Integer> prize) {
        totalPrizes.append(prize.getValue().toString())
            .append("x ")
            .append(prize.getKey())
            .append("\n");
    }
}
