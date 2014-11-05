package exercise5_5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class focusListener extends JFrame {

	private JPanel contentPane;
	private JTextField txtText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					focusListener frame = new focusListener();
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
	public focusListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		final JLabel lblInformation = new JLabel("Information");
		panel.add(lblInformation);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnSave = new JButton("save");
		btnSave.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblInformation.setText("Saves your files");
			}
			@Override
			public void focusLost(FocusEvent e){
				lblInformation.setText("Information");
			}
		});
		panel_1.add(btnSave);
		
		JButton btnOpen = new JButton("open");
		btnOpen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblInformation.setText("Open a file");
			}
			@Override
			public void focusLost(FocusEvent e){
				lblInformation.setText("Information");
			}
		});
		panel_1.add(btnOpen);
		
		txtText = new JTextField();
		txtText.setText("text");
		txtText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblInformation.setText("Add a line to your file");
			}
			@Override
			public void focusLost(FocusEvent e){
				lblInformation.setText("Information");
			}
		});
		panel_1.add(txtText);
		txtText.setColumns(10);
		
		JToggleButton tglbtnAutosave = new JToggleButton("AutoSave");
		tglbtnAutosave.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblInformation.setText("Saves your file as you write");
			}
			@Override
			public void focusLost(FocusEvent e){
				lblInformation.setText("Information");
			}
		});
		panel_1.add(tglbtnAutosave);
	}

}
