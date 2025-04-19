package org.example;

import java.util.Random;

public class SudokuGenerator {

    private SudokuBoard board;
    private Random random;

    public SudokuGenerator() {
        board = new SudokuBoard();
        random = new Random();
    }

    public SudokuBoard generatePuzzle(int difficulty) {
        //criar uma solução valida
        solveRandomBoard(0, 0);
        int cellsToRemove = 45 + (difficulty * 5);

        // Remover células aleatórias
        while (cellsToRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (board.getCell(row, col) != 0) {
                board.setCell(row, col, 0);
                cellsToRemove--;
            }
        }

        // Preencher as células vazias com números aleatórios
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board.getCell(i, j) == 0){
                    board.setCell(i, j, random.nextInt(9) + 1);
                }
            }
        }
        return board;
    }

    private boolean solveRandomBoard(int row, int col){
        if (row == 9) {
            return true;
        }
        if (col == 9) {
            return solveRandomBoard(row + 1, 0);
        }
        if (board.getCell(row, col) != 0) {
            return solveRandomBoard(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (board.isValidMove(row, col, num)) {
                board.setCell(row, col, num);
                if (solveRandomBoard(row, col + 1)) {
                    return true;
                }
                board.setCell(row, col, 0); // backtrack
            }
        }
        return false;

    }

    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
