package FileIO;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Blogger extends JFrame {

	private JPanel contentPane;
	private JTextField txtFile;
	private JPanel panel_1;
	private JTextArea textArea;
	private JButton btnSave;
	private File f;
	String content;
	private JButton btnShowLastEntry;
	private JButton btnNewEntry;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blogger frame = new Blogger();
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
	public Blogger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtFile = new JTextField();
		txtFile.setText("File Path");
		panel.add(txtFile);
		txtFile.setColumns(30);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileName = "/home/kartik/Documents/workspace/Tutorial5/src/FileIO/"+txtFile.getText();
				f = new File(fileName);
				try {
					content = new Scanner(f).useDelimiter("\\Z").next();
//					textArea.setText(content);
//					textArea.setEnabled(true);
					btnSave.setEnabled(true);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		panel.add(btnOpen);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setColumns(35);
		textArea.setRows(12);
		panel_1.add(textArea);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					System.out.println(dateFormat.format(date)); 

					PrintWriter writer = new PrintWriter(f);
					writer.println(content+"\nNewBlogEntry\n"+dateFormat.format(date)+"\n"+textArea.getText());
					writer.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnShowLastEntry = new JButton("Show Last Entry");
		btnShowLastEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] entries = content.split("NewBlogEntry");
				textArea.setText(entries[entries.length-1]);
				textArea.setEnabled(true);
			}
		});

		panel_1.add(btnShowLastEntry);
		
		btnNewEntry = new JButton("New Entry");
		btnNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setEnabled(true);
				textArea.setText(null);
				btnSave.setEnabled(true);
			}
		});

		panel_1.add(btnNewEntry);
		btnSave.setEnabled(false);
		panel_1.add(btnSave);
	}

}
