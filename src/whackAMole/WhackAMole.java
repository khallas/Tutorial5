package whackAMole;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.JComboBox;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class WhackAMole extends JApplet {

	protected ActionListener listener;

	/**
	 * Create the applet.
	 */
	int score = 0;
	public WhackAMole() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 195);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(305, 207, 133, 25);
		getContentPane().add(textArea);
		
		final JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_1.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(44, 5, 117, 25);
		panel.add(btnNewButton_1);
		
		final JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(166, 5, 117, 25);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_3.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
				}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(288, 5, 117, 25);
		panel.add(btnNewButton_3);
		
		final JButton btnNewButton_12 = new JButton("New button");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_12.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.setBounds(44, 35, 117, 25);
		panel.add(btnNewButton_12);
		
		final JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_4.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(166, 35, 117, 25);
		panel.add(btnNewButton_4);
		
		final JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_2.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(288, 35, 117, 25);
		panel.add(btnNewButton_2);
		
		final JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_6.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(44, 65, 117, 25);
		panel.add(btnNewButton_6);
		
		final JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_9.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setBounds(166, 65, 117, 25);
		panel.add(btnNewButton_9);
		
		final JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_5.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(288, 65, 117, 25);
		panel.add(btnNewButton_5);
		
		final JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_7.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(44, 95, 117, 25);
		panel.add(btnNewButton_7);
		
		final JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_8.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBounds(166, 95, 117, 25);
		panel.add(btnNewButton_8);
		
		final JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_10.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.setBounds(288, 95, 117, 25);
		panel.add(btnNewButton_10);
		
		final JButton btnNewButton_11 = new JButton("New button");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_11.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setBounds(44, 125, 117, 25);
		panel.add(btnNewButton_11);
		
		final JButton btnNewButton_13 = new JButton("New button");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_13.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
				}
		});
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.setBounds(166, 125, 117, 25);
		panel.add(btnNewButton_13);
		
		final JButton btnNewButton_14 = new JButton("New button");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_14.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_14.setBackground(Color.WHITE);
		btnNewButton_14.setBounds(288, 125, 117, 25);
		panel.add(btnNewButton_14);
		
		final JButton btnNewButton_15 = new JButton("New button");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNewButton_15.getBackground()==Color.RED) {score++; textArea.setText(String.valueOf(score));}
			}
		});
		btnNewButton_15.setBackground(Color.WHITE);
		btnNewButton_15.setBounds(166, 155, 117, 25);
		panel.add(btnNewButton_15);
		
		
		final ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		        changecolors();  
		      }

			private void changecolors() {				
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_2.setBackground(Color.WHITE);
				btnNewButton_3.setBackground(Color.WHITE);
				btnNewButton_4.setBackground(Color.WHITE);
				btnNewButton_5.setBackground(Color.WHITE);
				btnNewButton_6.setBackground(Color.WHITE);
				btnNewButton_7.setBackground(Color.WHITE);
				btnNewButton_8.setBackground(Color.WHITE);
				btnNewButton_9.setBackground(Color.WHITE);
				btnNewButton_10.setBackground(Color.WHITE);
				btnNewButton_11.setBackground(Color.WHITE);
				btnNewButton_12.setBackground(Color.WHITE);
				btnNewButton_13.setBackground(Color.WHITE);
				btnNewButton_14.setBackground(Color.WHITE);
				btnNewButton_15.setBackground(Color.WHITE);

				Random generator = new Random();
				int nextRedButton = generator.nextInt(15);
				
				switch (nextRedButton){
				case 0: btnNewButton.setBackground(Color.RED); break;
				case 1: btnNewButton_1.setBackground(Color.RED);break;
				case 2: btnNewButton_2.setBackground(Color.RED);break;
				case 3: btnNewButton_3.setBackground(Color.RED);break;
				case 4: btnNewButton_4.setBackground(Color.RED);break;
				case 5: btnNewButton_5.setBackground(Color.RED);break;
				case 6: btnNewButton_6.setBackground(Color.RED);break;
				case 7: btnNewButton_7.setBackground(Color.RED);break;
				case 8: btnNewButton_8.setBackground(Color.RED);break;
				case 9: btnNewButton_9.setBackground(Color.RED);break;
				case 10: btnNewButton_10.setBackground(Color.RED);break;
				case 11: btnNewButton_11.setBackground(Color.RED);break;
				case 12: btnNewButton_12.setBackground(Color.RED);break;
				case 13: btnNewButton_13.setBackground(Color.RED);break;
				case 14: btnNewButton_14.setBackground(Color.RED);break;
				case 15: btnNewButton_15.setBackground(Color.RED);break;
				}

			}
		  };
		

		
		final JComboBox<String> comboBox = new JComboBox<String>();
		String [] s = {"Easy as pie", "I'm here to play", "Bring it on", "I have a death wish"};
		for(String a : s){
			comboBox.addItem(a);
		}
		comboBox.setBounds(10, 207, 157, 25);
		getContentPane().add(comboBox);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 207, 117, 25);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(0, 0, 117, 25);
		panel_1.add(btnStart);
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lapseTime = 300*(4-comboBox.getSelectedIndex());
				new Timer(lapseTime,taskPerformer).start();
			}
		});

	}
	}
