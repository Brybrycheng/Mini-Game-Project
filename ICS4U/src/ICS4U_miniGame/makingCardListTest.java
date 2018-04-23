package ICS4U_miniGame;

import java.util.*;

public class makingCardListTest {
	public static void makeCardList(ArrayList<Integer> myList) {
		myList.clear();
		for (int i = 0; i < 4; i ++) {
			for (int n = 1; n < 10; n++) {
				myList.add(n);
			}
		}
		for (int x = 0; x < 16; x ++) {
			myList.add(10);
		}
		Collections.shuffle(myList);
	}
	
	public static int takeCard(ArrayList<Integer> myList) {
		int card = myList.get(0);
		myList.remove(myList.get(0));
		return card;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		makeCardList(cardList);
		//see if shuffled deck is made
		for (int i = 0; i < cardList.size(); i ++) {
			System.out.println(cardList.get(i));
		}
		System.out.println("\n" + takeCard(cardList) + "\n");
		
		//see if printed card is removed from list
		for (int i = 0; i < cardList.size(); i ++) {
			System.out.println(cardList.get(i));
		}	

	}

}
