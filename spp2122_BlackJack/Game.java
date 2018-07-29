//***********************************
//	Created by Sharleen Price
//	Nov 4 2016
//	This Class creates Game objects
//	And holds their properties
//***********************************
import java.util.*;

public class Game //creates and runs games
{
	public Deck d = new Deck();
	private int balance, bet, inputVar;
	public int cardSum,dealerSum, play;
	boolean playAgain=true;
	private int currentBal;
	Deck deck = new Deck();
	public Game()	//creates and runs game object
	{
		System.out.println("Welcome to Black Jack!");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your initial balance:");
		balance = scan.nextInt();
		while(balance<100)
		{
			System.out.println("Balance too low! Please deposit atleast $100");
			balance = scan.nextInt();
		}
		
		while(playAgain == true && deck.getSize()>12) //only plays while user agrees and deck is > 12
		{
		
		deck.shuffle();
		Dealer deal = new Dealer();	
		dealerSum = deal.getSumCards();
		deal.addDealerCards(deck.draw()); //dealer draws 2 cards
		deal.addDealerCards(deck.draw());
		
		Player sharleen = new Player();
		sharleen.addCards(deck.draw()); //player draws 2 cards
		sharleen.addCards(deck.draw());
		
		cardSum=sharleen.getCardSum();
		System.out.println("Your current balance is: "+ balance);
		System.out.println("Enter your bet");
		bet = scan.nextInt();
		
		while (bet>balance)
		{
			System.out.println("You can not bet more than you have ");
			System.out.println("Please enter a number smaller than your balance");
			bet = scan.nextInt();
		}
		while (bet<10 || bet >1000)
		{
			System.out.println("You can not bet this amount");
			System.out.println("Please enter a bet of $10 to $1000");
			bet = scan.nextInt();
		}
		
		currentBal = sharleen.getBalance(balance, bet);
		balance = currentBal;	
		System.out.println("Your current balance is: "+ currentBal);
		
		System.out.println("Your cards are: ");
		for(int i=0;i<sharleen.getDeckSize(); i++)
		System.out.println(sharleen.getPlayersCard(i).getCard());
		
		System.out.println("The sum of your cards is "+cardSum);
		if(cardSum == 21)
			System.out.println("You have 21!");
		else // only asks to hit if card is not 21
		{
		System.out.println("Dealer has the card "+deal.getDealersCard(0).getCard());
		System.out.println("Enter 1 for hit or 2 for stand");
		inputVar = scan.nextInt();
			
			while(inputVar == 1 && cardSum<21)//ask to hit if card sum is less than 21
			{
				System.out.println("You Hit");
				sharleen.addCards(deck.draw());
				cardSum = sharleen.getCardSum();
				System.out.println("Your cards are now: ");
			
				for(int i=0;i<sharleen.getDeckSize(); i++)
					System.out.println(sharleen.getPlayersCard(i).getCard());
			
				System.out.println("Card sum: " +cardSum);
				System.out.println();
			
				if(cardSum<21)
				{
					System.out.println("Enter 1 for hit or 2 for stand");
					inputVar = scan.nextInt();
				}
			}
		}
				if(cardSum>21)
				{
					System.out.println("You Bust");
					System.out.println();
				}
				
			
			
		if(inputVar == 2) //if you choose to stand, dealer gets to hit
		{
			System.out.println("You Stand");
			System.out.println("Dealer has ");
			
			for(int j=0; j<deal.getDealerSize();j++)
			System.out.println(deal.getDealersCard(j).getCard());
			
			dealerSum = deal.getSumCards();
			System.out.println("Dealer sum is: "+ dealerSum);
			System.out.println();
			
			while(dealerSum<17) //dealer hits until 16
			{	System.out.println("Dealer hits");
				deal.addDealerCards(deck.draw());
				dealerSum = deal.getSumCards();
				System.out.println("Dealer has ");
				for(int j=0; j<deal.getDealerSize();j++)
				System.out.println(deal.getDealersCard(j).getCard());
				System.out.println("New Dealer sum is: "+ dealerSum);
				System.out.println();
			}
			
			if (dealerSum>=17 && dealerSum<21)
				{
					System.out.println("Dealer Stands");
					System.out.println();
				}
			else if(dealerSum== 21)
				{
					System.out.println("Dealer has 21");
					System.out.println();
				}
			else
				{
					System.out.println("Dealer bust");
					System.out.println();
				}
		}
		dealerSum = deal.getSumCards();
		System.out.println("Dealer has ");
		for(int j=0; j<deal.getDealerSize();j++)
		System.out.println(deal.getDealersCard(j).getCard());
		System.out.println("Dealer sum is: "+ dealerSum);

			if(dealerSum>cardSum &&dealerSum<=21)
				{
					System.out.println("Dealer Wins");
				}
			else if(cardSum>dealerSum && cardSum<=21)
				{
					System.out.println("You Win!");
					balance +=(bet + bet/2);
				}
			else if(dealerSum==cardSum && dealerSum < 21)
				{
					System.out.println("Tie");
					balance+=bet;
				}
			else if(dealerSum==cardSum && dealerSum == 21)
				{
					System.out.println("Push");
					balance += bet;
				}
			else if(dealerSum>21 && cardSum<=21)
				{
					System.out.println("You Win");
					balance+=(bet+bet/2);
				}
		
			
		System.out.println("Want to play again?");
		System.out.println("Enter 1 for yes and 2 for no");
		play = scan.nextInt();
		
		if(play==2)
			playAgain = false;
		else
			{
				playAgain = true;
				if(balance <10) //when balance less than 10, adds more funds
				{
					System.out.println("Add more funds");
					balance += scan.nextInt();
				}
				if(deck.getSize()<=12) // when deck less than 12, resets deck
				{
					Deck d = new Deck();
					this.deck = d;
				}
			}
		}	
			
			
	}
		
		
			
		
		
			
}




	
	

