package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComposite;
import com.kondratiev.st.component.TextComponentType;

public class SentenceParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);

        String[] sentences = text.split(TextRegexPattern.LEXEME_SPLITTER);

        for(String sentence : sentences) {
            sentenceComposite.addComponent(getNextParser().parse(sentence.trim()));
        }
        return sentenceComposite;
    }
}
