

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class originalFrame extends JFrame {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;
	JLabel who;
	JRadioButton student;
	JRadioButton teacher;
	ButtonGroup group;
	JButton yes;
	JPanel panel;
	JFrame frame;

	public JPanel createoriframe() {
		who = new JLabel("你是誰？");
		student = new JRadioButton("我是學生！");
		teacher = new JRadioButton("我是老師！");
		yes = new JButton("確認");
		class chooselistener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (student.isSelected()) {
					if (yes.isEnabled()) {
						JFrame frame = new BeautyFrame();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);

					}
				} else if (teacher.isSelected()) {
					if (yes.isEnabled()) {
						JFrame frame2 =new Beauteacher();
						frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame2.setVisible(true);

					}
				}
			}
		}
		yes.addActionListener(new chooselistener());
		group = new ButtonGroup();
		group.add(student);
		group.add(teacher);
		panel = new JPanel();
		panel.add(who);
		panel.add(student);
		panel.add(teacher);
		panel.add(yes);

		return panel;
	}

	public originalFrame() {
		add(createoriframe());
		setTitle("Beauty Gang Tutor Team");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}

}

