public enum SentenceBlockType {
    TEXT("[*]"),
    PARAGRAPH("\n"),
    SENTENCE("[.!?]\\s+"),
    WORD("[ <>!#$%&*_+-=,/?;:]"),
    EMAIL("(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*"),
    PHONE("[\\b()-]\\b"),
    MARKER("The trust is out there");

    private String regex;

    private SentenceBlockType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
