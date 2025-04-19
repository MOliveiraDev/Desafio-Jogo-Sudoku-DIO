package org.example;

public class Main {
    public static void main(String[] args) {
        SudokuGame game;

        //Escolher a dificuldade do jogo
        if ( args.length > 0 && args[0].equals("easy")) {
            game = new SudokuGame();
        } else if (args.length > 0 && args[0].equals("medium")) {
            game = new SudokuGame();
        } else if (args.length > 0 && args[0].equals("hard")) {
            game = new SudokuGame();
        } else {
            System.out.println("Invalid difficulty level. Starting with default settings.");
            game = new SudokuGame();
        }
        game.startGame();
    }
}