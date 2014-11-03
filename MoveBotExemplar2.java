import java.util.Scanner;

/**
 * This program moves a robot from a starting set of coordinates
 * to an ending set of coordinates.  The robot can only move in
 * one direction each move: either the x direction (east-west)
 * or the y direction (north-south).  The program prints each
 * move as the robot moves.  At the end, the program prints out
 * the number of moves it took for the robot to reach its final
 * position.
 */
public class MoveBotExemplar2
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );

        // read input coordinates
        System.out.print( "Enter a starting point and a destination point: ");

        int startX = in.nextInt();
        int startY = in.nextInt();

        int endX = in.nextInt();
        int endY = in.nextInt();

        int moves = 0;

        // first move along X axis.
        int direction = computeDirection( startX, endX );
        while ( startX != endX )
        {
            int original = startX;
            startX += direction;
            moves++;
            System.out.println( "Moved from " + original + ", " + startY + " to " + startX + ", " + startY );
        }

        // now move along Y axis
        direction = computeDirection( startY, endY );
        while ( startY != endY )
        {
            int original = startY;
            startY += direction;
            moves++;
            System.out.println( "Moved from " + startX + ", " + original + " to " + startX + ", " + startY );
        }

        // print out final result
        System.out.println( "Robot reached " + endX + ", " + endY + " in " + moves + " moves." );
    }

    /**
     * Computes the step we want to take on each move.  This is positive one if we need
     * to move from west to east or south to north. Or, this is negative one if we need to
     * move from east to west or north to south.
     *
     * @param start the starting x or y coordinate
     * @param end the ending matching x or y coordinate
     *
     * @return +1 if we need to move up or to the right; -1 if we need to move down or to the left.
     */
    private static int computeDirection( int start, int end )
    {
        if ( start < end )
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
