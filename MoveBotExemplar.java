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
public class MoveBotExemplar
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

        // first move along X axis.
        int movesX = moveAlongAxis( startX, endX, startY, true );

        // now move along Y axis
        int movesY = moveAlongAxis( startY, endY, endX, false );

        // print out final result
        System.out.println( "Robot reached " + endX + ", " + endY + " in " + (movesX + movesY) + " moves." );
    }

    /**
     * This function moves the robot along one of the axis, either east-west (the x axis)
     * or north-south (the y axis).
     *
     * @param start the starting coordinate - either the x or y value
     * @param end the ending coordinate - must be x if start was x, or y if start was y
     * @param other the constant coordinates - must be y if start was x, or x if start was y
     * @param xDirection true if we are moving in the X direction, false if we are moving in the Y direction
     *
     * @return the number of moves the robot made in the specified direction
     */
    private static int moveAlongAxis( int start, int end, int other, boolean xDirection )
    {
        // determine direction to move.  if end is before start, then we need to move backwards
        int direction;
        if ( start < end )
        {
            direction = 1;
        }
        else
        {
            direction = -1;
        }

        // initialize move counter
        int moves = 0;

        // make a move along the axis until we reach the coordinate we want
        while ( start != end )
        {
            // save the original starting coordinate so we can print it later
            int original = start;

            // make the move
            start += direction;
            moves++;

            // we need to pay attention to which direction we were moving to ensure
            // we print out the coordinates properly
            if ( xDirection )
            {
                System.out.println( "Moved from " + original + ", " + other + " to " + start + ", " + other );
            }
            else
            {
                System.out.println( "Moved from " + other + ", " + original + " to " + other + ", " + start );
            }
        }

        // return total number moves in this direction
        return moves;
    }
}
