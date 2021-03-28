
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Beauteacher extends JFrame {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 400;
	private static final int FIELD_WIDTH = 10;
	private static final int AREA_HEIGHT = 14;
	private static final int AREA_WIDTH = 35;
	JCheckBox check1;
	JCheckBox check2;
	JCheckBox check3;
	JCheckBox check4;
	JTextArea resultarea;
	JButton search;
	ArrayList<String>records;
	String ClassName;

	public Beauteacher() {
		add(createcheckbox(), BorderLayout.NORTH);
		add(createresult(), BorderLayout.CENTER);
		setTitle("Beauty Gang Tutor Team");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}

	public JPanel createcheckbox() {
		check1 = new JCheckBox("Judy Joke");
		check2 = new JCheckBox("可可數理");
		check3 = new JCheckBox("Anna English");
		check4 = new JCheckBox("芭老師社會");
		JPanel panel1 = new JPanel();
		panel1.add(check1);
		panel1.add(check2);
		panel1.add(check3);
		panel1.add(check4);
		panel1.add(createsearch());
		panel1.setBorder(new TitledBorder(new EtchedBorder(), "你是誰？"));
		return panel1;
	}

	public JPanel createresult() {
		resultarea = new JTextArea(AREA_HEIGHT, AREA_WIDTH);
		resultarea.setEditable(false);
		JPanel panel2 = new JPanel();
		
		panel2.add(resultarea);
		return panel2;
	}

	public JButton createsearch() {
		search = new JButton("搜尋");
		class searchListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				resultarea.selectAll();
				resultarea.replaceSelection("");
				if(records!=null && !records.isEmpty())records.clear();
            try {
            	if(check1.isSelected()) {
            		getRecords("joke");
            		this.setData();
            		}
            		if(check2.isSelected()) {
            			getRecords("math");
            			this.setData();
            		}
            		if(check3.isSelected()) {
                		getRecords("english");
                		this.setData();}
            		if(check4.isSelected()) {
                		getRecords("social");
                		this.setData();}
            	
            }
            catch(SQLException e){
            	resultarea.setText("");
            	e.printStackTrace();
            }}
            public void setData() {
        		// TODO Auto-generated method stub
        		for(int i=0;i<records.size();i++) {
        			resultarea.append(records.get(i));
        			resultarea.append("\n");
        		}
            }
            private ArrayList<String> getRecords(String string) throws SQLException {
        		Connection conn=SimpleDataSource.getConnection();
        		// TODO Auto-generated method stub
        		String a="";
        		try {
        			records=new ArrayList<String>();
        			PreparedStatement stat=conn.prepareStatement("SELECT * FROM Student WHERE Class=?");
        			stat.setString(1, string);
        			ResultSet result=stat.executeQuery();
        			while(result.next()) {
        				a=result.getString("Class")+" "+result.getString("Student_ID")+" "+result.getString("Name")+" "+result.getString("Birthday")+" ";
        				records.add(a);
        			}
        			return records;	
        		}
        		finally {
        			conn.close();
        		}
        	}}
            search.addActionListener(new searchListener());
            return search;}
	

	
	

}
