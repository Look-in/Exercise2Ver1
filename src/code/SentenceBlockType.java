package code;

public enum SentenceBlockType {
    //separators
    TEXT("[*]"),
    PARAGRAPH("(?<=[\n])"),
    SENTENCE("(?<=[.!?])(?=\\s)"),
    WORD("[ <>!#$%&*_+=,/?;:]"),
    //String matches
    EMAIL("(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*"),
    PHONE("(8?)\\(\\d{3}\\)\\d{3}-?\\d{2}-?\\d{2}"),
    WHITESPACE("\\s"),
    NUMERIC("(\\+|-)?([0-9]+(\\.[0-9]+))"),
    MARKER("[<>!#$%&*_+-=,/?;:]");

    private String regex;

    SentenceBlockType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
