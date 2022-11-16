package me.personal.assignment;

import java.util.Scanner;

class Guesser {
	int guessNum;

	int guessNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Guesser, please enter a number ");
		guessNum = scan.nextInt();
		return guessNum;
	}
}

class Player {
	int guessNum;

	int guessNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Player, please enter a number ");
		guessNum = scan.nextInt();
		return guessNum;
	}
}

class Moderator {
	int numFrmGuesser;
	int numFrmP1;
	int numFrmP2;
	int numFrmP3;

	int p1Score;
	int p2Score;
	int p3Score;
	int scoreBuffer;
	int [] a = new int[3]; 
	int[][] arr;

	void getNumFrmGuesser() {
		Guesser g = new Guesser();
		numFrmGuesser = g.guessNumber();

	}

	void getNumFrmPlayer() {

		Player p1 = new Player();
		numFrmP1 = p1.guessNumber();

		Player p2 = new Player();
		numFrmP2 = p2.guessNumber();

		Player p3 = new Player();
		numFrmP3 = p3.guessNumber();

		calculateScore(numFrmP1, numFrmP2, numFrmP3);
		// displayScoreBoard();

	}

	void compare() {

		if (numFrmP1 == numFrmGuesser) {
			if (numFrmP2 == numFrmGuesser && numFrmP3 == numFrmGuesser) {
				declareResult(1, 2, 3);
			} else if (numFrmP2 == numFrmGuesser) {
				declareResult(1, 2);
			} else if (numFrmP3 == numFrmGuesser) {
				declareResult(1, 3);
			} else
				declareResult(1);
		} else if (numFrmP2 == numFrmGuesser) {
			if (numFrmP3 == numFrmGuesser) {
				declareResult(2, 3);
			} else
				declareResult(2);
		} else if (numFrmP3 == numFrmGuesser) {
			declareResult(3);
		} else {
			declareResult();
		}

	}

	void declareResult() {
		System.out.println("No one won the round");
	}

	void declareResult(int a) {
		System.out.println("Player " + a + " won the round");
	}

	void declareResult(int a, int b) {
		System.out.println("Player " + a + " & Player " + b + " won the round");
	}

	void declareResult(int a, int b, int c) {
		System.out.println("Player " + a + " & Player " + b + " & Player " + c + " won the round");
	}

	void calculateScore(int p1, int p2, int p3) {

		arr = new int[3][3];
		
		for (int j = 0; j < 3; j++) {
			if (p1 == numFrmGuesser) {
				p1Score += 10;
				System.out.println("Player1 scored : " + p1Score);
				scoreBuffer = p1Score;
				a[j]=scoreBuffer;j++;
				
			} else {
				p1Score -= 5;
				System.out.println("Player1 scored : " + p1Score);
				scoreBuffer = p1Score;
				a[j]=scoreBuffer;j++;

			}
			if (p2 == numFrmGuesser) {
				p2Score += 10;
				System.out.println("Player2 scored : " + p2Score);
				scoreBuffer = p2Score;
				a[j]=scoreBuffer;j++;
				
			} else {
				p2Score -= 5;
				System.out.println("Player2 scored : " + p2Score);
				scoreBuffer = p2Score;
				a[j]=scoreBuffer;j++;

			}
			if (p3 == numFrmGuesser) {
				p3Score += 10;
				System.out.println("Player3 scored : " + p3Score);
				scoreBuffer = p3Score;
				a[j]=scoreBuffer;j++;

			} else {
				p3Score -= 5;
				System.out.println("Player3 scored : " + p3Score);
				scoreBuffer = p3Score;
				a[j]=scoreBuffer;j++;

			}
		}
		/*
		 * for(int i = 0; i<3;i++) { System.out.println("----->"+a[i]); }
		 */
		for(int m=0;m<3;m++) {
			for(int n=0; n<3;n++) {
				arr[m][n] = a[n];
				//System.out.print("==>>"+arr[m][n]+" ");
				
			}
			m++;
		}
		System.out.println();

	}

	void declareFinalResult() {
		System.out.println("---------------------------------------------");
		if (p1Score > p2Score && p1Score > p3Score) {
			System.out.println("Player1 is the Winner");
		} else if (p2Score > p1Score && p2Score > p3Score) {
			System.out.println("Player2 is the Winner");
		} else if (p3Score > p2Score && p3Score > p1Score) {
			System.out.println("Player3 is the Winner");
		} else if (p1Score == p2Score && p1Score > p3Score) {
			System.out.println("Player 1 & Player 2 are the Winners");
		} else if (p2Score == p3Score && p2Score > p1Score) {
			System.out.println("Player 2 & Player 3 are the Winners");
		} else if (p1Score == p3Score && p3Score > p2Score) {
			System.out.println("Player 1 & Player 3 are the Winners");
		} else {
			System.out.println("All the players are the Winners");
		}

		System.out.println();
		System.out.println(" ~ SCOREBOARD ~ ");
		System.out.print("Player1 :" + p1Score);
		System.out.print("  Player2 :" + p2Score);
		System.out.print("  Player3 :" + p3Score);
		System.out.println();

	}

	void displayScoreBoard() {
		
		System.out.println("--------|------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("Round " + (i + 1) + " | ");
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");

			}
			System.out.println();
		}
	}

}

public class GuesserGame {

	static int numberOfRounds = 3;

	public static void main(String[] args) {
		System.out.println("Welcome to GuesserGame");

		Moderator mod = new Moderator();
		mod.getNumFrmGuesser();
		for (int i = 0; i < numberOfRounds; i++) {
			mod.getNumFrmPlayer();
			mod.compare();
		}
		mod.declareFinalResult();
		//mod.displayScoreBoard();
	}

}
