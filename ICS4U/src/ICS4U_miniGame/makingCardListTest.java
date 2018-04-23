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
	public static void main(String[] args) {
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		makeCardList(cardList);
		for (int i = 0; i < cardList.size(); i ++) {
			System.out.println(cardList.get(i));
		}
			

	}

}
