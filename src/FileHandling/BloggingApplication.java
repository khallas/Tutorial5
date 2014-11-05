package FileHandling;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JTextArea;
import javax.swing.JButton;

import components.FileChooserDemo;

public class BloggingApplication extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloggingApplication frame = new BloggingApplication();
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
	public BloggingApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFli = new JMenu("File");
		menuBar.add(mnFli);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final FileChooserDemo chooser = new FileChooserDemo();
				//chooser.createAndShowGUI();
				
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                //Turn off metal's use of bold fonts
		                UIManager.put("swing.boldMetal", Boolean.FALSE); 
		                chooser.createAndShowGUI();
		            }
		        });

//				
//				JFileChooser openFile = new JFileChooser("/home/kartik/Documents/");
//				JButton openButton = new JButton("Open a file");
//				//openButton.addActionListener(this);
//				int returnVal = openFile.showOpenDialog(menuBar);
//		        if (returnVal == JFileChooser.APPROVE_OPTION) {
//		            File file = openFile.getSelectedFile();
//		            //This is where a real application would open the file.
//		        } 
			}
		});
		mnFli.add(mntmOpen);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setColumns(20);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnSave = new JButton("Save");
		panel_1.add(btnSave);
	}

}
