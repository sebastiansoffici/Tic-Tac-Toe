//Sebastian Soffici
//COP 3252
//HW3


import java.util.Random;
import java.lang.Integer;
import java.util.Scanner;

class Player
{
	//class player, built to be a little more portable then needed
	char token;
	int playnum;	
	//constructor
	public Player(char x, int y)
	{
		token = x;
		playnum = y;
	}
	public int getnum()
	{	return playnum;	}
	//human move, detects if a cell is being used through a switch and some if statements
	public char[][] makemove(char arr[][], char y)
	{
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		switch (x) 
		{
			case 1:
				if (arr[0][0] == 0)
					arr[0][0] = y;
				else
				{
					System.out.print("Invalid cell: already use. Select a valid cell: ");
					makemove(arr, y);
				}
				break;
	
			case 2:
				if (arr[0][1] == 0)
					arr[0][1] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;
	
			case 3:
				if (arr[0][2] == 0)
					arr[0][2] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;


			case 4:
				if (arr[1][0] == 0)
					arr[1][0] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;

			case 5:
				if (arr[1][1] == 0)
					arr[1][1] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;


			case 6:
				if (arr[1][2] == 0)
					arr[1][2] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;

			case 7:
				if (arr[2][0] == 0)
					arr[2][0] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;

			case 8:
				if (arr[2][1] == 0)
					arr[2][1] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;


			case 9:
				if (arr[2][2] == 0)
					arr[2][2] = y;
				else	
				{
					System.out.print("Invalid cell: already used. Select a valid cell: ");
					makemove(arr, y);
				}
				break;
			default:
				System.out.print("Invalid cell: out of range. Select a valid cell: ");
				makemove(arr, y);
				break;
		}
		return arr;
	}
}
class Computer extends Player
{
	//class computer
	private int selection;
	public Computer(char x, int y)
	{
		super(x, y);
	}
	//to set what move the comp made
	public void setselection(int x, int y)
	{
		if (x == 0)
			selection = x + y + 1;
		if (x == 1)
			selection = x + y + 3;
		if (x == 2)
			selection = x + y + 5;
	}
	public int getselection()
	{	return selection;	}
	public char[][] compmove(char arr[][], char y, char x)
	{
		//check to see if you can win
		for (int i = 0; i < 3; i++)
			if (arr[0][i] == arr[1][i] && arr[0][i] != 0 && arr[2][i] ==0)
			{
				arr[2][i] = y;
				setselection(2, i);
				return arr;
			}


		for (int i = 0; i < 3; i++)
			if (arr[2][i] == y && arr[1][i] == y && arr[0][i] ==0)
			{
				arr[0][i] = y;
				setselection(0, i);
				return arr;
			}
		for (int i = 0; i < 3; i++)
			if (arr[i][0] == y && arr[i][1] == y && arr[i][2] ==0)
			{	
				arr[i][2] = y;
				setselection(i, 2);
				return arr; 
			}
		for (int i = 0; i < 3; i++)
			if (arr[i][2] == y && arr[i][1] == y && arr[i][0] ==0)
			{	
				arr[i][0] = y;
				setselection (i, 0);
				return arr;
			} 


		if (arr[0][0] == y && arr[1][1] == y && arr[2][2] == 0)
		{
			arr[2][2] = y;
			setselection(2, 2);
			return arr;
		}
		if (arr[2][2] == y && arr[1][1] == y && arr[0][0] == 0)
		{	
			arr[0][0] = y;
			setselection(0,0);
			return arr;
		}
		if (arr[0][0] == y && arr[2][2] == y && arr[1][1] == 0)
		{	
			arr[1][1] = y;
			setselection(1,1);
			return arr;
		}
		if (arr[0][2] == y && arr[1][1] == y && arr[2][0] == 0)
		{	
			arr[2][0] = y;
			setselection(2, 0);
			return arr;
		}
		if (arr[2][0] == y && arr[1][1] == y && arr[0][2] == 0)
		{	
			arr[0][2] = y;
			setselection(0,2);
			return arr;
		}
		if (arr[2][0] == y && arr[0][2] == y && arr[1][1] == 0)
		{
			arr[1][1] = y;
			setselection(1, 1);
			return arr;
		}
		if (arr[1][1] == y && arr[0][2] == 0 && arr[2][0] == 0)
		{
			arr[0][2] = y;
			setselection(0, 2);
			return arr;
		}
		//blocks

		for (int i = 0; i < 3; i++)
			if (arr[i][0] == x && arr[i][1] == x && arr[i][2] == 0)
			{
				arr[i][2] = y;
				setselection(i, 2);
				return arr;
			}
	
		for (int i = 0; i < 3; i++)
			if (arr[2][i] == x && arr[1][i] == x && arr[0][i] ==0)
			{
				arr[0][i] = y;
				setselection(0, i);
				return arr;
			}
		for (int i = 0; i < 3; i++)
			if (arr[i][0] == x && arr[i][1] == x && arr[i][2] ==0)
			{	
				arr[i][2] = y; 
				setselection(i, 2);
				return arr;
			}
		for (int i = 0; i < 3; i++)
			if (arr[i][2] == x && arr[i][1] == x && arr[i][0] ==0)
			{	
				arr[i][0] = y;
				setselection(i, 0);
				return arr;
			}
 
		if (arr[0][0] == x && arr[1][1] == x && arr[2][2] == 0)
		{
			arr[2][2] = y;
			setselection(2, 2);
			return arr;
		}
		if (arr[2][2] == x && arr[1][1] == x && arr[0][0] == 0)
		{	
			arr[0][0] = y;
			setselection(0, 0);
			return arr;
		}
		if (arr[0][0] == x && arr[2][2] == x && arr[1][1] == 0)
		{	
			arr[1][1] = y;
			setselection(1, 1);
			return arr;
		}
		if (arr[0][2] == x && arr[1][1] == x && arr[2][0] == 0)
		{	
			arr[2][0] = y;
			setselection(2, 0);
			return arr;
		}
		if (arr[2][0] == x && arr[1][1] == x && arr[0][2] == 0)
		{	
			arr[0][2] = y;
			setselection(0, 2);
			return arr;
		}
		if (arr[2][0] == x && arr[0][2] == x && arr[1][1] == 0)
		{
			arr[1][1] = y;
			setselection(1, 1);
			return arr;
		}
		if (arr[0][0] != 0 && arr[0][1] != 0 && arr[0][2] != 0 && arr[1][0] != 0 && arr[1][1] != 0 && arr[1][2] != 0 && arr[2][0] != 0 && arr[2][1] == 0 && arr[2][2] != 0)
		{
			arr[2][1] = y;
			setselection (2, 1);
			return arr;
		}

		if (arr[1][1] == 0)
		{
			arr[1][1] = y;
			setselection(1, 1);
			return arr;
		}
		//random input if all else doesn't apply
		int j = 0;
		while (j==0)
		{
			int k = 0;
			int l = 0;
			Random rand = new Random();
			k = rand.nextInt(2);
			l = rand.nextInt(2);
			if (arr[k][l]== 0)
			{
				arr[k][l] = y;
				setselection(k, l);
				return arr;
			}
			else
				j = 0;
		}
		return arr;
	}
}
