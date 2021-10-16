
public class Card 
{
	private String type;
	private String suit;
	private static final String[] types = {"Mummy", "Witch", "Dracula", "Werewolf",
											"Basalisk", "Frankenstein", "Ghostface",
											"Freddy", "Jason", "Leatherface",
											"Cockatrice", "Griffin", "Zombie"};
	
	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	public Card()
	{
		type = "null";
		suit = "null";
	}
	
	public Card(String type, String suit)
	{
		this.type = type;
		this.suit = suit;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getSuit()
	{
		return this.suit;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	

	@Override
	public String toString() {
		return "(" + this.type + " of " + this.suit + ")";
	}
	
	
}
