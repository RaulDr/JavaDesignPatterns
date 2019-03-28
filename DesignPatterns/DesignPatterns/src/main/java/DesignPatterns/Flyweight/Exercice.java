package DesignPatterns.Flyweight;

import java.util.*;

class Sentence
{

    private String[] words;
    private HashMap<Integer, WordToken> wordTokens = new HashMap<>();

    public Sentence(String plainText)
    {
        words = plainText.split(" ");
    }

    public WordToken getWord(int index)
    {
        WordToken wordToken = new WordToken();
        wordTokens.put(index, wordToken);
        return wordTokens.get(index);
    }

    @Override
    public String toString()
    {
        ArrayList<String> ws = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            if(wordTokens.containsKey(i) && wordTokens.get(i).capitalize){
                w = w.toUpperCase();
            }
            ws.add(w);
        }
        return String.join(" ", ws);
    }

    class WordToken
    {
        public boolean capitalize;
    }
}

public class Exercice {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("hello world");
        sentence.getWord(1).capitalize = true;
        System.out.println(sentence);
    }
}
