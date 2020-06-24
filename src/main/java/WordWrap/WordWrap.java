package WordWrap;

public class WordWrap {
    private final int maxLineLength;

    public WordWrap(int maxLineLength) {
        this.maxLineLength = maxLineLength;
    }

    public String split(String sentence) {
        StringBuilder sb = new StringBuilder(sentence);
        int index = sb.indexOf(" ");

        while (index != -1) {
            if (index >= maxLineLength) {
                sb.replace(index, index + 1, "\n");
            }

            index = sb.indexOf(" ", index + 1);
        }

        return sb.toString();
    }
}
