//**********************************
//	Created by Sharleen Price
//	Nov 4 2016
//	This Class creates card objects
//	And holds their properties
//**********************************
public class Card 
{
private int value;
private String suit;
private int worth;

	
	public Card (int inputValue, String inputSuit) //Creates card object
	{
		this.value = inputValue;
		this.suit = inputSuit;

	}
	
	public String getCard()	//Gets the type of card
	{
		if (value == 1)
			return  "Ace of " + suit;
		else if(value<=10)
			return value+" of "+suit;
		else if(value == 11)
			return "Jack of " + suit;
		else if (value == 12)
			return "Queen of " + suit;
		else
			return "King of " + suit;
		
	}
	
	
	public int getValue() //Get  the cards worth
	{
		if(value>=10)
		 this.worth = 10;
		else  if(value<10 && value>1)
		 this.worth = value;
		else if (value == 1)
		 this.worth = 11;
		return worth;
	}
	
	
}

