package org.example;

import java.util.Scanner;

public class SudokuGame {

        private SudokuBoard board;
        private Scanner scanner;

        public SudokuGame() {
            board = new SudokuBoard();
            scanner = new Scanner(System.in);

        }

        private void initializeBoard() {
            // Preencher o tabuleiro com valores iniciais
            board.setCell(0, 0, 5);
            board.setCell(0, 1, 3);
            board.setCell(0, 4, 7);
            board.setCell(1, 0, 6);
            board.setCell(1, 3, 1);
            board.setCell(1, 4, 9);
            board.setCell(1, 5, 5);
            board.setCell(2, 1, 9);
            board.setCell(2, 2, 8);
            board.setCell(2, 7, 6);
            // Adicione mais valores iniciais conforme necessário
        }

        public void startGame() {
            initializeBoard();
            System.out.println("Sudoku Game Started!");
            while (!board.isSolved()) {
                board.printBoard();
                System.out.print("Enter row (0-8): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-8): ");
                int col = scanner.nextInt();
                System.out.print("Enter value (1-9): ");
                int value = scanner.nextInt();

                if (!board.isFixed(row, col)) {
                    board.setCell(row, col, value);
                } else {
                    System.out.println("This cell is fixed. Choose another cell.");
                }
            }
            System.out.println("Congratulations! You solved the Sudoku!");
            board.printBoard();
            scanner.close();
        }


}
