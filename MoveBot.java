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
public class MoveBot
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        System.out.print( "Enter a starting point and a destination point: ");
        int a = s.nextInt();
        int e = s.nextInt();
        int h = s.nextInt();
        int j = s.nextInt();

        int moves;
        boolean moved;

        int m;
        int n;

        moves = 0;

        while ( a != h || e != j )
        {
            moved = false;
            m = a;
            n = e;

            if ( a != h )
            {
                a++;
                moved = true;
            }

            if ( e != j && !moved )
            {
                e++;
                moved = true;
            }

            System.out.println( "Moved from " + m + ", " + n + " to " + a + ", " + e );
            moves++;
        }

        System.out.println("Robot reached " + h + ", " + j + " in " + moves + " moves");
    }
}
