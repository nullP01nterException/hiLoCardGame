import java.util.ArrayList;
import java.util.Scanner;

public class War {
	ArrayList<Integer> cards = new ArrayList<Integer>();
	ArrayList<Integer> cpuDeck = new ArrayList<Integer>();
	ArrayList<Integer> playerDeck = new ArrayList<Integer>();
	private Scanner in = new Scanner(System.in);
	private String userIn = "";

	//constructor creates deck of 52 cards and randomly divides deck in half
	public War(){
		for(int i = 0; i < 4; i++){
			cards.add(1);
			cards.add(2);
			cards.add(3);
			cards.add(4);
			cards.add(5);
			cards.add(6);
			cards.add(7);
			cards.add(8);
			cards.add(9);
			cards.add(10);
			cards.add(11);
			cards.add(12);
			cards.add(13);
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
		ArrayList<Integer> cardQueue = new ArrayList<Integer>();
		int winner = 0;
		System.out.println("Let's play War!");

		while(playerDeck.size() > 0 && cpuDeck.size() > 0){
			boolean isTie = true;
			System.out.println("*--*--*--*--*--*--*--*--*--*--*--*--*");
			System.out.println("You have " + playerDeck.size() + " cards.\nPress any key to continue");
			in.nextLine();
			int playerCard = playerDeck.get(0);
			int cpuCard = cpuDeck.get(0);
			System.out.println("You played a:  " + JQKConvert(playerDeck.get(0)));
			System.out.println("You opponent played a:  " + JQKConvert(cpuDeck.get(0)));

			while(isTie){
				//if player card is higher
				if(playerCard > cpuCard){
					cardQueue.add(playerCard);
					cardQueue.add(cpuCard);
					playerDeck.remove(0);
					cpuDeck.remove(0);
					System.out.println("You win!\n");
					isTie = false;
					winner = 1; //player win = 1
					//if CPU card is higher
				}else if(cpuCard > playerCard){
					cardQueue.add(cpuCard);
					cardQueue.add(playerCard);
					cpuDeck.remove(0);
					playerDeck.remove(0);
					System.out.println("Computer wins!\n");
					isTie = false;
					winner = 2;  //CPU win = 2
					//if tie
				}else{
					System.out.println("It's a tie!\n");
					for(int i = 0; i < 3; i++){
						cardQueue.add(playerDeck.get(0));
						cardQueue.add(cpuDeck.get(0));
						playerDeck.remove(0);
						cpuDeck.remove(0);
					}
				}
			}
			
			//add cards to player's hand (player wins)
			if(winner == 1){
				addAllCards(cardQueue, playerDeck);
				cardQueue.clear();
				//add cards to CPU's hand (CPU wins)
			}else if(winner == 2){
				addAllCards(cardQueue, cpuDeck);
				cardQueue.clear();
			}
		}
	}

	private String JQKConvert(int val){
		switch(val){
		case 1: return "A";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default: return Integer.toString(val);
		}
	}
	
	private void addAllCards(ArrayList<Integer> queue, ArrayList<Integer> deck){
		while(!queue.isEmpty()){
			deck.add(queue.get(0));
			queue.remove(0);
		}
	}
}
