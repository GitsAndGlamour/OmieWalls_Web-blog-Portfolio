

public class ThreeCardPokerTestDriver {

	private static int[] userHandValues = new int[3];
	private static char[] userHandSuits = new char[3];
	private static int[] computerHandValues = new int[3];
	private static char[] computerHandSuits = new char[3];
	
	public static void main(String[] args) {
		
		boolean passedAllTests = true;
		
		resetHand();
		if(!testStraightFlush(userHandValues, userHandSuits)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine if a hand contains a straight flush.");
		} else {
			System.out.println("Your code appears to successfully determine if a hand contains a straight flush.");
		}
		
		resetHand();
		if(!testThreeOfAKind(userHandValues)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine if a hand contains three of a kind.");
		} else {
			System.out.println("Your code appears to successfully determine if a hand contains three of a kind.");
		}
		
		resetHand();
		if(!testStraight(userHandValues)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine if a hand contains a straight.");
		} else {
			System.out.println("Your code appears to successfully determine if a hand contains a straight.");
		}
		
		resetHand();
		if(!testFlush(userHandSuits)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine if a hand contains a flush.");
		} else {
			System.out.println("Your code appears to successfully determine if a hand contains a flush.");
		}
		
		resetHand();
		if(!testPair(userHandValues)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine if a hand contains a pair.");
		} else {
			System.out.println("Your code appears to successfully determine if a hand contains a pair.");
		}
		
		resetHand();
		if(!testHighCard(userHandValues)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine the high card of a hand.");
		} else {
			System.out.println("Your code appears to successfully determine the high card of a hand.");
		}
		
		resetHand();
		if(!testGetPairValue(userHandValues)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine the card value in a pair.");
		} else {
			System.out.println("Your code appears to successfully determine the card value in a pair.");
		}
		
		resetHand();
		if(!testGetHandRank(userHandValues, userHandSuits)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine the correct rank of a hand.");
		} else {
			System.out.println("Your code appears to successfully determine the correct rank of a hand.");
		}
		
		resetHand();
		if(!testDetermineWinner(userHandValues, userHandSuits, computerHandValues, computerHandSuits)) {
			passedAllTests = false;
			System.out.println("Your code does not successfully determine the winner.");
		} else {
			System.out.println("Your code appears to successfully determine the winner.");
		}
		
		if(!testDeal()) {
			passedAllTests = false;
			System.out.println("Your code does not successfully deal cards.");
		} else {
			System.out.println("Your code appears to successfully deal cards.");
		}
		
		if(passedAllTests) {
			System.out.println("Your code passed all tests.  Congratulations!");
		}
	}
	
	private static void resetHand() {
		userHandValues[0] = 2;
		userHandValues[1] = 3;
		userHandValues[2] = 4;
		userHandSuits[0] = 'H';
		userHandSuits[1] = 'H';
		userHandSuits[2] = 'H';
		
		computerHandValues[0] = 5;
		computerHandValues[1] = 6;
		computerHandValues[2] = 7;
		computerHandSuits[0] = 'H';
		computerHandSuits[1] = 'H';
		computerHandSuits[2] = 'H';
	}
	
	private static boolean testGetHandRank(int[] handValues, char[] handSuits) {
		
		try {
			if(ThreeCardPoker.getHandRank(handValues, handSuits) != 5) {
				return false;
			}
			
			handValues[1] = handValues[0];
			handValues[2] = handValues[0];
			if(ThreeCardPoker.getHandRank(handValues, handSuits) != 4) {
				return false;
			}
			
			handValues[1] = handValues[0] + 1;
			handValues[2] = handValues[1] + 1;
			handSuits[0] = 'S';
			if(ThreeCardPoker.getHandRank(handValues, handSuits) != 3) {
				return false;
			}
			
			handSuits[0] = 'H';
			handValues[2] = handValues[1];
			if(ThreeCardPoker.getHandRank(handValues, handSuits) != 2) {
				return false;
			}
			
			handSuits[0] = 'S';
			if(ThreeCardPoker.getHandRank(handValues, handSuits) != 1) {
				return false;
			}
			
			handValues[2] = handValues[1] + 2;
			if(ThreeCardPoker.getHandRank(handValues, handSuits) != 0) {
				return false;
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testDetermineWinner(int[] userHandValues, char[] userHandSuits, int[] computerHandValues, char[] computerHandSuits) {
		try {
			//test same rank but different high cards
			if(ThreeCardPoker.determineWinner(userHandValues, userHandSuits, computerHandValues, computerHandSuits) != -1) {
				return false;
			}
			
			if(ThreeCardPoker.determineWinner(computerHandValues, computerHandSuits, userHandValues, userHandSuits) != 1) {
				return false;
			}
			
			//test same non pair rank with same high card
			computerHandValues[0] = userHandValues[2];
			computerHandValues[1] = userHandValues[1];
			computerHandValues[2] = userHandValues[0];
			computerHandSuits[0] = computerHandSuits[1] = computerHandSuits[2] = 'S';
			if(ThreeCardPoker.determineWinner(computerHandValues, computerHandSuits, userHandValues, userHandSuits) != 0) {
				return false;
			}
			
			if(ThreeCardPoker.determineWinner(userHandValues, userHandSuits, computerHandValues, computerHandSuits) != 0) {
				return false;
			}
			
			//test different non pair ranks with same high card
			computerHandSuits[2] = 'D';
			if(ThreeCardPoker.determineWinner(userHandValues, userHandSuits, computerHandValues, computerHandSuits) != 1) {
				return false;
			}
			
			if(ThreeCardPoker.determineWinner(computerHandValues, computerHandSuits, userHandValues, userHandSuits) != -1) {
				return false;
			}
			
			//test different non pair ranks with different high cards
			computerHandValues[0] = 5;
			computerHandValues[1] = 6;
			computerHandValues[2] = 7;
			if(ThreeCardPoker.determineWinner(userHandValues, userHandSuits, computerHandValues, computerHandSuits) != 1) {
				return false;
			}
			
			if(ThreeCardPoker.determineWinner(computerHandValues, computerHandSuits, userHandValues, userHandSuits) != -1) {
				return false;
			}
			
			//test same pair rank with same high cards
			userHandSuits[2] = 'S';
			userHandValues[2] = 2;
			computerHandValues[0] = 2;
			computerHandSuits[0] = 'C';
			computerHandValues[1] = 2;
			computerHandValues[2] = 4;
			
			if(ThreeCardPoker.determineWinner(userHandValues, userHandSuits, computerHandValues, computerHandSuits) != 0) {
				return false;
			}
			
			if(ThreeCardPoker.determineWinner(computerHandValues, computerHandSuits, userHandValues, userHandSuits) != 0) {
				return false;
			}
			
			//test same pair rank with different high cards
			computerHandValues[0] = 3;
			computerHandValues[1] = 3;
			if(ThreeCardPoker.determineWinner(userHandValues, userHandSuits, computerHandValues, computerHandSuits) != -1) {
				return false;
			}
			
			if(ThreeCardPoker.determineWinner(computerHandValues, computerHandSuits, userHandValues, userHandSuits) != 1) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testStraightFlush(int[] handValues, char[] handSuits) {
		try {
			if(!ThreeCardPoker.hasStraightFlush(handValues, handSuits)) {
				return false;
			}
			for(int i=0; i<handValues.length; i++) {
				handValues[i] = handValues[i] + 1;
				if(ThreeCardPoker.hasStraightFlush(handValues, handSuits)) {
					return false;
				}
				handValues[i] = handValues[i] - 1;
			}
			for(int i=0; i<handSuits.length; i++) {
				handSuits[i] = 'S';
				if(ThreeCardPoker.hasStraightFlush(handValues, handSuits)) {
					return false;
				}
				handSuits[i] = 'H';
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testThreeOfAKind(int[] handValues) {
		try {
			handValues[1] = handValues[0];
			handValues[2] = handValues[0];
			if(!ThreeCardPoker.hasThreeOfAKind(handValues)) {
				return false;
			}
			for(int i=0; i<handValues.length; i++) {
				handValues[i] = handValues[i] + 1;
				if(ThreeCardPoker.hasThreeOfAKind(handValues)) {
					return false;
				}
				handValues[i] = handValues[i] - 1;
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testStraight(int[] handValues) {
		try {
			if(!ThreeCardPoker.hasStraight(handValues)) {
				return false;
			}
			for(int i=0; i<handValues.length; i++) {
				handValues[i] = handValues[i] + 1;
				if(ThreeCardPoker.hasStraight(handValues)) {
					return false;
				}
				handValues[i] = handValues[i] - 1;
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testFlush(char[] handSuits) {
		try {
			if(!ThreeCardPoker.hasFlush(handSuits)) {
				return false;
			}
			for(int i=0; i<handSuits.length; i++) {
				handSuits[i] = 'S';
				if(ThreeCardPoker.hasFlush(handSuits)) {
					return false;
				}
				handSuits[i] = 'H';
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testPair(int[] handValues) {
		try {
			if(ThreeCardPoker.hasPair(handValues)) {
				return false;
			}
			
			int tempValue = handValues[1];
			handValues[1] = handValues[0];
			if(!ThreeCardPoker.hasPair(handValues)) {
				return false;
			}
			handValues[1] = tempValue;
			
			handValues[2] = handValues[1];
			if(!ThreeCardPoker.hasPair(handValues)) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testHighCard(int[] handValues) {
		try {
			if(ThreeCardPoker.getHighCardValue(handValues) != handValues[2]) {
				return false;
			}
			
			int tempValue = handValues[1];
			handValues[1] = handValues[2];
			handValues[2] = tempValue;
			
			if(ThreeCardPoker.getHighCardValue(handValues) != handValues[1]) {
				return false;
			}
			tempValue = handValues[0];
			handValues[0] = handValues[1];
			handValues[1] = tempValue;
			
			if(ThreeCardPoker.getHighCardValue(handValues) != handValues[0]) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static boolean testGetPairValue(int[] handValues) {
		try {
			int r = (int)(Math.random() * 12) + 2;
			handValues[0] = r;
			handValues[1] = r;
			handValues[2] = r+1;
			
			if(ThreeCardPoker.getPairCardValue(handValues) != r) {
				return false;
			}
			
			handValues[1] = r+1;
			handValues[2] = r;
			
			if(ThreeCardPoker.getPairCardValue(handValues) != r) {
				return false;
			}
			
			handValues[0] = r+1;
			handValues[1] = r;
			handValues[2] = r;
			
			if(ThreeCardPoker.getPairCardValue(handValues) != r) {
				return false;
			}
			
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static boolean testDeal() {
		int[] deckValues = new int[52];
		char[] deckSuits = new char[52];
		int[] deckValuesClone = new int[52];
		char[] deckSuitsClone = new char[52];
		int[] userValues = new int[3];
		char[] userSuits = new char[3];
		int[] computerValues = new int[3];
		char[] computerSuits = new char[3];
		
		try {
			initializeDeck(deckValues, deckSuits);
			shuffleDeck(deckValues, deckSuits);
			
			System.arraycopy(deckValues, 0, deckValuesClone, 0, 52);
			System.arraycopy(deckSuits, 0, deckSuitsClone, 0, 52);
			
			ThreeCardPoker.deal(deckValues, deckSuits, userValues, userSuits, computerValues, computerSuits);
			
			for(int i=0; i<3; i++) {
				if(userValues[i] != deckValues[i*2] || userSuits[i] != deckSuits[i*2]) {
					return false;
				}
				if(computerValues[i] != deckValues[i*2+1] || computerSuits[i] != deckSuits[i*2+1]) {
					return false;
				}
			}
			
			for(int i=0; i<52; i++) {
				if(deckValues[i] != deckValuesClone[i] || deckSuits[i] != deckSuitsClone[i]) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	private static void initializeDeck(int[] deckValues, char[] deckSuits) 
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
	
	private static void shuffleDeck(int[] deckValues, char[] deckSuits) 
	{
		int r1, r2, tempValue;
		char tempSuit;
		
		for(int i=0; i<1000; i++) {
			r1 = (int)(Math.random() * 52);
			r2 = (int)(Math.random() * 52);
			tempValue = deckValues[r1];
			tempSuit = deckSuits[r1];
			deckValues[r1] = deckValues[r2];
			deckSuits[r1] = deckSuits[r2];
			deckValues[r2] = tempValue;
			deckSuits[r2] = tempSuit;
		}
	}
}
