package com.cyendra.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewerFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private final int PRE_WIDTH = 800;
	private final int PRE_HEIGHT = 600;
	
	private JLabel label = new JLabel();
	ViewerService service = ViewerService.getInstance();
	
	public ViewerFrame() {
		super();
		initialize();
	}
	
	public void initialize() {
		this.setTitle("悦图");
		this.setPreferredSize(new Dimension(PRE_WIDTH,PRE_HEIGHT));
		createMenuBar();
		JPanel toolBar=createToolPanel();
		this.add(toolBar,BorderLayout.NORTH);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(new JScrollPane(label),BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
	}
	
	private JPanel createToolPanel() {
		JPanel panel=new JPanel();
		JToolBar toolBar=new JToolBar("工具");
		toolBar.setFloatable(false);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		String[] toolarr = { "com.cyendra.viewer.action.OpenAction", 
				"com.cyendra.viewer.action.LastAction", 
				"com.cyendra.viewer.action.NextAction", 
				"com.cyendra.viewer.action.BigAction", 
				"com.cyendra.viewer.action.SmallAction" };
		for (int i=0;i<toolarr.length;i++){
			ViewerAction action=new ViewerAction(new ImageIcon("img/"+toolarr[i]+".gif"),toolarr[i],this );
			JButton button=new JButton(action);
			toolBar.add(button);
		}
		panel.add(toolBar);
		return panel;
	}
	private void createMenuBar() {
		JMenuBar menuBar=new JMenuBar();
		String[] menuArr={"文件(F)","工具(T)","帮助(H)"};
		String[][] menuItemArr={
				{"打开(O)","-","退出(X)"},
				{"放大(M)","缩小(O)","-","上一个(X)","下一个(P)"},
				{"关于"}
		};
		for (int i=0;i<menuArr.length;i++){
			JMenu menu=new JMenu(menuArr[i]);
			for (int j=0;j<menuItemArr[i].length;j++){
				if (menuItemArr[i][j].equals("-")){
					menu.addSeparator();
				}
				else{
					JMenuItem menuItem=new JMenuItem(menuItemArr[i][j]);
					menuItem.addActionListener(this);
					menu.add(menuItem);
				}
			}
			menuBar.add(menu);
		}
		this.setJMenuBar(menuBar);
	}

	public void actionPerformed(ActionEvent e) {
		service.menuDo(ViewerFrame.this,e.getActionCommand());
	}

	public JLabel getLabel() {
		return this.label;
	}
	
}
