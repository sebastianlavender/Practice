import BinaryGap.BinaryGap
import spock.lang.Specification
import spock.lang.Unroll

class BinaryGapSpec extends Specification {

    //1 -> 1
    //2 -> 10
    //3 -> 11
    //4 -> 100 -> 10
    //5 -> 101 = 1x2^2 + 0x2^1 + 1x2^0 -> 10
    //7 -> 111 -> 11
    //9 -> 1001
    //37 -> 100101
    //

    //count the number of zeros

    @Unroll
    def "if no binary gap exists it should return 0"() {
        expect:
        new BinaryGap().getLargestGap(integer) == result

        where:
        integer | result
        1       | 0
        3       | 0
        7       | 0
    }

    @Unroll
    def "should return a gap of one for the integer five"() {
        expect:
        new BinaryGap().getLargestGap(integer) == result

        where:
        integer | result
        5       | 1
        9       | 2
        17      | 3
    }

    @Unroll
    def "should return 0 if integer binary contains a 0 but no gap"() {
        expect:
        new BinaryGap().getLargestGap(integer) == result

        where:
        integer | result
        2       | 0
        4       | 0
    }

    @Unroll
    def "should find the largest binary gap"() {
        expect:
        new BinaryGap().getLargestGap(integer) == result

        where:
        integer  | result
        0b100101 | 2
    }
}
