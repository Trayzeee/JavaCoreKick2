package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComposite;
import com.kondratiev.st.component.TextComponentType;

public class ParagraphParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);

        String[] paragraphs = text.split(TextRegexPattern.SENTENCE_SPLITTER);

        for(String paragraph : paragraphs) {
            paragraphComposite.addComponent(getNextParser().parse(paragraph));
        }
        return paragraphComposite;
    }
}
