package com.kondratiev.st.parser;

final class TextRegexPattern {
    static final String PARAGRAPH_SPLITTER = "(\\R{2,})";
    static final String SENTENCE_SPLITTER = "(?<=[.!?])\\s+";
    static final String LEXEME_SPLITTER = "\\s+";
    static final String WORD_OR_PUNCT_SPLITTER = "(\\p{L}+|\\p{Punt})";
    static final String WORD_SPLITTER = "\\p{L}+";

    private TextRegexPattern() {}
}
