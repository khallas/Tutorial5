package exercise5_5;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.TransferHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;

import net.miginfocom.swing.MigLayout;

import org.eclipse.swt.graphics.Point;
import javax.swing.JToolBar;

public class mouseListener extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mouseListener frame = new mouseListener();
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
	public mouseListener() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JLabel lblMovementCoordinatesAnd = new JLabel("Movement Coordinates and Name of Component");
		lblMovementCoordinatesAnd.setBounds(49, 5, 342, 15);
		panel.add(lblMovementCoordinatesAnd);
		
		final JLabel label = new JLabel("                                                            ");
		label.setBounds(39, 30, 240, 15);
		panel.add(label);
		
	
		final JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(284, 25, 117, 25);
		panel.add(btnNewButton);
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				java.awt.Point screenLocation = panel.getLocationOnScreen();
				java.awt.Point currentLocation = MouseInfo.getPointerInfo().getLocation();
				int x = currentLocation.x-screenLocation.x;
				int y = currentLocation.y-screenLocation.y;				
				String output = ("X - "+x+" Y - "+y);
				label.setText(output);				
				btnNewButton.setLocation(x, y);
			}
		});


	}

}
