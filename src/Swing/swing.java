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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import StockManage.StockMain;
import EmpMange.empMain;
import EmpMange.empDTO;
import ManagerP.Benefit;
import ManagerP.BenefitDTO;
import Order_Stamp.Order_Stamp;

import java.awt.GridLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.JTextPane;




public class swing {

	class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel(Image image) {
			this.img = image;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);

		}

		public void paintComponent(Graphics g) { // 패널 열었을 때 자동으로 이미지 보이게 하는?
			g.drawImage(img, 0, 0, null);
		}

	}

	private JFrame frame;
	private final Action action = new SwingAction();
	private JTextField textField_bean;
	private JTextField textField_milk;
	private JTextField textField_choco;
	private JTextField textField_vanilla;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	

	
	

	// textPrint method : 재고 관련
	public String textPrint(List<String> e) {
		String orderedCoffee = null;
		StringBuffer stb = new StringBuffer();
		int AHcnt = 0, LHcnt = 0, MHcnt = 0, VHcnt = 0, AIcnt = 0, LIcnt = 0, MIcnt = 0, VIcnt = 0;
		List<String> fl = new ArrayList();
		for (String coffee : e) {
			if (coffee.equals("AH")) {
				++AHcnt;
				if (fl.contains("AH")) {
					continue;
				} else {
					fl.add("AH");
				}
			} else if (coffee.equals("LH")) {
				++LHcnt;
				if (fl.contains("LH")) {
					continue;
				} else {
					fl.add("LH");
				}
			} else if (coffee.equals("MH")) {
				++MHcnt;
				if (fl.contains("MH")) {
					continue;
				} else {
					fl.add("MH");
				}
			} else if (coffee.equals("VH")) {
				++VHcnt;
				if (fl.contains("VH")) {
					continue;
				} else {
					fl.add("VH");
				}
			} else if (coffee.equals("AI")) {
				++AIcnt;
				if (fl.contains("AI")) {
					continue;
				} else {
					fl.add("AI");
				}
			} else if (coffee.equals("LI")) {
				++LIcnt;
				if (fl.contains("LI")) {
					continue;
				} else {
					fl.add("LI");
				}
			} else if (coffee.equals("MI")) {
				++MIcnt;
				if (fl.contains("MI")) {
					continue;
				} else {
					fl.add("MI");
				}
			} else if (coffee.equals("VI")) {
				++VIcnt;
				if (fl.contains("VI")) {
					continue;
				} else {
					fl.add("VI");
				}
			}
		}
		for (String coffee : fl) {
			if (coffee.equals("AH")) {
				stb.append("Americano Hot \t\t " + Integer.toString(AHcnt) + "\n");

			} else if (coffee.equals("LH")) {
				stb.append("Latte Hot \t\t " + Integer.toString(LHcnt) + "\n");
			} else if (coffee.equals("MH")) {
				stb.append("Mocha latte Hot \t\t " + Integer.toString(MHcnt) + "\n");
			} else if (coffee.equals("VH")) {
				stb.append("Vanilla latte Hot \t " + Integer.toString(VHcnt) + "\n");
			} else if (coffee.equals("AI")) {
				stb.append("Americano Ice \t\t " + Integer.toString(AIcnt) + "\n");
			} else if (coffee.equals("LI")) {
				stb.append("Latte Ice \t\t " + Integer.toString(LIcnt) + "\n");
			} else if (coffee.equals("MI")) {
				stb.append("Mocha latte Ice \t\t " + Integer.toString(MIcnt) + "\n");
			} else if (coffee.equals("VI")) {
				stb.append("Vanilla latte Ice \t\t " + Integer.toString(VIcnt) + "\n");
			}
		}
		orderedCoffee = stb.toString();
		return orderedCoffee;
	}
	
	public void ObtainedMoney(List<String> e) {
		Order_Stamp os = new Order_Stamp();
		Benefit bnt=new Benefit();
		int money=0;
		StringBuffer stb = new StringBuffer();
		int AHcnt = 0, LHcnt = 0, MHcnt = 0, VHcnt = 0, AIcnt = 0, LIcnt = 0, MIcnt = 0, VIcnt = 0;
		List<String> fl = new ArrayList();
		for (String coffee : e) {
			if (coffee.equals("AH")) {
				++AHcnt;
				if (fl.contains("AH")) {
					continue;
				} else {
					fl.add("AH");
				}
			} else if (coffee.equals("LH")) {
				++LHcnt;
				if (fl.contains("LH")) {
					continue;
				} else {
					fl.add("LH");
				}
			} else if (coffee.equals("MH")) {
				++MHcnt;
				if (fl.contains("MH")) {
					continue;
				} else {
					fl.add("MH");
				}
			} else if (coffee.equals("VH")) {
				++VHcnt;
				if (fl.contains("VH")) {
					continue;
				} else {
					fl.add("VH");
				}
			} else if (coffee.equals("AI")) {
				++AIcnt;
				if (fl.contains("AI")) {
					continue;
				} else {
					fl.add("AI");
				}
			} else if (coffee.equals("LI")) {
				++LIcnt;
				if (fl.contains("LI")) {
					continue;
				} else {
					fl.add("LI");
				}
			} else if (coffee.equals("MI")) {
				++MIcnt;
				if (fl.contains("MI")) {
					continue;
				} else {
					fl.add("MI");
				}
			} else if (coffee.equals("VI")) {
				++VIcnt;
				if (fl.contains("VI")) {
					continue;
				} else {
					fl.add("VI");
				}
			}
		}
		for (String coffee : fl) {
			if (coffee.equals("AH")) {
				money+=(AHcnt*3000);
				os.OrderAmericano(AHcnt);
				
			} else if (coffee.equals("LH")) {
				money+=(LHcnt*3000);
				os.OrderLatte(LHcnt);
				
			} else if (coffee.equals("MH")) {
				money+=(MHcnt*3000);
				os.OrderMocha(AHcnt);
				
			} else if (coffee.equals("VH")) {
				money+=(VHcnt*3000);
				os.OrderVanilla(AHcnt);
				
			} else if (coffee.equals("AI")) {
				money+=(AIcnt*3000);
				os.OrderAmericano(AIcnt);
				
			} else if (coffee.equals("LI")) {
				money+=(LIcnt*3000);
				os.OrderLatte(LIcnt);
				
			} else if (coffee.equals("MI")) {
				money+=(MIcnt*3000);
				os.OrderMocha(MIcnt);
				
			} else if (coffee.equals("VI")) {
				money+=(VIcnt*3000);
				os.OrderVanilla(VIcnt);
			}
			bnt.update(money);
		}	
	}

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

		StockMain stm = new StockMain();
		empMain eM = new empMain();
		Benefit bnt = new Benefit();
		BenefitDTO bdto = new BenefitDTO();
		
		Date today = new Date();
		List<String> ClickedCoffee = new ArrayList();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		String TodayDate = date.format(today);
		
		

		// 전체 frame 설정
		frame = new JFrame();
		frame.setTitle("Cafe POS");
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 13));
		frame.setBounds(100, 100, 1200, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// panel_1 : 로그인 페이지 이미지 패널
		ImagePanel panel_1 = new ImagePanel(new ImageIcon("./image/image_login.jpg").getImage());
		File f = new File("./image/image_login.jpg");
		System.out.println(f.exists() ? "Exists" : "doesn't exist");

		JLabel id = new JLabel("ID : ");
		id.setBounds(382, 9, 39, 19);
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
		JButton logBtn = new JButton("Log In");
		logBtn.setBounds(732, 5, 83, 29);

		panel_1.add(id);
		panel_1.add(txtID);
		panel_1.add(pswd);
		panel_1.add(txtpass);
		panel_1.add(logBtn);

		frame.getContentPane().add(panel_1);
		panel_1.setVisible(true);

		// panel_2 : 커피 버튼이 있는 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("CheckBox.background"));
		panel_2.setBounds(0, 0, 1200, 630);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		// panel_2.menu 패널 : 커피 버튼들 추가될 패널
		JPanel menu = new JPanel();
		menu.setBounds(0, 30, 600, 500);
		menu.setBackground(UIManager.getColor("CheckBox.background"));
		menu.setForeground(Color.BLACK);
		panel_2.add(menu);
		menu.setLayout(null);
		// 커피 종류별 버튼
		JButton menu1 = new JButton("Iced Americano \n 3000");
		menu1.setBounds(0, 0, 150, 250);
		menu.add(menu1);

		JButton menu2 = new JButton("Iced Latte \n 3000");
		menu2.setBounds(150, 0, 150, 250);
		menu.add(menu2);

		JButton menu3 = new JButton("Iced Vanilla Latte \n 3000");
		menu3.setBounds(300, 0, 150, 250);
		menu.add(menu3);

		JButton menu4 = new JButton("Iced Mocha \n 3000");
		menu4.setBounds(450, 0, 150, 250);
		menu.add(menu4);

		JButton menu5 = new JButton("Hot Americano \n 3000");
		menu5.setBounds(0, 250, 150, 250);
		menu.add(menu5);

		JButton menu6 = new JButton("Hot Latte \n 3000");
		menu6.setBounds(150, 250, 150, 250);
		menu.add(menu6);

		JButton menu7 = new JButton("Hot Vanilla Latte \n 3000");
		menu7.setBounds(300, 250, 150, 250);
		menu.add(menu7);

		JButton menu8 = new JButton("Hot Mocha \n 3000");
		menu8.setBounds(450, 250, 150, 250);
		menu.add(menu8);

		// sale 패널 :커피 버튼 클릭하면 커피 종류 및 금액 출력되는 패널
		JPanel sale = new JPanel();
		sale.setBounds(600, 30, 600, 500);
		sale.setBackground(Color.WHITE);
		panel_2.add(sale);
		sale.setLayout(null);
		JLabel salelabel = new JLabel("Sale");
		salelabel.setFont(new Font("Verdana", Font.BOLD, 20));
		salelabel.setBounds(300, 6, 108, 29);
		sale.add(salelabel);
		JButton charge = new JButton("Charge : ");
		charge.setFont(new Font("Arial", Font.BOLD, 15));
		charge.setForeground(new Color(0, 0, 0));
		charge.setBounds(0, 400, 600, 100);
		//charge.setBackground(new Color(0, 0, 0));// 2896CC 이 컬러코드로 하고싶다.
		sale.add(charge);
		

		// textArea
		JTextArea textArea = new JTextArea();
		textArea.setBounds(130, 78, 300, 300);
		sale.add(textArea);

		// 커피 버튼 ActionListener
		panel_2.setVisible(true);
		menu.setVisible(false);
		sale.setVisible(false);
		// empButton.setVisible(false);
		// adminButton.setVisible(false);
		textArea.setVisible(true);
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("AI");
				textArea.setText(textPrint(ClickedCoffee));
				System.out.println(textPrint(ClickedCoffee));
				// string = e.getActionCommand();
				// System.out.println(e.getActionCommand());
				// textArea.setText(menu1Label2.getText());
				// textArea.append(e.getActionCommand()+"\n");
				textArea.setVisible(true);
			}
		});

		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("LI");
				textArea.setText(textPrint(ClickedCoffee));
				// textArea.setText(e.getActionCommand());
				// string = e.getActionCommand();
				// textArea.setText(string.concat(e.getActionCommand())); 오류?? 여서 잠시 주석함
				textArea.setVisible(true);
			}
		});
		menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("MI");
				textArea.setText(textPrint(ClickedCoffee));
				textArea.setVisible(true);
			}
		});
		menu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("VI");
				textArea.setText(textPrint(ClickedCoffee));
				textArea.setVisible(true);
			}
		});
		menu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("AH");
				textArea.setText(textPrint(ClickedCoffee));
				textArea.setVisible(true);
			}
		});
		menu6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("LH");
				textArea.setText(textPrint(ClickedCoffee));
				textArea.setVisible(true);
			}
		});
		menu7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("MH");
				textArea.setText(textPrint(ClickedCoffee));
				textArea.setVisible(true);
			}
		});
		menu8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(false);
				textArea.setText("");
				textArea.setText(e.getActionCommand());
				ClickedCoffee.add("VH");
				textArea.setText(textPrint(ClickedCoffee));
				textArea.setVisible(true);
			}
		});
		
		// 주문 확인 리스너
		charge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ObtainedMoney(ClickedCoffee);
				textArea.setText("");	
				
				
				}

		});
		
		
		
		

		// panel_2.bottom 패널 : 관리자,직원 버튼 클릭이 있는 패널
		JPanel bottom = new JPanel();
		bottom.setBounds(0, 530, 1200, 100);
		bottom.setBackground(new Color(0, 0, 51));
		panel_2.add(bottom);
		bottom.setLayout(null);

		// 관리자 버튼
		JButton adminButton = new JButton("관리자");
		adminButton.setBounds(26, 21, 97, 23);
		bottom.add(adminButton);

		// panel_3 : 관리자 패널
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("CheckBox.background"));
		panel_3.setBounds(0, 0, 1200, 630);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		// backButton1 : 관리자 패널에서 메뉴 패널로 돌아가는 버튼
		JButton backButton1 = new JButton("Back");
		backButton1.setBounds(0, 0, 117, 29);
		panel_3.add(backButton1);

		// 재고 입력하기 버튼
		JButton button_stockinsert = new JButton("입력하기");
		button_stockinsert.setBounds(408, 215, 117, 29);
		panel_3.add(button_stockinsert);

		// 재고 확인하기 버튼
		JButton button_stockselect = new JButton("확인하기");
		button_stockselect.setBounds(61, 276, 117, 29);
		panel_3.add(button_stockselect);

	

		// 관리자 패널에 재고입력 라벨 추가
		JLabel label_insertstock = new JLabel("재고 입력");
		label_insertstock.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		label_insertstock.setBounds(38, 55, 153, 49);
		panel_3.add(label_insertstock);

		// 관리자 패널에 매출 라벨 추가
		JLabel label = new JLabel("매출");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		label.setBounds(625, 60, 61, 44);
		panel_3.add(label);
		
		
	

		// 관리자 패널에 stock 이름 추가
		JLabel label_bean = new JLabel("원두 :");
		label_bean.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_bean.setBounds(38, 128, 61, 34);
		panel_3.add(label_bean);

		JLabel label_milk = new JLabel("우유 :");
		label_milk.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_milk.setBounds(38, 172, 61, 34);
		panel_3.add(label_milk);

		JLabel label_vanilla = new JLabel("바닐라 :");
		label_vanilla.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_vanilla.setBounds(299, 172, 87, 34);
		panel_3.add(label_vanilla);

		JLabel label_choco = new JLabel("초콜렛 :");
		label_choco.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label_choco.setBounds(299, 128, 81, 34);
		panel_3.add(label_choco);

		// 관리자 패널에 stock 입력받을 JTextField 추가
		textField_bean = new JTextField();
		textField_bean.setBounds(139, 133, 130, 26);
		panel_3.add(textField_bean);
		textField_bean.setColumns(10);

		textField_milk = new JTextField();
		textField_milk.setColumns(10);
		textField_milk.setBounds(139, 177, 130, 26);
		panel_3.add(textField_milk);

		textField_choco = new JTextField();
		textField_choco.setColumns(10);
		textField_choco.setBounds(399, 133, 130, 26);
		panel_3.add(textField_choco);

		textField_vanilla = new JTextField();
		textField_vanilla.setColumns(10);
		textField_vanilla.setBounds(398, 177, 130, 26);
		panel_3.add(textField_vanilla);

		// 관리자 패널에 재고확인 라벨 추가
		JLabel label_insertselect = new JLabel("재고 확인");
		label_insertselect.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		label_insertselect.setBounds(38, 235, 153, 49);
		panel_3.add(label_insertselect);

		// 관리자 패널에 재고확인을 할 수 있는 JTextPane 추가
		JTextPane textPane = new JTextPane();
		textPane.setBounds(105, 309, -56, 49);
		panel_3.add(textPane);

		// 재고 입력하기 버튼 액션리스너
		button_stockinsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int bean = Integer.parseInt(textField_bean.getText());
				int milk = Integer.parseInt(textField_milk.getText());
				int choco = Integer.parseInt(textField_choco.getText());
				int vanilla = Integer.parseInt(textField_vanilla.getText());
				stm.update(bean, milk, choco, vanilla);
			}

		});
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(656, 117, 395, 55);
		panel_3.add(textArea_1);
		
		
		adminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backButton1.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				button_stockinsert.setVisible(true);
				button_stockselect.setVisible(true);
				textField_milk.setVisible(true);
				textField_bean.setVisible(true);
				textField_choco.setVisible(true);
				textField_vanilla.setVisible(true);
				
				textArea_1.setText(" ");
				textArea_1.append("   오늘 날짜 \t 오늘 매출 \n ");
				int todayMoney = bnt.Selected_ShowBenefit(TodayDate);
				String Tm = Integer.toString(todayMoney);
				textArea_1.append("  "+TodayDate+"      "+Tm);

			}

		});
		
		
		
		JTextArea textArea_stockselect = new JTextArea();
		textArea_stockselect.setBounds(70, 309, 459, 177);
		panel_3.add(textArea_stockselect);
		
		button_stockselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_stockselect.setText("");
				textArea_stockselect.append(" \n");
				textArea_stockselect.append(" 원두 \t 우유\t 초코 시럽\t 바닐라 시럽 \n");
				textArea_stockselect.append(" \n");
				textArea_stockselect.append((stm.select()));
			}

		});	
		

		// backButton1 : 관리자 패널에 backButton1 누르면 메뉴로 다시 돌아감
		backButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_3.setVisible(false);
				panel_2.setVisible(true);
			}
		});

		// panel_4 :직원 패널
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(UIManager.getColor("CheckBox.background"));
		panel_4.setBounds(0, 0, 1200, 630);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		// 직원 패널에서 메뉴로 돌아가는 백 버튼
		JButton backButton2 = new JButton("Back");
		backButton2.setBounds(0, 0, 117, 29);
		panel_4.add(backButton2);

		backButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_2.setVisible(true);
			}
		});

		JLabel label_1 = new JLabel("직원 관리");
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		label_1.setBounds(38, 71, 105, 44);
		panel_4.add(label_1);

		JLabel label_empno = new JLabel("직원 번호");
		label_empno.setBounds(56, 155, 61, 16);
		panel_4.add(label_empno);

		JLabel label_empname = new JLabel("직원 이름");
		label_empname.setBounds(56, 217, 61, 16);
		panel_4.add(label_empname);

		JLabel label_emptel = new JLabel("전화 번호");
		label_emptel.setBounds(56, 285, 61, 16);
		panel_4.add(label_emptel);

		JLabel label_empsal = new JLabel("시급");
		label_empsal.setBounds(56, 351, 61, 16);
		panel_4.add(label_empsal);

		JLabel label_empworkhour = new JLabel("일한 시간");
		label_empworkhour.setBounds(56, 421, 61, 16);
		panel_4.add(label_empworkhour);

		JTextField textField_empno = new JTextField();
		textField_empno.setBounds(179, 150, 130, 26);
		panel_4.add(textField_empno);
		textField_empno.setColumns(10);

		JTextField textField_empname = new JTextField();
		textField_empname.setColumns(10);
		textField_empname.setBounds(179, 212, 130, 26);
		panel_4.add(textField_empname);

		JTextField textField_emptel = new JTextField();
		textField_emptel.setColumns(10);
		textField_emptel.setBounds(179, 280, 130, 26);
		panel_4.add(textField_emptel);

		JTextField textField_empsal = new JTextField();
		textField_empsal.setColumns(10);
		textField_empsal.setBounds(179, 346, 130, 26);
		panel_4.add(textField_empsal);

		JTextField textField_empworkhour = new JTextField();
		textField_empworkhour.setColumns(10);
		textField_empworkhour.setBounds(179, 416, 130, 26);
		panel_4.add(textField_empworkhour);

		JButton button_empinsert = new JButton("직원 등록하기");
		button_empinsert.setBounds(192, 480, 117, 29);
		panel_4.add(button_empinsert);

		button_empinsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eM.insert(textField_empno.getText(), textField_empname.getText(), 
						textField_emptel.getText(), textField_empsal.getText());

			}

		});

		JLabel label_emplist = new JLabel("직원 리스트");
		label_emplist.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		label_emplist.setBounds(623, 71, 145, 44);
		panel_4.add(label_emplist);

		JTextArea textArea_emplist = new JTextArea(); // 직원 리스트 받아올 JTextArea
		textArea_emplist.setBounds(638, 139, 522, 318);
		panel_4.add(textArea_emplist);

		JButton button_empselect = new JButton("직원 확인하기");
		button_empselect.setBounds(633, 110, 117, 29);
		panel_4.add(button_empselect);

		button_empselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기에 추가해주세여!!!
				textArea_emplist.append("   직원 번호                이름                전화번호           시급     근무시간\n");
				for(empDTO dto : eM.select()){
					int no =dto.getNo();
					String Chno = Integer.toString(no);
					textArea_emplist.append("           "+Chno +"                     ");
					String name = dto.getName();
					textArea_emplist.append(name +"\t");
					String tel = dto.getTel();
					textArea_emplist.append(tel +"     ");
					int sal = dto.getMsalary();
					String Chsal = Integer.toString(sal);
					textArea_emplist.append(Chsal +"            ");
					int wh = dto.getWorkhour();
					String Chwh = Integer.toString(wh);
					textArea_emplist.append(Chwh);
					
				}

			}

		});

		// 직원 버튼
		JButton empButton = new JButton("직원");
		empButton.setBounds(135, 21, 97, 23);
		bottom.add(empButton);

		empButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backButton2.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				textField_empno.setVisible(true);
				textField_empname.setVisible(true);
				textField_emptel.setVisible(true);
				textField_empsal.setVisible(true);
				textField_empworkhour.setVisible(true);
				button_empinsert.setVisible(true);
				button_empselect.setVisible(true);

			}
		});

		backButton1.setVisible(false);

		// logBtn액션
		// logBtn누르기 전에 첫화면에서 버튼들 안보이게 하기위해서 있음!!
		backButton2.setVisible(false);
		button_stockinsert.setVisible(false);
		button_stockselect.setVisible(false);
		textField_milk.setVisible(false);
		textField_bean.setVisible(false);
		textField_choco.setVisible(false);
		textField_vanilla.setVisible(false);
		empButton.setVisible(false);
		adminButton.setVisible(false);
		textField_empno.setVisible(false);
		textField_empname.setVisible(false);
		textField_emptel.setVisible(false);
		textField_empsal.setVisible(false);
		textField_empworkhour.setVisible(false);
		button_empinsert.setVisible(false);
		button_empselect.setVisible(false);

		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "admin";
				String pw = "1234";

				if (id.equals(txtID.getText()) && pw.equals(txtpass.getText())) {
					JOptionPane.showMessageDialog(null, "Login Success");
					panel_2.setVisible(true);
					menu.setVisible(true);
					sale.setVisible(true);
					empButton.setVisible(true);
					adminButton.setVisible(true);
					panel_1.setVisible(false);
					panel_4.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Login Fail");
				}

			}

		});

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
