import LatinConverter.LatinConverter
import spock.lang.Specification

class LatinConverterSpec extends Specification {

    def "adds yay to the end of a word if it starts with a vowel"() {
        expect:
        new LatinConverter().convert(word) == convertedWord

        where:
        word       | convertedWord
        "and"      | "andyay"
        "end"      | "endyay"
        "oi"       | "oiyay"
        "igloo"    | "iglooyay"
        "umbrella" | "umbrellayay"
    }

    def "if the word starts with a constant they are moved to end and ay is added"() {
        given:
        def word = "hello"

        when:
        def result = new LatinConverter().convert(word)

        then:
        result == "ellohay"
    }

    def "if the word has no vowels then word is returned with ay at the end"() {
        given:
        def word = "why"

        when:
        def result = new LatinConverter().convert(word)

        then:
        result == "whyay"
    }

    def "if the word ends in a vowel it is returned with ay at the end"() {
        given:
        def word = "the"

        when:
        def result = new LatinConverter().convert(word)

        then:
        result == "ethay"
    }

    def "can convert a whole sentence"() {
        given:
        def word = "I am hungry"

        when:
        def result = new LatinConverter().convert(word)

        then:
        result == "Iyay amyay ungryhay"
    }
}
