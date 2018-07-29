//***********************************
//	Created by Sharleen Price
//	Nov 4 2016
//	This Class creates Player objects
//	And holds their properties
//***********************************

import java.util.*;

public class Player 
{
	
	public ArrayList<Card> PlayerCards = new ArrayList<Card>();
	int balance;
	
	public Player()	//creates player object
	{
	}
	
	public void addCards(Card c) //adds card to player's hand
	{
		PlayerCards.add(c);
	}
	
	public Card getPlayersCard(int i) //gets individual card object
	{
		return PlayerCards.get(i);
	}
	
	public int getCardSum()	//gets sum of cards as in dealer class
	{	int sum=0;
		
		Card c = new Card(1,"Spades");
		for (int i=0;i<PlayerCards.size();i++)
		{
			sum += PlayerCards.get(i).getValue();
			if (PlayerCards.get(i).getValue()==11)
				c=PlayerCards.get(i);
		}
		if(sum>21 && PlayerCards.contains(c))
		{	sum-=10;
			return sum;
		}
		else
			return sum;
		}
	
		public int getBalance(int initial, int bet) //calculates balance after betting
		{
			return initial-bet;
		}
		
		public int getDeckSize()// returns size of player's deck
		{
			return PlayerCards.size();
		}
	
}
