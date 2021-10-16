
public class CSC311_Proj2 {

	public static void main(String[] args) 
	{
		CardList p1 = new CardList("Greg");
		CardList p2 = new CardList("Wurt");
		CardList table = new CardList();
		CardList deck = new CardList();
		
		deck.dealDeck();
		deck.draw(p1, p2);

		int coin = (int) (Math.random() * 2); // "Flips coin" 1 is heads 0 is tails
		if(coin == 1) // If heads p1(Greg) goes first
		{
			System.out.println(table.play(p1, p2));
		}
		if(coin == 0) // If tails p2(Wurt) goes first
		{
			System.out.println(table.play(p2, p1));
		}

	}

}
