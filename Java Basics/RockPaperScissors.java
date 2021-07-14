/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author armaandhanoa
 */

import java.lang.Math;
import java.util.Scanner;

public class RockPaperScissors {
    final static int MAX_ROUNDS = 10, MIN_ROUNDS = 1;
    public static int promptNumOfRounds(Scanner input){
        System.out.println("How many rounds would you like to play? Please enter a number between 1 and 10 inclusive.");
        boolean isValid = false;
        int rounds = 0;
        do {
            try{
                rounds = input.nextInt();
            }
            catch(NumberFormatException Ex){
                System.err.println("Not a number");
            }
            if(rounds < 1 || rounds > 10){
                System.out.println("Number of rounds must be between 1 and 10 inclusive.");
            }
            else{
                isValid = true;
            }
        }while(!isValid);
        return  rounds;
    }
          
    public static int playRound(Scanner input){
        String options[] = {"Rock", "Paper", "Scissors"};
        
        boolean isValid = false;
        int userChoice = 0;
        do {
            System.out.println("Rock(1), paper(2), or scissors(3)?");
            try{
                userChoice = input.nextInt();
            }
            catch(NumberFormatException Ex){
                System.err.println("Not a number");
            }
            if(userChoice < 1 || userChoice > 3){
                System.out.println("Please enter a number between 1 and 3 inclusive.");
            }
            else{
                isValid = true;
            }
        }while(!isValid);
        
        int cpu = (int)(Math.random() * 3);
        
        System.out.println("CPU played " + options[cpu]);
        if( (userChoice == cpu + 1) || ( userChoice == 1 && cpu == 3)){
            System.out.println("Round won!\n");
            return 1;
        }
        else if (userChoice == cpu){
            System.out.println("Draw\n");
            return 0;
        }
        else
            System.out.println("Round lost\n");
        return -1;
    }
         
    public static void main(String[] args) {
        int wins = 0, losses = 0, draws = 0;
        Scanner userInput = new Scanner(System.in);
        
        int numOfRounds = promptNumOfRounds(userInput);
        
        int record[] = new int[numOfRounds];
        
        for(int i = MIN_ROUNDS; i <= numOfRounds; i++){
            System.out.println("Playing round " + i);
            record[i - 1] = playRound(userInput);
        }
        for(int i = 0; i < numOfRounds; i++){
            if(record[i] == 1)
                wins++;
            else if(record[i] == -1)
                losses++;
            else
                draws++;
        }
        
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws + "\n");
        
        if(wins > losses)
            System.out.println("User wins!");
        else if(losses > wins)
            System.out.println("CPU wins!");
        else
            System.out.println("Draw");
    }
}
