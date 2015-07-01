
import java.util.Random;

import javax.swing.*;


public class CardGame {
	
	Random rand;
	
	CardGame(){
		rand = new Random();
	}
	
	public int dealOneCard() {
		int card;
		card = (11*rand.nextInt() +1);
		return card;
	}// end dealOneCard method
	
	public static void addSum(int[] array) {
		  for (int i = 0; i < array.length; i++) {
			  array[i] += array[i];
		  }
		}// end addSum method
	

	public static void main(String[] args) {
				
		CardGame myGame = new CardGame();
		int[] playercards = new int[22];
		int[] dealercards = new int[22];
		int playerSum = 0;
		int dealerSum = 0;
		String answer = "Yes";
		String message = "Your total is" + playerSum + "another card? type Yes or No";
		String titlebar = "Card Game";
		int messagetype = JOptionPane.QUESTION_MESSAGE;
		boolean problem = false;
		boolean nullerror = false;

		
		
		// initialize

			playercards[0] = myGame.dealOneCard();
			addSum(playercards);
			playerSum = playercards[21];
			dealercards[0] = myGame.dealOneCard();
			addSum(playercards);
			playerSum = playercards[21];
			playercards[1] = myGame.dealOneCard();
			addSum(playercards);
			playerSum = playercards[21];
			dealercards[1] = myGame.dealOneCard();
			addSum(playercards);
			playerSum = playercards[21];
			
			/*for (int i = 0; i < playercards.length; i++){
			playerSum += playercards[i];
			}
			
			for (int i = 0; i < dealercards.length; i++){
			dealerSum += dealercards[i];
			}*/
			
			if (dealerSum > 21){
				message = "Dealer busted, you win!";
				titlebar = "Busted";
				messagetype = JOptionPane.INFORMATION_MESSAGE;	
			}

			else if (playerSum > 21){
				message = "Busted, you lose";
				titlebar = "Busted";
				messagetype = JOptionPane.INFORMATION_MESSAGE;
			}
			
			else {
					message = "Your total is" + playerSum + "another card? type Yes or No";
					messagetype = JOptionPane.QUESTION_MESSAGE;
					titlebar = "Hit?";					
			}
			
			answer = JOptionPane.showInputDialog(null, message, titlebar ,messagetype);
			
			//interact with player
			do {
				
			if (answer.compareToIgnoreCase("NO") == 0){
				message = "Your total is" + playerSum;
				messagetype = JOptionPane.INFORMATION_MESSAGE;
				titlebar = "Stand";
				playerSum = 22;
			}
				
			else if (answer.compareToIgnoreCase("YES") == 0){
				int i;
				for (i = 2; i < playercards.length; i++){
				playercards[i] = myGame.dealOneCard();
				addSum(playercards);
				playerSum = playercards[21];
				}
			}
			try{
				nullerror = (answer.compareToIgnoreCase("YES") == 0) || (answer.compareToIgnoreCase("NO") == 0);
				message = "Your total is" + playerSum + "another card? type Yes or No";
				messagetype = JOptionPane.QUESTION_MESSAGE;	
				titlebar = "Hit?";
				problem = false;
				}// end try
			
			catch(NullPointerException e){
				problem = true;
				message = "Your total is" + playerSum + "another card? type Yes or No";
				answer = "";
				}// end catch
			
			}// end while
		
			while(playerSum < 21);

		//interact with dealer
		do {
			
			if (dealerSum < 21){
				message = "Dealer total is" + dealerSum;
				titlebar = "Dealer hits";
				messagetype = JOptionPane.INFORMATION_MESSAGE;
				
				int i;
				for (i = 2; i < dealercards.length; i++){
				dealercards[i] = myGame.dealOneCard();
				addSum(playercards);
				playerSum = playercards[21];
				}
			}
			
		}
		while (dealerSum < 21);
		

		
		//resolve events and announce results
		
		if (dealerSum > playerSum){
			message = "Dealer's score:" + dealerSum + "Your score:" + playerSum + "Dealer wins!";
			titlebar = "Game over";
			messagetype = JOptionPane.INFORMATION_MESSAGE;	
		}

		else if (playerSum > dealerSum){
			message = "Dealer's score:" + dealerSum + "Your score:" + playerSum + "You win";
			titlebar = "Game over";
			messagetype = JOptionPane.INFORMATION_MESSAGE;
		}
		
		else {
				message = "Nobody wins";
				messagetype = JOptionPane.QUESTION_MESSAGE;
				titlebar = "Tie Game";					
		}
		
		
		//play again?
		
		message = "Do you want to play again?";
		messagetype = JOptionPane.QUESTION_MESSAGE;
		titlebar = "Thanks";
		
		

	} //end main

} //end class
