import Lottery.LotteryOddChecker
import Lottery.LotteryTicket
import Lottery.LotteryTicketChecker
import Lottery.WinningNumbers
import spock.lang.Specification

class LotteryOddCheckerSpec extends Specification {

    def "returns prizes won for a random generated ticket"() {
        given:
        def lotteryTickets = []
        3.times {
            lotteryTickets.add(GroovyMock(LotteryTicket))
        }

        and:
        def lotteryTicketChecker = GroovyMock(LotteryTicketChecker)
        lotteryTicketChecker.check(_ as WinningNumbers, _ as LotteryTicket) >>> [
            "no win",
            "free ticket",
            "£10"
        ]

        when:
        def result = new LotteryOddChecker(lotteryTicketChecker).check(Mock(WinningNumbers), lotteryTickets)

        then:
        result == "1x £10\n1x free ticket\n1x no win"
    }
}
