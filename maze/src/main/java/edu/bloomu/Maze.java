package edu.bloomu;

/**
 * A class that finds and prints all the possible solutions
 * to a user-defined maze of the following form:
 * 
 * 0 = Passage
 * 1 = Wall
 * b = Beginning Point
 * e = Exit
 * p = Path Taken
 * 
 * supplied in a 2D array of chars.
 * 
 * @author fayth quinn
 */

public class Maze
{

	private char[][] maze;
	private int x;
	private int y;
	private int pathNum;

	/**
	 * Initializes a Maze object with a user-supplied maze to be solved
	 * 
	 * @param m The maze to be solved
	 */
	public Maze(char[][] m)
	{
		this.maze = m;
		this.x = 0;
		this.y = 0;
		this.pathNum = 0;
	}

	/**
	 * Returns the current x co-ordinate
	 * 
	 * @return The current x co-ordinate
	 */
	public int getX() { return this.x; }

	/**
	 * Returns the current y co-ordinate
	 * 
	 * @return The current y co-ordinate
	 */
	public int getY() { return this.y; }

	/**
	 * Locates the start of the of the maze and sets x,y equal to its
	 * co-ordinates
	 */
	public void findStart()
	{
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				if (maze[i][j] == 'b')
				{
					this.x = i;
					this.y = j;
					return;
				}
			}
		}
	}

	/**
	 * Provides public interface for solving the maze constructed
	 * 
	 * @param x The x co-ordinate to begin at
	 * @param y The y co-ordinate to begin at
	 */
	public void solve(int x, int y)
	{
		findPath(x, y);
	}

	/**
	 * Recursively searches for every path between the beginning of the maze and
	 * the exit.
	 * 
	 * @param x
	 * @param y
	 */
	private void findPath(int x, int y)
	{
		if (x < 0 || x >= maze.length || y < 0 || y >= maze[x].length || (maze[x][y] != 'b' && maze[x][y] != '0' && maze[x][y] != 'e')) return;

		if (maze[x][y] == 'b')
		{
			findPath(x + 1, y);
			findPath(x, y + 1);
			findPath(x - 1, y);
			findPath(x, y - 1);
		}

		if (maze[x][y] == '0')
		{
			maze[x][y] = 'p';

			findPath(x + 1, y);
			findPath(x, y + 1);
			findPath(x - 1, y);
			findPath(x, y - 1);

			maze[x][y] = '0';
		}

		if (maze[x][y] == 'e')
		{
			System.out.println("\nPath #" + ++pathNum);
			System.out.print(this.toString());
		}
	}

	/**
	 * Prints out the maze board
	 */
	@Override
	public String toString()
	{
		String out = "";

		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{

				if (maze[i][j] == '1')
				{
					out += "\u001B[41m";
				}
				if (maze[i][j] == 'p' || maze[i][j] == 'b' || maze[i][j] == 'e')
				{
					out += "\u001B[42m";
				}

				out += maze[i][j] + "\u001B[40m";
			}
			
			out += "\n";
		}

		return out;
	}

}