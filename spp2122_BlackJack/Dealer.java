//***********************************
//	Created by Sharleen Price
//	Nov 4 2016
//	This Class creates Dealer objects
//	And holds their properties
//***********************************

import java.util.*;

public class Dealer 
{
	public ArrayList<Card> dealersCards = new ArrayList<Card>();
	
	public Dealer() //creates card object
	{	
	}
	
	public Card getDealersCard(int i)	//accesses dealer's individual card object
	{
		return dealersCards.get(i);
	}
	
	public int getSumCards()	// gets sum of cards
	{
		{	int sum=0;
		
		Card c = new Card(1,"Spades"); // temporary card
		for (int i=0;i<dealersCards.size();i++)
		{
			sum += dealersCards.get(i).getValue();
			if (dealersCards.get(i).getValue()==11) 
				c=dealersCards.get(i);// sets c to the ace in dealer's hand
		}
		if(sum>21 && dealersCards.contains(c)) //since Ace is set to worth 11, when sum is greater than 21
		{	sum-=10;							// subtracts 10 so Ace is worth 1 instead
			return sum;
		}
		else
			return sum;
		}
	}
	
	public int getDealerSize()	//gets size of dealer's hand
	{
		return dealersCards.size();
	}
	
	public void addDealerCards(Card c)	//add card to dealer's hand
	{
		dealersCards.add(c);
	}
	
}
