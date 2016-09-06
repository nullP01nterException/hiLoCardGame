import java.util.Scanner;

public class HiLo {
	Scanner in = new Scanner(System.in);
	String userIn = "";
	String cards[] = new String[13];


	public HiLo(){
		createDeck(cards);
	}

	public void play(){
		int shownRand = (int)(Math.random()*cards.length);
		int hiddenRand = (int)(Math.random()*cards.length);

		System.out.println("Cards:  " + cards[shownRand] + " and ?");
		System.out.println("High or Low? Please enter h/l");
		System.out.print("Response: ");
		userIn = in.nextLine();
		while(!(userIn.equals("h") || userIn.equals("H") || userIn.equals("l") || userIn.equals("L"))){
			System.out.println("Not a valid option. Try again.");
			System.out.print("Response: ");
			userIn = in.nextLine();
		}
		System.out.println("Cards:  " + cards[shownRand] + " and " + cards[hiddenRand]);
		if(userIn.equals("h") || userIn.equals("H")){
			if(hiddenRand+1 >= shownRand+1) System.out.println("You Win!");
			else System.out.println("You Lose...");
		}
		else if(userIn.equals("l") || userIn.equals("L")){
			if(hiddenRand+1 <= shownRand+1) System.out.println("You Win!");
			else System.out.println("You Lose...");
		}
		else System.out.println("Not a valid option");

		in.close();
	}

	private void createDeck(String cards[]){
		cards[0] = "A";
		cards[1] = "2";
		cards[2] = "3";
		cards[3] = "4";
		cards[4] = "5";
		cards[5] = "6";
		cards[6] = "7";
		cards[7] = "8";
		cards[8] = "9";
		cards[9] = "10";
		cards[10] = "J";
		cards[11] = "Q";
		cards[12] = "K";
	}
}
