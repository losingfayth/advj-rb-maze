package edu.bloomu;

/**
 * Driver for testing Maze class
 */
public class App 
{
    public static void main( String[] args )
    {
        char[][] m =
        {
            {'1','1','1','1','1'},
            {'b','0','0','0','1'},
            {'1','0','1','0','e'},
            {'1','0','0','0','1'},
            {'1','1','1','1','1'},
        };

        char[][] m2 =
        {
            {'1','1','1','1','1','1','1','1','1','1','1'},
            {'1','0','0','0','0','0','1','0','0','0','1'},
            {'1','0','1','0','0','0','1','0','1','0','1'},
            {'e','0','1','0','0','0','0','0','1','0','1'},
            {'1','0','1','1','1','1','1','0','1','0','1'},
            {'1','0','1','0','1','0','0','0','1','0','1'},
            {'1','0','0','0','1','0','1','0','0','0','1'},
            {'1','1','1','1','1','0','1','0','0','0','1'},
            {'1','0','1','b','1','0','1','0','0','0','1'},
            {'1','0','0','0','0','0','1','0','0','0','1'},
            {'1','1','1','1','1','1','1','1','1','1','1'}
        };

        
        Maze maze = new Maze(m);
        maze.findStart();
        maze.solve(maze.getX(), maze.getY());

        System.out.println("\n");

        Maze maze2 = new Maze(m2);
        maze2.findStart();
        maze2.solve(maze2.getX(), maze2.getY());
        

        /**
         * Output:
         * 
         * Path #1
         * 1 1 1 1 1
         * b p 0 0 1
         * 1 p 1 p e
         * 1 p p p 1
         * 1 1 1 1 1
         * 
         * Path #2
         * 1 1 1 1 1
         * b p p p 1
         * 1 0 1 p e
         * 1 0 0 0 1
         * 1 1 1 1 1
         */

    }
}