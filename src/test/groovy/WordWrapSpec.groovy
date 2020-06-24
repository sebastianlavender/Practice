import WordWrap.WordWrap
import spock.lang.Specification
import spock.lang.Unroll

class WordWrapSpec extends Specification {

    @Unroll
    def "a single word won't be split across lines"() {
        given: "a sentence"
        def sentence = "hello"

        when: "the sentence is split"
        def result = new WordWrap(maxLineLength).split(sentence)

        then: "a split sentence is returned"
        result == returnedSentence

        where:
        maxLineLength | returnedSentence
        5             | "hello"
        3             | "hello"
    }

    @Unroll
    def "a sentence will be split based on the max line length"() {
        expect:
        new WordWrap(maxLineLength).split(sentence) == returnedSentence

        where:
        sentence            | maxLineLength | returnedSentence
        "hello world"       | 5             | "hello\nworld"
        "hello hello world" | 5             | "hello\nhello\nworld"
        "one two three"     | 7             | "one two\nthree"
    }
}
