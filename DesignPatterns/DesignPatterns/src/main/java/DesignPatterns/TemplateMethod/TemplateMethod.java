package DesignPatterns.TemplateMethod;

abstract class Game{
    protected int currentPlayer;
    protected final int numberOfPlayer;

    public Game(int numberOfPlayer){
            this.numberOfPlayer = numberOfPlayer;
        }

    public void run(){
        start();
        while (!haveWinner()){
            takeTurn();
        }
        System.out.println("Player " + getWinningPlayer() + " wins");
    }

    protected abstract void start();
    protected abstract void takeTurn();
    protected abstract boolean haveWinner();
    protected abstract int getWinningPlayer();

}

class Chess extends Game{

    private int maxTurns = 10;
    private int turn = 1;
    public Chess(){
        super(2);
    }

    @Override
    protected void start() {
        System.out.println("Starting a game of chess.");
    }

    @Override
    protected void takeTurn() {
        System.out.println("Turn " +(turn++ + " taken by player " + currentPlayer));
        currentPlayer = (currentPlayer + 1) % numberOfPlayer;
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurns;
    }

    @Override
    protected int getWinningPlayer() {
        return 0;
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        new Chess().run();
    }
}
