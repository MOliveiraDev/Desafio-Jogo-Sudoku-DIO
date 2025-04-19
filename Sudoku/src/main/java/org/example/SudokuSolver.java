package org.example;

public class SudokuSolver {
    //isso será responsável por resolver o sudoku
    public boolean solve(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getCell(row, col) == 0) { // Se a célula estiver vazia
                    for (int num = 1; num <= 9; num++) {
                        if (board.isValidMove(row, col, num)) {
                            board.setCell(row, col, num);
                            if (solve(board)) {
                                return true;
                            }
                            board.setCell(row, col, 0); // backtrack
                        }
                    }
                    return false; // Nenhum número válido encontrado
                }
            }
        }
        return true; // Sudoku resolvido
    }
}
