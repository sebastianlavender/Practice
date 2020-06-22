public class WordWrapThree {

    private final int lineLimit;

    public WordWrapThree(int lineLimit) {
        this.lineLimit = lineLimit;
    }
    public String wrap(String sentence) {
        StringBuilder correctedSentence = new StringBuilder(sentence);
        int index = 0;

        while (index + lineLimit < correctedSentence.length()) {
            if (!correctedSentence.substring(index, index + lineLimit).contains(" ")) {
                index += 1;
            } else {
                index = correctedSentence.lastIndexOf( " ", index + lineLimit);
                correctedSentence.replace(index, index + 1, "\n");
            }
        }

        return correctedSentence.toString();
    }
}
