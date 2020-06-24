import Lottery.LotteryOddChecker
import Lottery.LotteryTicket
import Lottery.LotteryTicketChecker
import Lottery.WinningNumbers
import spock.lang.Specification

class LotteryOddCheckerSpec extends Specification {

    def "returns prizes won for a random generated ticket"() {
        given:
        def lotteryTickets = []
        4.times {
            lotteryTickets.add(Mock(LotteryTicket))
        }

        and:
        def lotteryTicketChecker = Mock(LotteryTicketChecker)
        lotteryTicketChecker.check(_ as WinningNumbers, _ as LotteryTicket) >>> [
            "no win",
            "free ticket",
            "no win",
            "£10"
        ]

        when:
        def result = new LotteryOddChecker(lotteryTicketChecker).check(Mock(WinningNumbers), lotteryTickets)

        then:
        result == "1x £10\n1x free ticket\n2x no win"
    }
}
