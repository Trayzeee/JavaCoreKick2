package com.kondratiev.st.service.impl;

import com.kondratiev.st.component.TextComponentType;
import com.kondratiev.st.component.TextComposite;
import com.kondratiev.st.component.TextComponent;
import com.kondratiev.st.service.TextOperatingService;
import java.util.*;

public class TextOperatingServiceImpl implements TextOperatingService {
  @Override
  public int maxSentencesWithCommonWords(TextComposite text) {
    List<TextComponent> sentences = getSentences(text);
    Map<String, Set<Integer>> wordToSentenceMap = new HashMap<String, Set<Integer>>();

    for (int i = 0; i < sentences.size(); i++) {
      TextComposite sentenceComposite = (TextComposite) sentences.get(i);
      Set<String> words = extractWords(sentenceComposite);

      for (String word : words) {
        Set<Integer> sentenceIndexes = wordToSentenceMap.computeIfAbsent(word, k -> new HashSet<Integer>());
        sentenceIndexes.add(i);
      }
    }

    int max = 0;
    for (Set<Integer> sentenceIndexes : wordToSentenceMap.values()) {
      int size = sentenceIndexes.size();
      if (size > max) {
        max = size;
      }
    }
    return max;
  }

  @Override
  public List<TextComponent> sortByLexemeQuantity(TextComposite text) {
    final List<TextComponent> sentences = getSentences(text);

    Collections.sort(sentences, new Comparator<TextComponent>() {
      @Override
      public int compare(TextComponent o1, TextComponent o2) {
        int c1 = countLexemes((TextComposite) o1);
        int c2 = countLexemes((TextComposite) o2);
        return Integer.compare(c1, c2);
      }
    });

    return sentences;
  }

  @Override
  public void swapBoundaryLexemes(TextComposite text) {
    List<TextComponent> sentences = getSentences(text);

    for (TextComponent sentence : sentences) {
      TextComposite composite = (TextComposite) sentence;
      List<TextComponent> lexemes = new ArrayList<TextComponent>(composite.getComponents());

      if (lexemes.size() > 1) {
        Collections.swap(lexemes, 0, lexemes.size() - 1);
        composite.setComponents(lexemes);
      }
    }
  }

  public List<TextComponent> getSentences(TextComposite text) {
    List<TextComponent> sentences = new ArrayList<TextComponent>();

    for (TextComponent paragraph : text.getComponents()) {
      TextComposite paragraphComposite = (TextComposite) paragraph;
      sentences.addAll(paragraphComposite.getComponents());
    }
    return sentences;
  }

  public Set<String> extractWords(TextComposite sentenceComposite) {
    Set<String> words = new HashSet<String>();

    for (TextComponent lexeme : sentenceComposite.getComponents()) {
      TextComposite lexemeComposite = (TextComposite) lexeme;
      for (TextComponent component : lexemeComposite.getComponents()) {
        if (component.getComponentType() == TextComponentType.WORD) {
          words.add(component.toString().toLowerCase());
        }
      }
    }

    return words;
  }

  public int countLexemes(TextComposite sentenceComposite) {
    return sentenceComposite.getComponents().size();
  }
}
