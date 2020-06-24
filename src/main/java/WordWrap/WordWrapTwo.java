package WordWrap;

public class WordWrapTwo {

    private final int wordLimit;

    public WordWrapTwo(int wordLimit) {
        this.wordLimit = wordLimit;
    }

    public String wrap(String sentence) {
        if (sentence.length() <= wordLimit) {
            return sentence;
        }

        if (!sentence.contains(" ")) {
            return sentence;
        }

        int index = sentence.substring(0, wordLimit + 1).lastIndexOf(" ");

        if (index < 0) {
            index = sentence.indexOf(" ");
        }

        String head = sentence.substring(0, index);
        String tail = sentence.substring(head.length() + 1);

        return head + "\n" + wrap(tail);
    }
}
