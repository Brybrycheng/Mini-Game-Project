package ICS4U_miniGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.*;
public class titlePage extends JFrame {
	
	public void closeFrame() {
		super.dispose();
	}
	ArrayList<Integer> deck = new ArrayList<Integer>();
	public static ArrayList<Integer> dealerHand = new ArrayList<Integer>();
	public static ArrayList<Integer> playerHand = new ArrayList<Integer>();
	
	String getName;		
	private JPanel contentPane;
	private JTextField nameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					titlePage frame = new titlePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
	
	public static int addCards(ArrayList<Integer> myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i ++) {
			total += myList.get(i);
		}
		return total;
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public titlePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterYourName = new JLabel("Enter your name:");
		lblEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeCardList(deck);
				for (int i = 0; i < 2; i ++) {
					dealerHand.add(takeCard(deck));
					playerHand.add(takeCard(deck));
				}
				//doesn't work to set player name to input
				getName = nameField.getText();
				gamePage play = new gamePage();
				play.setVisible(true);
				closeFrame();
				

			}
		});
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		
		JTextArea txtrInstructions = new JTextArea();
		//instructions
		txtrInstructions.append("The goal is to get as close to 21 as possible without exceeding it. \n \n");	
		txtrInstructions.append("All cards are worth their face value, except for aces which are worth 1\n");
		txtrInstructions.append("and face cards which are all worth 10 \n \n");
		txtrInstructions.append("Press hit to receive more cards or stay if you're satisfied with your total. \n \n");
		txtrInstructions.append("A total of 21 is a BLACKJACK and you automatically win \n \n");
		txtrInstructions.append("The closer one to 21 wins!");
		
		JLabel lblBlackjack = new JLabel("BlackJack");
		lblBlackjack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnSaveName = new JButton("Save Name");
		btnSaveName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getName = nameField.getText();
				}	catch(Exception q) {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(lblEnterYourName, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addComponent(txtrInstructions, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSaveName, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(207, Short.MAX_VALUE)
					.addComponent(lblBlackjack)
					.addGap(205))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBlackjack)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(txtrInstructions, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEnterYourName, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
	}
}