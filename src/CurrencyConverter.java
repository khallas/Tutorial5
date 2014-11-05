import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class CurrencyConverter {

	private JFrame frame;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 450, 19);
		textField.setText("Amount");
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(0, 31, 186, 38);
		String items[] = { "USD", "GBP", "Yen", "Euro", "INR" };
        for(String s : items){
        	comboBox.addItem(s);
        }
		frame.getContentPane().add(comboBox);
		
		final JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(252, 31, 186, 38);
		for (String s: items){
		comboBox_1.addItem(s);
		}
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float inputCurrencyValue = Float.parseFloat(textField.getText());
				int initialCurrency = comboBox.getSelectedIndex();
				int finalCurrency = comboBox_1.getSelectedIndex();
				double dollar = getDollar(inputCurrencyValue, initialCurrency);
				double finalCurrencyValue = getConverted(dollar, finalCurrency);
				textField.setText(String.valueOf(finalCurrencyValue));
				
				File file = new File ("/home/kartik/Documents/workspace/Tutorial5/src/file.txt");
				try {
					PrintWriter pw = new PrintWriter(file);
					pw.println( inputCurrencyValue +String.valueOf(comboBox.getSelectedItem())+" is "+ finalCurrencyValue+String.valueOf(comboBox_1.getSelectedItem()));
					pw.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Can't find file");
					e1.printStackTrace();
				}
			}
			private double getConverted(double dollar, int finalCurrency) {
				double convertedCurrency =0;
				switch (finalCurrency){
				case 0: convertedCurrency = dollar;
				case 1: convertedCurrency = dollar*0.62;
				case 2: convertedCurrency = dollar*108;
				case 3: convertedCurrency = dollar*0.79;
				case 4: convertedCurrency = dollar*61.17;
				}
				return convertedCurrency;
			}

			private double getDollar(float inputCurrencyValue,
					int initialCurrency) {
				double dollar = 0;
				switch (initialCurrency){
				case 0 : dollar = inputCurrencyValue; break;
				case 1 : dollar = inputCurrencyValue * 1.61; break;
				case 2 : dollar = inputCurrencyValue * 0.0093; break;
				case 3 : dollar = inputCurrencyValue * 1.27; break;
				case 4 : dollar = inputCurrencyValue * 0.016; break; 
				}
				return dollar;
			}
		});
		btnNewButton.setBounds(0, 247, 450, 25);
		frame.getContentPane().add(btnNewButton);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
