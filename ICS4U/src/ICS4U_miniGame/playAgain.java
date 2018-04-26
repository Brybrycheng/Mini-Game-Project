package ICS4U_miniGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class playAgain extends titlePage {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playAgain frame = new playAgain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public playAgain() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea dealerTxt = new JTextArea();
		dealerTxt.append("The dealer has a " + dealerHand.get(0) + " \nand another hidden card");

		
		JTextArea playerTxt = new JTextArea();
		for (int i = 0; i < playerHand.size(); i ++) {
			playerTxt.append("You have a " + playerHand.get(i) + "\n");
		}


		
		//hit button
		JButton btnHit = new JButton("Hit");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerHand.add(takeCard(deck));
				playerTxt.append("You have a " + playerHand.get(playerHand.size() - 1) + "\n");
			}
		});
		
		//stay button
		JButton btnStay = new JButton("Stay");
		btnStay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean y = false;
				while(addCards(dealerHand) < 16) {
					dealerHand.add(takeCard(deck));
				}
				if (addCards(dealerHand) ==21) {
					//the dealer wins
					playerTxt.setText(null);
					dealerTxt.setText(null);
					DealerWins dealerWins = new DealerWins();
					dealerWins.setVisible(true);	
				}
				else if (addCards(dealerHand) > 21) {
					//the player wins
					playerTxt.setText(null);
					dealerTxt.setText(null);
					PlayerWins playerWins = new PlayerWins();
					playerWins.setVisible(true);
				}
				else {
					if (comparer(playerHand, dealerHand) == 0) {
						playerTxt.setText(null);
						dealerTxt.setText(null);
						DealerWins dealerWins = new DealerWins();
						dealerWins.setVisible(true);
					}	else if (comparer(playerHand, dealerHand) == 1) {
						playerTxt.setText(null);
						dealerTxt.setText(null);
						PlayerWins playerWins = new PlayerWins();
						playerWins.setVisible(true);
					}
				}
				closeFrame();
			}
		});
		
		
		JLabel lblDealer = new JLabel("Dealer");
		lblDealer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(dealerTxt, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(btnHit, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(playerTxt, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
							.addGap(31))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnStay, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(91))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(lblDealer)
					.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
					.addComponent(lblPlayer)
					.addGap(109))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDealer)
						.addComponent(lblPlayer))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(playerTxt, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addComponent(dealerTxt, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStay, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}