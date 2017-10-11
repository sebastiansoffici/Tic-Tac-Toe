//Sebastian Soffici
//COP3252
//HW3

import java.util.Scanner;
import java.util.Random;
import java.lang.Integer;

class TicTacToe
{
	//variables are board and an int of which player won
	private char[][] array = new char[3][3];
	private int playerwon;
	//board
	public void printboard()
	{

		System.out.println("\tGame Board:\t\tPositions:");
		System.out.printf("\t%c |  %c  | %c\t\t\t 1 |  2  | 3\n", array[0][0], array[0][1], array[0][2]);
		System.out.println("      -------------\t\t\t-------------");	
		System.out.printf("\t%c |  %c  | %c\t\t\t 4 |  5  | 6\n", array[1][0], array[1][1], array[1][2]);
		System.out.println("      -------------\t\t\t-------------");	
		System.out.printf("\t%c |  %c  | %c\t\t\t 7 |  8  | 9\n", array[2][0], array[2][1], array[2][2]);
	}
	//check if they won
	public boolean checkwin()
	{
		for (int i = 0; i < 3; i++)
		{
			if (array[i][0] == array[i][1] && array[i][1] == array[i][2] && array[i][0]!= 0)
			{
				if (array[i][0] == 'X')
					playerwon = 1;
				else
					playerwon = 2;
				return true;
			}
		}
		for (int i = 0; i < 3; i++)
		{
			if (array[0][i] == array[1][i] && array[1][i] == array[2][i] && array[0][i] != 0) 
			{
				if (array[0][i] == 'X')
					playerwon = 1;
				else
					playerwon = 2;
				return true;
			}
		}
		if (array[0][0] == array[1][1] && array[1][1] == array[2][2] && array[0][0] != 0)
		{
			if (array[0][0] == 'X')
				playerwon = 1;
			else
				playerwon = 2;
			return true;
		}
		if (array[2][0] == array[1][1] && array[1][1] == array[0][2] && array[2][0] != 0)
		{
			if (array[2][0] == 'X')
				playerwon = 1;
			else
				playerwon = 2;
			return true;
		}
		return false;
	}
	//check for a tie
	public boolean checktie()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int k = 0; k < 3; k++)
			{
				if (array[i][k] == 0)
					return false;
			}
		}
		if (checkwin() == false)
			return true;
		return false;
	}
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe();
		String temp = new String();
		for (int i = 0; i < args.length; i++)
			temp = temp + args[i];
		switch (temp)
		{ 
		//switch to see what needs to be built.
			case "-c" :
				int x = 1;
				game.playgame(x);
				break;
			case "-c1" :
				x =2;
				game.playgame(x);
				break;
			case  "":
				x = 3;
				game.playgame(x);
				break;
			case "-c2" :
				x = 4;
				game.playgame(x);
				break;
			default : 
				System.out.println( "Usage: java TicTacToe [-c [1|2] ]");
				break;
		}

	}
		
	public void playgame(int x)
	{
		//game loop
		if (x == 1)
		{
			Computer one = new Computer('X', 1);
			Computer two = new Computer ('O', 2);
			printboard();
			while (checkwin() == false)
			{
				one.compmove(array, 'X', 'O');
				System.out.printf("Player %d chooses position %d\n", one.getnum(), one.getselection());
				printboard();
				if (checkwin() == true)	
					break;
				if (checktie() == true)
					break;
				two.compmove(array, 'O', 'X');
				if(checkwin() == true)
					break;
				System.out.printf("Player %d chooses position %d\n", two.getnum(), two.getselection());
				printboard();
			}
		}
		if (x == 2)
		{
			Computer one = new Computer('X', 1);
			Player two = new Player('O', 2);
			printboard();
			while (checkwin() == false)
			{
				one.compmove(array, 'X', 'O');
				System.out.printf("Player %d chooses position %d\n", one.getnum(), one.getselection());
				printboard();
				if(checkwin() == true)
					break;
				if (checktie() == true)
					break;
				System.out.printf("Player %d, please enter a move(1-9): ", two.getnum());
				two.makemove(array, 'O');
				printboard();
			}
		}	
		if (x == 3)
		{
			Player one = new Player('X', 1);
			Player two = new Player('O', 2);
			while (checkwin() == false)
			{
				printboard();
				System.out.printf("Player %d, please enter a move(1-9): ", one.getnum());
				one.makemove(array, 'X');
				printboard();
				if(checkwin() == true)
					break;
				if(checktie() == true)
					break;
				System.out.printf("Player %d, please enter a move(1-9): ", two.getnum());
				two.makemove(array, 'O');
				printboard();
			}
		}
		if (x == 4)
		{
			Player one = new Player('X', 1);
			Computer two = new Computer ('O', 2);
			printboard();
			while (checkwin() == false)
			{
				System.out.printf("Player %d, please enter a move(1-9): ", one.getnum());
				one.makemove(array, 'X');
				printboard();
				if (checkwin() == true)
					break;
				if (checktie() == true)
					break;
				two.compmove(array, 'O', 'X');
				System.out.printf("Player %d chooses position %d\n", two.getnum(), two.getselection());
				printboard();
			}
		}
		if (checkwin() == true)
			System.out.printf("Player %d has won!", playerwon);
		if (checktie() == true)
			System.out.println("The game has ended in a draw.");
	}
}

