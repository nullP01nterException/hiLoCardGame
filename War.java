import java.util.ArrayList;
import java.util.Scanner;

public class War {
	ArrayList<String> cards = new ArrayList<String>();
	ArrayList<String> cpuDeck = new ArrayList<String>();
	ArrayList<String> playerDeck = new ArrayList<String>();
	private Scanner in = new Scanner(System.in);
	private String userIn = "";
	
	public War(){
		for(int i = 0; i < 4; i++){
			cards.add("A");
			cards.add("2");
			cards.add("3");
			cards.add("4");
			cards.add("5");
			cards.add("6");
			cards.add("7");
			cards.add("8");
			cards.add("9");
			cards.add("10");
			cards.add("J");
			cards.add("Q");
			cards.add("K");
		}
		
		while(cards.size() > 0){
			int cpuRand = (int)(Math.random()*cards.size());
			cpuDeck.add(cards.get(cpuRand));
			cards.remove(cpuRand);
			int playerRand = (int)(Math.random()*cards.size());
			playerDeck.add(cards.get(playerRand));
			cards.remove(playerRand);
		}
	}
	
	public void play(){
		System.out.println("Let's play War!\nYou have " + playerDeck.size() + " cards.\nPress any key to continue");
		
		while(playerDeck.size() > 0 || cpuDeck.size() > 0){
			in.nextLine();
			
		}
	}
}
