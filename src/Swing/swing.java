package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;

public class swing {
	
	class ImagePanel extends JPanel{
		private Image img;
		public ImagePanel(Image image) {
			this.img = image;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
			
		} 
		public void paintComponent(Graphics g) { //패널 열었을 때 자동으로 이미지 보이게 하는? 
			g.drawImage(img, 0, 0, null);
		}
		
	}

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing window = new swing();
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
	public swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cafe POS");
		frame.getContentPane().setFont(new Font("NanumGothic", Font.PLAIN, 13));
		frame.setBounds(100, 100, 1200, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); 
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		ImagePanel imagePanel = new ImagePanel(new ImageIcon("./image/image_login.jpg").getImage());
//		File f = new File("./image/image_login.jpg");
//		System.out.println(f.exists()?"Exists":"doesn't exist");
		frame.getContentPane().add(imagePanel);
		//frame.pack(); 
	
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 1200, 630);
		JLabel id = new JLabel("ID : ");
		id.setBounds(553, 10, 39, 19);
		id.setFont(new Font("Arial", Font.BOLD, 16));
		id.setForeground(Color.WHITE);
		JLabel pswd = new JLabel("PW : ");
		pswd.setBounds(553, 10, 39, 19);
		pswd.setFont(new Font("Arial", Font.BOLD, 16));
		pswd.setForeground(Color.WHITE);
		JTextField txtID = new JTextField(10);
		txtID.setBounds(418, 6, 130, 26);
		JPasswordField txtpass = new JPasswordField(10);
		txtpass.setBounds(597, 6, 130, 26);
		JButton logBtn =  new JButton("Log In");
		logBtn.setBounds(732, 5, 83, 29);
		panel_1.setLayout(null);
		
		panel_1.add(id);
		panel_1.add(txtID);
		panel_1.add(pswd);
		panel_1.add(txtpass);
		panel_1.add(logBtn);
		
		frame.getContentPane().add(panel_1); 
		panel_1.setVisible(true);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 6, 1200, 630);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(335, 5, 117, 29);
		panel_2.add(btnNewButton);
		
		panel_2.setVisible(false);

		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pw = "1234";	
				
				if(id.equals(txtID.getText())&& pw.equals(txtpass.getText())) {
					JOptionPane.showMessageDialog(null, "Login Success");
					panel_2.setVisible(true);
					panel_1.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Login Fail");
				}
				
			}
			
		});
		

		 
	}
}
