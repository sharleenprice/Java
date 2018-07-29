//**********************************
//	Created by Sharleen Price
//	Nov 4 2016
//	This Class creates deck objects
//	And holds their properties
//**********************************

import java.util.*;

public class Deck 
{
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() //adds 52 card object to array
	{
		for(int i=1; i<=13; i++)
		deck.add(new Card (i, "Hearts"));
		for(int j=1; j<=13; j++)
		deck.add(new Card(j,"Spades"));
		for(int k=1;k<=13;k++)
		deck.add(new Card(k,"Clubs"));
		for(int l=1; l<=13; l++)
		deck.add(new Card(l,"Diamonds"));
	}
	
	public int getSize() //returns size of deck
	{
		return deck.size();
	}
	
	public Card getCard(int i)  //access individual card object
	{
		return deck.get(i);
	}
	
	public void shuffle()	// shuffles card object in array
	{
		for(int i=0; i<1000; i++)
		Collections.shuffle(deck);
	}
	public Card draw()	//removes first card in array
	{
		return deck.remove(0);
	}
}
