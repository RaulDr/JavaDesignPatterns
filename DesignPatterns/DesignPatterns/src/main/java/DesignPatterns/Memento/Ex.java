package DesignPatterns.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Token
{
    public int value = 0;

    public Token(int value)
    {
        this.value = value;
    }
}

class MementoEx
{
    public List<Token> tokens = new ArrayList<>();
}

class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public MementoEx addToken(int value)
    {
        return addToken(new Token(value));
    }

    public MementoEx addToken(Token token)
    {
        tokens.add(token);
        MementoEx m = new MementoEx();
        m.tokens = tokens.stream()
                .map(t -> new Token(t.value))
                .collect(Collectors.toList());
        return m;
    }

    public void revert(MementoEx m)
    {
        tokens = m.tokens.stream()
                .map(t -> new Token(t.value))
                .collect(Collectors.toList());
    }
}
public class Ex {
}
