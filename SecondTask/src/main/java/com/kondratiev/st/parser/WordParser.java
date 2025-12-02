package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComposite;
import com.kondratiev.st.component.TextComponentType;

public class WordParser extends AbstractTextParser{

    @Override
    public TextComponent parse(String text) {

        if (!text.matches(TextRegexPattern.WORD_SPLITTER)) {
            return getNextParser().parse(text);
        }

        TextComposite wordComposite = new TextComposite(TextComponentType.WORD);

        for (char c : text.toCharArray()) {
            wordComposite.addComponent(getNextParser().parse(String.valueOf(c)));
        }

        return wordComposite;
    }
}
