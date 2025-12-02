package com.kondratiev.st.parser;

import com.kondratiev.st.component.TextComponent;

public abstract class AbstractTextParser {
    private AbstractTextParser nextParser;

    public void setNextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    public AbstractTextParser getNextParser() {
        return this.nextParser;
    }

    public abstract TextComponent parse(String text);
}
