import Lottery.LotteryTicket
import Lottery.LotteryTicketChecker
import Lottery.WinningNumbers
import spock.lang.Specification
import spock.lang.Unroll

class LotteryTicketCheckerSpec extends Specification {

    def "if no numbers match, returns no match"() {
        given:
        def winningNumbers = new WinningNumbers([1, 2, 3, 4, 5, 6], 7)
        def lotteryTicket = new LotteryTicket([7, 8, 9, 10, 11, 12])

        when:
        def result = new LotteryTicketChecker().check(winningNumbers, lotteryTicket)

        then:
        result == "no match"
    }

    def "if one number matches, return no match"() {
        given:
        def winningNumbers = new WinningNumbers([1,2,3,4,5,6], 7)
        def lotteryTicket = new LotteryTicket([6,8,9,10,11,12])

        when:
        def result = new LotteryTicketChecker().check(winningNumbers, lotteryTicket)

        then:
        result == "no match"
    }

    @Unroll
    def "returns the correct prize for #numbersMatched numbers matched"() {
        given:
        def winningNumbers = new WinningNumbers([1,2,3,4,5,6], 7)

        when:
        def result = new LotteryTicketChecker().check(winningNumbers, new LotteryTicket(lotteryTicket))

        then:
        result == prize

        where:
        numbersMatched | lotteryTicket         | prize
        2              | [1, 2, 9, 10, 11, 12] | "free ticket"
        3              | [1, 2, 3, 10, 11, 12] | "£10"
        4              | [1, 2, 3, 4, 11, 12]  | "£100"
        5              | [1, 2, 3, 4, 5, 12]   | "£1000"
        6              | [1, 2, 3, 4, 5, 6]    | "Jackpot"
    }

    def "if we match 5 numbers and the bonus ball, £10000 is won"() {
        given:
        def winningNumbers = new WinningNumbers([1,2,3,4,5,6], 7)
        def lotteryTicket  = new LotteryTicket([1, 2, 3, 4, 5, 7])

        when:
        def result = new LotteryTicketChecker().check(winningNumbers, lotteryTicket)

        then:
        result == "£10000"
    }
}
