package com.aurionpro.test;

import java.util.Scanner;

public class TicTacToe {
	private char[][] board;
	private char currentPlayer;

	public TicTacToe() {
		board = new char[3][3];
		currentPlayer = 'X';

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void play() {
		boolean gameFinished = false;
		int moves = 0;
		Scanner sc = new Scanner(System.in);

		while (!gameFinished) {
			displayBoard();
			System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;

			if (isValidMove(row, col)) {
				makeMove(row, col);

				if (isWinningMove(row, col)) {
					displayBoard();
					System.out.println("Player " + "'" + currentPlayer + "'" + " won!");
					gameFinished = true;
				} else if (moves == 8) {
					displayBoard();
					System.out.println("It's a draw!");
					gameFinished = true;
				} else {
					currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
					moves++;
				}
			} else {
				System.out.println("Invalid move. Please try again.");
			}
		}

	}

	private boolean isValidMove(int row, int col) {
		return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
	}

	private void makeMove(int row, int col) {
		board[row][col] = currentPlayer;
	}

	private boolean isWinningMove(int row, int col) {
		if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
			return true;
		}

		if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
			return true;
		}

if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
				|| (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
			return true;
		}

		return false;
	}

	private void displayBoard() {
		System.out.println("-------------");

		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println("\n-------------");
		}
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.play();
	}
}
