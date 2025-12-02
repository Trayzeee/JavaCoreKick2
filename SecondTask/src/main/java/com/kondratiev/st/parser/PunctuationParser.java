package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComposite;
import com.kondratiev.st.component.TextComponentType;

public class PunctuationParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite punctuationComposite = new TextComposite(TextComponentType.PUNCTUATION);

        for (char c : text.toCharArray()) {
            punctuationComposite.addComponent(getNextParser().parse(String.valueOf(c)));
        }

        return punctuationComposite;
    }
}
