package edu.cmu.cs.cs214.rec11.plugin;

import edu.cmu.cs.cs214.rec11.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec11.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec11.games.TicTacToe;


/**
 * Implements a Tic-Tac-Toe game plug-in based on the GamePlugin interface.
 */
public class TicTacToePlugin implements GamePlugin<TicTacToe.Player> {
    private static final String GAME_NAME = "Tic-Tac-Toe";
    
    private static final int WIDTH = TicTacToe.SIZE;
    private static final int HEIGHT = TicTacToe.SIZE;

    private TicTacToe game;
    private GameFramework framework;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return WIDTH;
    }

    @Override
    public int getGridHeight() {
        return HEIGHT;
    }

    @Override
    public void onRegister(GameFramework f) {
        framework = f;
    }

    @Override
    public void onNewGame() {
        game = new TicTacToe();
    }

    @Override
    public void onNewMove() {
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return game.isOver();
    }

    @Override
    public void onMovePlayed(int x, int y) {
        game.play(x, y);
        framework.setSquare(x, y, game.currentPlayer().toString());
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        TicTacToe.Player winner = game.winner();
        if (winner != null) {
            return "Player " + winner + " wins!";
        } else {
            return "It's a tie!";
        }
    }

    @Override
    public void onGameClosed() {
    }

    @Override
    public TicTacToe.Player currentPlayer() {
        return game.currentPlayer();
    }
}
