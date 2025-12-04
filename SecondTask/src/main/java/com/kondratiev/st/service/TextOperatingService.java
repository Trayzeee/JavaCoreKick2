package com.kondratiev.st.service;

import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.component.TextComposite;
import java.util.List;

public interface TextOperatingService {
  int maxSentencesWithCommonWords(TextComposite text);
  List<TextComponent> sortByLexemeQuantity(TextComposite text);
  void swapBoundaryLexemes(TextComposite text);
}
