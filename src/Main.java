import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1.	Implement a program that simulates the game of Craps.
        // Use IntelliJ and if directed GitHub for source control.
        // The computer will display the rolls of the game using random numbers to generate
        // them and will prompt the user to play again.
        // In addition to the die result.
        // The computer will display an interpretation of the results for each roll.

        //The Rules of the Game:
        //a.	There is an initial roll of 2 dice resulting in a sum of 2 – 12.
        //i.	If the sum is 2, 3 or 12 it is called "craps" or "crapping out" and the game is over with a loss.
        //ii.	If the sum is 7 or 11 it is called a ‘natural’ and the game is over with a win.
        //iii.	For all other values, the sum becomes ‘the point’ and the user makes subsequent rolls
        // until they either throw a 7 in which case they loose or they make the point sum in which case they win.
        //b.	After a win or loss the next player rolls the die for a new game.
        // In our simulation, the program will simply ask the user if they want to continue to play.

        //2.	For each roll show the value for each die and the sum.
                //a.	For case i or ii above, indicate that the user either crapped out or won with a natural
                // and then prompt to play again.
                //b.	For case iii indicate that the sum is now the point.
                // For each subsequent roll indicate the status of the result:
                    //i.	Trying for point
                    //ii.	Made point and won.  (Prompt user to play again.)
                    //iii.	Got a seven and lost   (Prompt user to play again.)

        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        do {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("You rolled a " + die1 + " and a " + die2 + ", with a total of " + sum + ".");
            if (sum == 2 || sum == 3 || sum == 12) { //crapping out, player loses
                System.out.println("Unfortunately a sum of " + sum + " means you've crapped out and lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Congrats, with a sum of " + sum + " you've rolled a natural and win.");
            } else {
                System.out.println(sum + " is now the point, good luck rolling it again.");
                int point = sum;
                boolean currentGameEnd = false;
                do {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled a " + die1 + " and a " + die2 + ", with a total of " + sum + ".");
                    if (sum == 7){
                        System.out.println("You've rolled a 7, unfortunately that means you've lost.");
                        currentGameEnd = true;
                    } else if (sum == point){
                        System.out.println("Congrats, you've made the point and won.");
                        currentGameEnd = true;
                    }else{
                        System.out.println("You rolled a " + sum + ", the point is " + point + " better luck next roll.");
                    }
                }while (!currentGameEnd);

            }
            System.out.println("Would you like to play again? Y or N");
            String check = in.nextLine();
            if (!(check.equalsIgnoreCase("y"))){
                cont = false;
            }

        } while (cont);



    }
}