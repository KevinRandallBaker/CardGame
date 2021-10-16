public class CardList extends LinkedList<Card>
{
	private LinkedList<Card> cardList;
	private static final String[] types = 
			{"Mummy", "Witch", "Dracula", "Werewolf",
			"Clown", "Frankenstein", "Manson",
			"Freddy", "Jason", "Leatherface",
			"Alien", "Griffin", "Zombie"};
	private String pName;

	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	public CardList()
	{
		cardList = new LinkedList<Card>();
	}
	
	public CardList(String name)
	{
		cardList = new LinkedList<Card>();
		this.pName = name;
	}
	
	public CardList(LinkedList<Card> cardList)
	{
		this.cardList = cardList;
	}
	
	public void draw(CardList p1, CardList p2)
	{
		// iterates through 52 cards to assign them to each player's deck
		for(int i = 0; i < 52; i++)
		{
			// Adds all even indexes to the player going first
			// and all odd for the playing going 2nd
			if(i % 2 == 0)
				p1.cardList.add(0, this.cardList.get(i));
			else
				p2.cardList.add(0, this.cardList.get(i));
		}

	}
	
	// Shuffles deck by going once through every card and swapping
	//        with another random card
	public void shuffle()
	{
		for(int i = 0; i < this.cardList.size(); i++)
		{
			int randomPos = (int) (Math.random() * this.cardList.size());
			//j = (int) (Math.random() * 52);
			
			Card temp = this.cardList.get(i);
			this.cardList.set(i, this.cardList.get(randomPos));
			this.cardList.set(randomPos, temp);
		}

	}
	
	public void dealDeck()
	{
		String s = "";
		for(int i = 0; i < 4; i++)
		{
			
			for(int j = 0; j < 13; j++)
			{	
				Card item = new Card(types[j], suits[i]);
				this.cardList.add(0, item);
			}
			                         
			
		}
		
		this.shuffle();
		
	}
	
	public LinkedList<Card> getList()
	{
		return this.cardList;
	}
	
	private void modSize(int mod)
	{
		this.size += mod;
	}

	@Override
	public String toString() 
	{
		return this.cardList.toString();
	}
	
	// merges player's cards with whatever is on the table
	public void merge(CardList player, CardList table)
    {
		for(int i = 0; i < table.cardList.size(); i++)
		{
			player.cardList.add(player.cardList.size(), table.cardList.get(i));
		}
	}
	
	private void consume(CardList player, CardList table)
	{
		merge(player, table);
		player.modSize(table.cardList.size);
		table.cardList.size = 0;
		
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public String play(CardList p1, CardList p2) // Plays game with p1 being first to play
	{
		for(int i = 0; i < 10; i++) // Iterates a max of 10 turns
		{
			System.out.println("Round " + (i + 1) + " //////////////////////////////////////////////////////////////////");
			System.out.println(p1.pName + ": " + p1.cardList);
			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~~-~-~-~-~-~-~-~-~-~-~-~-~-~");
			System.out.println(p2.pName + ": " + p2.cardList);
			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~~-~-~-~-~-~-~-~-~-~-~-~-~-~");
			
			if(p1.cardList.size() != 0)
			{
				this.cardList.add(0, p1.cardList.get(0)); // Adds p1 card to table
				p1.cardList.remove(0); // Removes card from p1 hand
			}
			
			if(this.cardList.size() > 1)
			{
				// Comparing last card played            with previous card
				if(this.cardList.get(0).getSuit() == this.cardList.get(1).getSuit())
				{
					consume(p1, this);
				}
				
			}
			
			if(p2.cardList.size() != 0)
			{
				this.cardList.add(0, p2.cardList.get(0));// Adds p2 card to table
				p2.cardList.remove(0); // Removes card from p2 hand
			}
				
			if(this.cardList.size() > 1)
			{
				// Comparing last card played           with previous card played
				if(this.cardList.get(0).getSuit() == this.cardList.get(1).getSuit())
				{
					consume(p2, this);
				}
				
			}
			
			System.out.println("Table: " + this.cardList);
			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~~-~-~-~-~-~-~-~-~-~-~-~-~-~");
			
			if(p1.cardList.size() == 52)
			{
				return p1.pName + " wins for having all 52 cards.";
			}
			if(p2.cardList.size() == 52)
			{
				return p2.pName + " wins for having all 52 cards.";
			}
			
			
		}
		
		if(p1.cardList.size() == p2.cardList.size())
		{
			return "Tie game.";
		}
		else if(p1.cardList.size() > p2.cardList.size())
		{
			return p1.pName + " wins for having more cards after 10 rounds.";
		}
		else
		{
			return p2.pName + " wins for having more cards after 10 rounds.";
		}

	}
	
	
		
}
