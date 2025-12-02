package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComposite;
import com.kondratiev.st.component.TextComponentType;

public class WholeTextParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite textComposite = new TextComposite(TextComponentType.TEXT);

        String[] paragraphs = text.strip().split(TextRegexPattern.PARAGRAPH_SPLITTER);

        for (String paragraph : paragraphs) {
            textComposite.addComponent(getNextParser().parse(paragraph));
        }

        return textComposite;
    }
}
