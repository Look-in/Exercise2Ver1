/*
 * Copyright (c) 2018.
 * shankunassv
 */

package code;

public enum TextBlockType {
    //separators
    TEXT("[*]"),
    PARAGRAPH("(?<=[\n])"),
    SENTENCE("(?<=[.!?])(?=\\s)"),
    WORD("[ <>!#$%&*_+=,/?;:]"),
    //String matches
    EMAIL("(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*"),
    PHONE("(8?)\\(\\d{3}\\)\\d{3}-?\\d{2}-?\\d{2}"),
    WHITESPACE("\\s"),
    IPADDRESS("([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])(\\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])){3}"),
    NUMERIC("(\\+|-)?([0-9]+(\\.[0-9]+))"),
    MARKER("[<>!#$%&*_+-=,/?;:]");

    private String regex;

    TextBlockType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}

