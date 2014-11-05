package whackAMole_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Timer;

//import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WhackAMole extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimer;
	private JTextField txtScore;
	private int score = 0, counter =0;
	private JTextField txtTime;
	private JTextField txtCurrentScore;
	private JTextField txtPlayerName;
	private boolean gameOn = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhackAMole frame = new WhackAMole();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public WhackAMole() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_initial = new JPanel();
		panel_initial.setLayout(new GridLayout(4,4));
		final JPanel panel = makeGrid(panel_initial);
		contentPane.add(panel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		String[] difficulties = {"Easy", "Medium", "Hard"};
		
		txtPlayerName = new JTextField();
		txtPlayerName.setText("Player Name");
		panel_1.add(txtPlayerName);
		txtPlayerName.setColumns(10);
		final JComboBox comboBox = new JComboBox(difficulties);
		comboBox.setSelectedIndex(1);
		panel_1.add(comboBox);
		
		
		final JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPlay.setEnabled(false);
				score=0; counter=0;
				int lapseTime = 300*(3-comboBox.getSelectedIndex());
				new Timer(lapseTime ,taskPerformer).start();
			}
			final ActionListener taskPerformer = new ActionListener() {
			      public void actionPerformed(ActionEvent evt) {
			    	  if(counter<=20){
			    		  counter++;
			    		  changecolors();
			    	  }
			    	  else{
		                  ((Timer) evt.getSource()).stop(); // stop the timer
		                  btnPlay.setEnabled(true);
		                  highScoreFileIO(score, txtPlayerName.getText());
			    	  }
			      }

			private void highScoreFileIO(int score, String text) {
					// TODO Auto-generated method stub
					File highScoreFile = new File("/home/kartik/Documents/workspace/Tutorial5/src/whackAMole_v2/highScores.txt");
					try {
						Scanner sc = new Scanner(highScoreFile);	
						SimpleEntry<String,Integer>[] highscores = new SimpleEntry[10];
						for(int i=0; i<10;i++){						
							String name = sc.next(); int highscore = sc.nextInt();
							if(score>=highscore){
								highscores[i]=new SimpleEntry<String, Integer>(text, score);
							}
							else{
								highscores[i]= new SimpleEntry<String, Integer>(name, highscore);
							}
						}
						sc.close();
						PrintWriter writer = new PrintWriter(highScoreFile);
						for(int i=0;i<10;i++){
							writer.println(highscores[i]);
						}
						writer.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			int nextRow, nextCol;
			private void changecolors()  {
				gameOn = true;
				File imageFile = new File("/home/kartik/Documents/workspace/Tutorial5/src/whackAMole_v2/circle.png");
				Image hole;
				try {
					hole = ImageIO.read(imageFile);					
					Image resizedHole = hole.getScaledInstance(47, 47, 1);
					ImageIcon icon = new ImageIcon(resizedHole);
					String address = "cell "+nextRow+" "+nextCol;
					JLabel label = new JLabel(icon);
					panel.remove(nextRow*4+nextCol+2); //remove the mole from the address and
					panel.add(label,nextRow*4+nextCol+2); //add a hole at the address
					panel.repaint();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Random generator = new Random();
				nextRow = generator.nextInt(3);
				nextCol = generator.nextInt(3);
				File imageFile1 = new File("/home/kartik/Documents/workspace/Tutorial5/src/whackAMole_v2/mole.jpg");
				Image mole;
				try {
					mole = ImageIO.read(imageFile1);					
					Image resizedMole = mole.getScaledInstance(47, 47, 1);
					ImageIcon icon = new ImageIcon(resizedMole);
					String address = "cell "+nextRow+" "+nextCol;
					JLabel label = new JLabel(icon);					
					label.addMouseListener(new MouseAdapter()  
					{  
					    public void mouseClicked(MouseEvent e)  
					    {  
					    	if(gameOn){
					    		score++;
					    		txtScore.setText(String.valueOf(score));
					    	}
					    }  
					}); 
					
					panel.remove(nextRow*4+nextCol+2); //remove the hole from the address and
					panel.add(label,nextRow*4+nextCol+2); //add a mole at the address
					panel.revalidate();
					txtTimer.setText(String.valueOf(21-counter));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			};});
		panel_1.add(btnPlay);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		txtTime = new JTextField();
		txtTime.setEditable(false);
		txtTime.setText("Time Remaining");
		panel_2.add(txtTime);
		txtTime.setColumns(10);
		
		txtTimer = new JTextField();
		txtTimer.setEditable(false);
		panel_2.add(txtTimer);
		txtTimer.setColumns(4);
		
		txtCurrentScore = new JTextField();
		txtCurrentScore.setEditable(false);
		txtCurrentScore.setText("Current Score");
		panel_2.add(txtCurrentScore);
		txtCurrentScore.setColumns(10);
		
		txtScore = new JTextField();
		txtScore.setEditable(false);
		panel_2.add(txtScore);
		txtScore.setColumns(10);
		
		
		
	}

	private JPanel makeGrid(JPanel panel) {
		File imageFile = new File("/home/kartik/Documents/workspace/Tutorial5/src/whackAMole_v2/circle.png");
		Image hole;
		try {
			hole = ImageIO.read(imageFile);
			Image resizedHole = hole.getScaledInstance(47, 47, 1);
			ImageIcon icon = new ImageIcon(resizedHole);
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
				JLabel label = new JLabel(icon);
				label.setSize(4,4);
				String address = "cell "+i+" "+j;
				panel.add(label,address);
			}}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return panel;
	}

}
