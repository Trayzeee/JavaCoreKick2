package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComposite;
import com.kondratiev.st.component.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);

        Matcher m = Pattern.compile(TextRegexPattern.WORD_OR_PUNCT_SPLITTER).matcher(text);

        while (m.find()) {
            String token = m.group();

            lexemeComposite.addComponent(getNextParser().parse(token));
        }
        return  lexemeComposite;
    }
}
