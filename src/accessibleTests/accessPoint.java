package accessibleTests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

class accessPoint extends JPanel{
	public AccessibleContext getAccessibleContext(){
		return super.getAccessibleContext();
	}
	{
	super.setBackground(Color.BLACK);
	}
	public accessPoint() {
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		JButton button = new JButton("blue");
		JButton button2 = new JButton("black");
		layout.addLayoutComponent("blue button", button);
		layout.addLayoutComponent("black button", button2);
		this.add(button);
		this.add(button2);
		JPanel that = this;
	button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			that.setBackground(Color.BLUE);
		}
	});
	button2.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			that.setBackground(Color.BLACK);
		}
	});
button.getAccessibleContext().setAccessibleName("blue button");
	}
	
	public static void main(String[] args) {
		accessPoint accessing = new accessPoint();
		JFrame access = new JFrame("accessible");
		access.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		access.getContentPane().add(accessing);		
	access.getAccessibleContext();
	accessing.getAccessibleContext();
		FlowLayout flowLayout = new FlowLayout();
		accessing.setLayout(flowLayout);
		access.setVisible(true);		
		access.setExtendedState(access.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

}
