import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BeautyFrame extends JFrame {
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 700;
	private static final int FIELD_WIDTH = 10;
	private static final int AREA_HEIGHT = 14;
	private static final int AREA_WIDTH = 35;

	String a = "----------------------報名資訊如下-----------------------";
	String newss = "";
	JFrame frame;
	int sum;

	String infomation;
	JLabel info;
	JLabel nameLabel;
	JLabel birthLabel;
	// JLabel discount;
	JLabel tele;
	JLabel email;
	JLabel news;
	JLabel baoming1;
	JLabel baoming2;
	JLabel book;
	JLabel beauty;
	JLabel judy;
	JLabel christine;
	JLabel shia;
	JLabel barbie;

	JTextField nameField;
	JTextField teleField;
	JTextField emailField;
	JTextArea result;

	JComboBox<String> year;
	JComboBox<String> month;
	JComboBox<String> day;

	JRadioButton yes;
	JRadioButton no;
	ButtonGroup bGroup;
	JButton submit;
	JButton sure;
	JButton nope;
	JButton total;
	JButton clean;

	JCheckBox check1;
	JCheckBox check2;
	JCheckBox check3;
	JCheckBox check4;

	JScrollPane scrollPane;
	JPanel coverPanel;
	JPanel infoPanel;
	JPanel resultPanel;
	JPanel picturePanel;
	JPanel chickPanel;
	String name;
	String birth;

	public JPanel createcoverPanel() {
		coverPanel = new JPanel();
		judy = new JLabel();
		christine = new JLabel();
		shia = new JLabel();
		barbie = new JLabel();
		// beauty = new JLabel("Beauty Gang Tutor Team");
		// beauty.setFont(new Font("標楷體", Font.BOLD, 25));
		// coverPanel.add(beauty);
		return coverPanel;
	}

	public JPanel createPicturePanel() {
		JPanel picture = new JPanel();
		ImageIcon judyy = new ImageIcon(new ImageIcon("/Users/chanchu-ting/Desktop/1.jpg").getImage()
				.getScaledInstance(180, 300, Image.SCALE_DEFAULT));
		ImageIcon christinee = new ImageIcon(new ImageIcon("/Users/chanchu-ting/Desktop/2.jpg").getImage()
				.getScaledInstance(180, 300, Image.SCALE_DEFAULT));
		ImageIcon shiaa = new ImageIcon(new ImageIcon("/Users/chanchu-ting/Desktop/3.jpg").getImage()
				.getScaledInstance(180, 300, Image.SCALE_DEFAULT));
		ImageIcon barbiee = new ImageIcon(new ImageIcon("/Users/chanchu-ting/Desktop/4.jpg").getImage()
				.getScaledInstance(180, 300, Image.SCALE_DEFAULT));
		judy.setIcon(judyy);
		christine.setIcon(christinee);
		shia.setIcon(shiaa);
		barbie.setIcon(barbiee);
		picture.add(judy);
		picture.add(christine);
		picture.add(shia);
		picture.add(barbie);
		return picture;
	}

	public JPanel createCheckPanel() {
		JPanel checkPanel = new JPanel();
		check1 = new JCheckBox();
		check2 = new JCheckBox();
		check3 = new JCheckBox();
		check4 = new JCheckBox();

		check1.setText("Judy Joke");
		check2.setText("可可數理");
		check3.setText("Anna English");
		check4.setText("芭比社會");

		checkPanel.setLayout(new GridLayout(4, 1));
		checkPanel.add(check1);
		checkPanel.add(check2);
		checkPanel.add(check3);
		checkPanel.add(check4);
		return checkPanel;
	}

	public JPanel createHead() {
		JPanel head = new JPanel();
		head.add(createcoverPanel(), BorderLayout.NORTH);
		head.add(createPicturePanel(), BorderLayout.CENTER);
		head.add(createCheckPanel(), BorderLayout.SOUTH);

		return head;
	}

	public JPanel createinfoPanel() {
		infoPanel = new JPanel();
		infoPanel.setBorder(new TitledBorder(new EtchedBorder(), "輸入個人資料"));
		nameLabel = new JLabel("姓名:");
		birthLabel = new JLabel("生日:");
		// discount = new JLabel(" 「 生日當月可享87折優惠唷！」");
		tele = new JLabel("聯絡電話：");
		email = new JLabel("電子郵件：");
		news = new JLabel("                  是否訂閱美麗幫電子報呢？");
		createSubmit();

		nameField = new JTextField(FIELD_WIDTH);
		teleField = new JTextField(FIELD_WIDTH);
		emailField = new JTextField(FIELD_WIDTH);
		year = new JComboBox<String>();
		month = new JComboBox<String>();
		day = new JComboBox<String>();
		
		teleField.setDocument(new NumberLengthLimitDmt(10));


		year.addItem("西元年");
		for (int i = 1980; i <= 2012; i++) {
			year.addItem("" + i);
		}

		month.addItem("月");
		for (int i = 1; i <= 12; i++) {
			month.addItem("" + i);
		}

		day.addItem("日");
		for (int i = 1; i <= 31; i++) {
			day.addItem("" + i);
		}

		yes = new JRadioButton("好哇");
		no = new JRadioButton("先不要");
		bGroup = new ButtonGroup();
		bGroup.add(yes);
		bGroup.add(no);

		JPanel panel1 = new JPanel();
		panel1.add(nameLabel);
		panel1.add(nameField);

		JPanel panel3 = new JPanel();
		panel3.add(birthLabel);
		panel3.add(year);
		panel3.add(month);
		panel3.add(day);
		// panel3.setLayout(new GridLayout(1, 4));

		JPanel panel4 = new JPanel();
		panel4.add(tele);
		panel4.add(teleField);

		infoPanel.add(panel1);
		infoPanel.add(panel3);
		// infoPanel.add(discount);
		infoPanel.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.add(email);
		panel5.add(emailField);
		infoPanel.add(panel5);

		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();

		panel6.add(yes);
		panel6.add(no);
		panel7.add(submit);
		infoPanel.add(news);
		infoPanel.add(panel6);
		infoPanel.add(panel7);

		infoPanel.setLayout(new GridLayout(10, 1));

		return infoPanel;
	}

	public JPanel createResultPanel() {
		resultPanel = new JPanel();
		resultPanel.setBorder(new TitledBorder(new EtchedBorder(), "繳費資訊"));
		baoming1 = new JLabel("報名一科： 870元" + "\n" + "報名兩科：1680元");
		baoming2 = new JLabel("報名三科：2300元" + "\n" + "報名全科：2500元" + "\n");

		total = new JButton("合計");
		clean = new JButton("清除");

		result = new JTextArea(AREA_HEIGHT, AREA_WIDTH);
		createResult();
		createtotalButton();
		createCleanBtn();
		resultPanel.add(baoming1);
		resultPanel.add(baoming2);
		resultPanel.add(result);
		resultPanel.add(total);
		resultPanel.add(clean);
		beauty = new JLabel("Beauty Gang Tutor Team");
		beauty.setFont(new Font("標楷體", Font.BOLD, 25));
		resultPanel.add(beauty);
		return resultPanel;

	}

	public void createResult() {
		result.setEditable(false);
		result.setText(a);

	}

	public JButton createSubmit() {
		submit = new JButton("送出");
		class submitListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				String name = "\n姓名: " + nameField.getText() + "\n";
				String birth = "生日: " + "西元" + (String) year.getSelectedItem() + "年" + (String) month.getSelectedItem()
						+ "月" + (String) day.getSelectedItem() + "日\n";
				String phone = "電話: " + teleField.getText() + "\n";
				String mail = "電子郵件: " + emailField.getText() + "\n";
				String newss = "";

				if (yes.isSelected()) {
					newss = "我要訂閱美麗幫電子報！";
				} else if (no.isSelected()) {
					newss = "關於電子報的部分我先pass!";
				}
				infomation = a + name + birth + phone + mail + newss;
			}

		}
		submit.addActionListener(new submitListener());

		return submit;
	}

	public JButton createtotalButton() {
		total = new JButton("合計");

		class TotalActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int money = sum_tuition();
				String bill = infomation + "\n" + "報名成功＾＿＾！ 你要繳：" + money
						+ "元\n\n\n                     ^-------^\n                   " + "  |    > . <    | "
						+ "\n          凸        (       D       )        凸\n                       _________";
				result.setForeground(Color.WHITE);
				result.setBackground(Color.BLACK);
				result.setText(bill);
			}
		}
		total.addActionListener(new TotalActionListener());
		return total;
	}

	public int sum_tuition() {
		ArrayList<JCheckBox> tuition = new ArrayList<JCheckBox>();
		sum = 0;
		tuition.add(check1);
		tuition.add(check2);
		tuition.add(check3);
		tuition.add(check4);
		int count = 0;
		for (int i = 0; i <= 3; i++) {
			if (tuition.get(i).isSelected() == true) {
				count = count + 1;
			}
		}
		if (count == 1) {
			sum = 870;
		}
		if (count == 2) {
			sum = 1680;
		}
		if (count == 3) {
			sum = 2300;
		}
		if (count == 4) {
			sum = 2500;
		}
		return sum;
	}

	public void createCleanBtn() {
		clean = new JButton("清除");

		class CleanActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				nameField.setText(" ");
				year.setSelectedIndex(0);
				month.setSelectedIndex(0);
				day.setSelectedIndex(0);
				teleField.setText(" ");
				emailField.setText(" ");
				bGroup.clearSelection();
				result.setText(" ");
				check1.setSelected(false);
				check2.setSelected(false);
				check3.setSelected(false);
				check4.setSelected(false);
			}
		}
		clean.addActionListener(new CleanActionListener());
	}

	public BeautyFrame() {
		add(createHead(), BorderLayout.NORTH);
		add(createinfoPanel(), BorderLayout.WEST);
		add(createResultPanel(), BorderLayout.CENTER);
		setTitle("Beauty Gang Tutor Team");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}

}
