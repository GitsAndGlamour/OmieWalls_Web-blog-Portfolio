/**********************************************************
 * ThreeCardPoker.java
 * CS251
 * 
 * This class allows a user to play multiple hands 
 * of three card poker against a computer player.
 **********************************************************/

import java.util.Arrays;
import java.util.Scanner;

public class ThreeCardPoker 
{	
	public static void main(String[] args) 
	{	
		int[] deckValues = new int[52];
		char[] deckSuits = new char[52];
		
		int[] userValues = new int[3];
		char[] userSuits = new char[3];
		
		int[] computerValues = new int[3];
		char[] computerSuits = new char[3];
		
		int numUserWins = 0;
		int numComputerWins = 0;
		int numTies = 0;
		int winner;
		
		Scanner stdIn = new Scanner(System.in);
		String playAgain = "y";
		
		initializeDeck(deckValues, deckSuits);
		printWelcomeScreen();
		
		//loop responsible for allowing play of multiple games
		while(playAgain.equalsIgnoreCase("y")) {
			//TODO: implement loop body
			
			//shuffle and deal
			shuffleDeck(deckValues, deckSuits);
			deal(deckValues,  deckSuits,  userValues,  userSuits,  computerValues,  computerSuits); 
			//print hands to the screen
			System.out.println("Your hand:\n==========");
			printHand(userValues, userSuits);
			System.out.println("\nComputer's hand:\n===============");
			printHand(computerValues, computerSuits);
			//determine winner
			winner = determineWinner(userValues, userSuits, computerValues, computerSuits);
			switch(winner){
			case 1:
				++numUserWins;
				System.out.println("\nYou win!");
				break;
			case -1: 
				++numComputerWins;
				System.out.println("\nComputer wins!");
				break;
			case 0:
				++numTies;
				System.out.println("\nYou tied!");
				break;
			}
			//prompt user to play again
			playAgain = playAgain(playAgain, stdIn);
		}
		//print game session statistics
		printStatistics(numUserWins, numComputerWins, numTies);
		stdIn.close();
	}
	/*
	 *  This method prints a welcome screen
	 */
	public static void printWelcomeScreen() {
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("+ Welcome to Three Card Poker !!! +");
		System.out.println("+++++++++++++++++++++++++++++++++++\n");
	}
	public static void initializeDeck(int[] deckValues, char[] deckSuits) 
	{
		int c = 0;
		
		for(int i=2; i<=14; i++) {
			deckValues[c] = i;
			deckSuits[c++] = 'C';
			deckValues[c] = i;
			deckSuits[c++] = 'D';
			deckValues[c] = i;
			deckSuits[c++] = 'H';
			deckValues[c] = i;
			deckSuits[c++] = 'S';
		}
	}
	/*
	 *  This method shuffles the deck
	 */
	public static void shuffleDeck(int[] deckValues, char[] deckSuits) 
	{
		int r1, r2, tempValue;
		char tempSuit;
		
		for(int i=0; i<1000; i++) {
			//declares random ints
			r1 = (int)(Math.random() * 52);
			r2 = (int)(Math.random() * 52);
			//A = B
			tempValue = deckValues[r1];
			tempSuit = deckSuits[r1];
			//B = C
			deckValues[r1] = deckValues[r2];
			deckSuits[r1] = deckSuits[r2];
			//C = A 
			deckValues[r2] = tempValue;
			deckSuits[r2] = tempSuit;
		}
	}
	
	/*
	 * This method deals 3 cards to each player, one at a time, alternating players for each card dealt
	 */
	public static void deal(int[] deckValues, char[] deckSuits, int[] userValues, char[] userSuits, int[] computerValues, char[] computerSuits) 
	{
		//TODO: implement
		int n = 0;
		
		for (int i = 0; i < 6; i+=2) {
			userValues[n]=deckValues[i];
			userSuits[n]=deckSuits[i];
			computerValues[n]=deckValues[i+1];
			computerSuits[n]=deckSuits[i+1];
			n++;
		}
	}
	/*
	 *  This method prints a hand of cards to the screen
	 */
	public static void printHand(int[] handValues, char[] handSuits) 
	{
		//TODO: implement
		for(int i = 0; i < 3; ++i) {
			System.out.print(handValues[i]+""+handSuits[i]+"   ");
		} 
		System.out.println();
	}
	/*
	 *  This method determines the winner
	 *  It returns 1 if the user wins, -1 if the computer wins, and 0 if a tie
	 */
	public static int determineWinner(int[] userHandValues, char[] userHandSuits, int[] computerHandValues, char[] computerHandSuits) 
	{
		int user = getHandRank(userHandValues, userHandSuits); 
		int computer = getHandRank(computerHandValues, computerHandSuits);
		
		if(user > computer)
			return 1;
		else if (user < computer)
			return -1;
		else{
			if(hasPair(userHandValues) && hasPair(computerHandValues)) {
				int userPair = getPairCardValue(userHandValues);
				int compPair = getPairCardValue(computerHandValues);
				if(userPair>compPair)
					return 1;
				else if (userPair < compPair)
					return -1; 
				else
					return 0;
			}
			else {
				int userHighCard = getHighCardValue(userHandValues);
				int compHighCard = getHighCardValue(computerHandValues);
				if(userHighCard > compHighCard)
					return 1;
				else if (userHighCard < compHighCard)
					return -1;
				else 
					return 0;
			}
		}
	}

	/*
	 *  This method prints game statistics
	 */
	public static void printStatistics(int numUserWins, int numComputerWins, int numTies) 
	{
		//TODO: implement
		System.out.printf("You won %d times.\nThe computer won %d times. \nThere were %d ties. \nThanks for playing!", numUserWins, numComputerWins, numTies );
	}
	/*
	 *  This method returns the rank of a hand
	 */
	public static int getHandRank(int[] handValues, char[] handSuits) {
		if(hasStraightFlush(handValues, handSuits)){
			return 5;
		}
		else if(hasThreeOfAKind(handValues)){
			return 4;
		}
		else if (hasStraight(handValues)){
			return 3;
		}
		else if (hasFlush(handSuits)){
			return 2;
		}
		else if (hasPair(handValues)){
			return 1;
		}
		else
		return 0;
	}
	/*
	 *  This method determines if a hand contains a straight flush
	 */
	public static boolean hasStraightFlush(int[] handValues, char[] handSuits){	
		return (hasStraight(handValues) && hasFlush(handSuits));	
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	/*
	 *  This method determines if a hand contains three of a kind
	 */
	public static boolean hasThreeOfAKind(int[] handValues) 
	{
		return handValues[0] == handValues[1] && handValues[1] == handValues[2];
	}
	
	/*
	 *  This method determines if a hand contains a straight
	 */
	public static boolean hasStraight(int[] handValues) 
	{
		//sort a COPY of the array
		int[] handValuesCopy = handValues.clone();
		Arrays.sort(handValuesCopy);
		
		return handValuesCopy[0] == handValuesCopy[1]-1 && handValuesCopy[1] == handValuesCopy[2]-1; 
	}
	/*
	 *  This method determines if a hand contains a flush
	 */
	public static boolean hasFlush(char[] handSuits)
	{
		return handSuits[0] == handSuits[1] && handSuits[1] == handSuits[2];
	}
	
	/*
	 *  This method determines if a hand contains a pair
	 */
	public static boolean hasPair(int[] handValues) 
	{
		return handValues[0] == handValues[1] || handValues[0] == handValues[2] || handValues[1] == handValues[2];
	}
	
	/*
	 *  This method returns the value of the high card in a hand
	 */
	public static int getHighCardValue(int[] handValues) 
	{
		int max = Math.max(handValues[0], handValues[1]);
		max = Math.max(max, handValues[2]);
		return max;
	}
	/*
	 * This method ASSUMES the hand contains a pair
	 * and returns the pair card value
	 */
	public static int getPairCardValue(int[] handValues) 
	{
		if(handValues[0] == handValues[1]) {
			return Math.max(handValues[0], handValues[1]);
		}
		else if(handValues[0] == handValues[2]) {
			return Math.max(handValues[0], handValues[2]);
		}
		else if (handValues[1] == handValues[2]) {
			return Math.max(handValues[1], handValues[2]);
		}
		else 
			return 0;
}
	public static String playAgain(String playAgain, Scanner stdIn) 
	{
		do
		{
			System.out.print("\nDo you want to play again? (y/n): ");
			playAgain = stdIn.next();
			System.out.println();
		}
		while(!(playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("n")));
			
		return playAgain; 
	}
}