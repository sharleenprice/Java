




Sharleen Price
Readme.TXT


In this project we created a Black Jack game using 5 different Classes and the tester class. Here are the descriptions of each class.

Card Class

Public card
This method creates the card object for each individual type of cards.

Public string getcard
This method will return the name of the card specified

Public int getValue
This method returns the worth of the card. I had Ace set to 11 as the default because I later made the get sum method subtract 10 from the sum if the sum goes over 21 to optimize the use of Ace.

Deck Class

Public deck
This method creates deck objects which hold an arraylist of 52 card objects. I created 4 for loops one for each suit, to fill up the arraylist.

Public int getSize
This method makes it easier to get the size of a deck object’s arraylist.

Public Card getCard
This method allows you to access an individual card in an deck object

Public void shuffle
Collections.shuffle will randomly mix the array of card objects. I wrote the for loop to repeat this shuffling 1000 time just to ensure the deck is shuffled very well.







Public card draw
This method returns and removes the first card object in the Deck.

Dealer class

Public dealer
By having this method, even if I do not hav any code in it, it gives me the ability to create dealer objects. Each having an arraylist called dealersCards.

Public Card getDealer Card(int i)
This method makes it possible to access an individual card in the dealer’s hand.

Public int getSumCard
This method calculates the sum of the cards in the dealer’s hand and adjusts the sum depending on whether Ace is more convenient as a 1 or 11.

Public int getDealer size
This method returns the size of the dealer’s hand

Public void addDealerCards(Card c)
This method adds cards to the dealer’s arraylist.

Player class

Public player
As with the dealer class, even though there is no code within this method, it is important because it allows one to create player objects.

Public void addCard(Card c)
This method allows you to add to the player’s arraylist of card object.

Public card getPlayerCard(int i)
This method allows you to access an individual card in the player’s hand.

Public int getCardSum
As in the dealer class, this method calculates the sum and adjust accordingly depending on the best value of Ace.






Public int getBalance(int initial, int bet)
This method subtracts the initial balance from the bet

Public int getDeckSize
This method returns the size of the player’s deck


Game class

Public Game
This is where the game occurs. A deck, player, and dealer object is created. The dealer and player gets two cards from the deck. The user inputs the initial balance it wants and how much the user wants to bet.

As long as the Boolean “playAgain” is true and the deck is greater than 12, a game is played. When playAgain is false, we exit the game. When the deck has less than 12 objects, a new deck is created and we use that deck for the game.

The user sees the cards it received and see one of the dealer’s cards. If its card’s sum is less than 21, it can decide if it wants to hit or stand. If it is 21, then it sees what cards the dealer has and we determine if the player wins or if it is a tie/push. 

When the player decided to stand, we then see the dealer’s cards and the dealer automatically hits until it atleast has 16.

Finally, it is evaluated whether either the dealer or play has a number closer to 21. If the player wins, he/she gets back the bet plus half of the bet.  If he/she loses, the initial bet is lost. If there is a tie or push, the player gets their bet back but does not make any additional money.

The user is then asked if the game should continue and the user’s balance is checked if there is enough money to place a bet. The deck is also reset if the deck size is less than 12. 
