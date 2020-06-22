import spock.lang.Specification

@Newify(WordWrapThree)
class WordWrapThreeSpec extends Specification {

    def "a word under the maximum line length will return the word"() {
        given:
        def sentence = "abc"

        when:
        def result = WordWrapThree(10).wrap(sentence)

        then:
        result == sentence
    }

    def "a sentence larger than the maximum line length will split the sentence"() {
        given:
        def sentence = "abcde abcde"

        when:
        def result = WordWrapThree(10).wrap(sentence)

        then:
        result == "abcde\nabcde"
    }

    def "a sentence with more than two words larger than the maximum line length will split the sentence correctly"() {
        given:
        def sentence = "abcd efg hij"

        when:
        def result = WordWrapThree(5).wrap(sentence)

        then:
        result == "abcd\nefg\nhij"
    }

    def "a word longer than the maximum line length returns the word"() {
        given:
        def sentence = "abc"

        when:
        def result = WordWrapThree(2).wrap(sentence)

        then:
        result == sentence
    }

    def "a sentence contains a word longer than the maximum line length will split the sentence correctly"() {
        given:
        def sentence = "a bcd"

        when:
        def result = WordWrapThree(2).wrap(sentence)

        then:
        result == "a\nbcd"
    }

    def "a sentence with multiple spaces below the maximum line length"() {
        given:
        def sentence = "ab bc"

        when:
        def result = WordWrapThree(5).wrap(sentence)

        then:
        result == sentence
    }

    def "a sentence with multiple spaces should split correctly"() {
        given:
        def sentence = "ab bc def"

        when:
        def result = WordWrapThree(5).wrap(sentence)

        then:
        result == "ab bc\ndef"
    }

    def "a sentence with multiple spaces should split when over line limit"() {
        given:
        def sentence = "abcabcabc abc"

        when:
        def result = WordWrapThree(6).wrap(sentence)

        then:
        result == "abcabcabc\nabc"
    }
}
