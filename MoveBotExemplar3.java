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
public class MoveBotExemplar3
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );

        System.out.print( "Enter a starting point and a destination point: " );
        int startX = in.nextInt();
        int startY = in.nextInt();
        int endX   = in.nextInt();
        int endY   = in.nextInt();

        // initialize move counter to zero
        int moves = 0;

        // compute a step value that we move along the X axis to our destination
        int directionX = computeDirection( startX, endX );

        // compute a step value that we move along the Y axis to our destination
        int directionY = computeDirection( startY, endY );

        // loop as long as we are not there
        while ( startX != endX || startY != endY )
        {
            // save original points so we can print them
            int originalX = startX;
            int originalY = startY;

            // first we move along the X axis until we are at the correct
            // X coordinate, then we will move along the Y axis until we are there.
            if ( startX != endX )
            {
                startX += directionX;
            }
            else
            {
                startY += directionY;
            }

            System.out.println( "Moved from " + originalX + ", " + originalY + " to " + startX + ", " + startY );
            moves++;
        }

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
