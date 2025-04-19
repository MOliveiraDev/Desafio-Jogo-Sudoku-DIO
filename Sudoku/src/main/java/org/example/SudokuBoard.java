package org.example;

public class SudokuBoard {

    private int[][] board;
    private boolean [][] fixedCells;

    public SudokuBoard (){
        board = new int[9][9];
        fixedCells = new boolean[9][9]; // isso seria para marcar as casas que já estão preenchidas
    }

    public void setCell(int row, int col, int value) {
        if (isValidMove(row, col, value)) {
            board[row][col] = value;
            fixedCells[row][col] = true; // marca a célula como fixa
        } else {
            System.out.println("Invalid move");
        }
    }

    public int getCell(int row, int col) {
        return board[row][col];
    }

    public boolean isFixed (int row, int col) {
        return fixedCells[row][col];
    }

    private boolean isValidMove(int row, int col, int value) {
        // Verifica se o valor já está na linha
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // Verifica se o valor já está na coluna
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // Verifica se o valor já está no quadrante 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false; // Se encontrar uma célula vazia, o tabuleiro não está resolvido
                }
            }
        }
        return true; // Se não houver células vazias, o tabuleiro está resolvido
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
