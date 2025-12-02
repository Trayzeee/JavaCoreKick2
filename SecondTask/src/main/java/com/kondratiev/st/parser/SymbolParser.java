package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComponentType;
import com.kondratiev.st.component.TextLeaf;

public class SymbolParser extends AbstractTextParser {

    @Override
    public TextComponent parse(String text) {
        return new TextLeaf(text.charAt(0), TextComponentType.SYMBOL);
    }
}
