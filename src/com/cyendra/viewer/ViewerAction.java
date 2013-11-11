package com.cyendra.viewer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.cyendra.viewer.action.Action;

public class ViewerAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String actionName = "";
	private ViewerFrame frame = null;
	private Action action = null;
	
	public ViewerAction() {
		super();
	}
	
	public ViewerAction(ImageIcon icon, String actionName, ViewerFrame frame) {
		super("", icon);
		this.actionName = actionName;
		this.frame = frame;
	}
	
	private Action getAction(String actionName){
		try{
			if (this.action == null) {
				Action action = (Action)Class.forName(actionName).newInstance();
				this.action = action;
			}
			return this.action;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "√ª”–’“µΩaction", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
			return null;
		}		
	}

	public void actionPerformed(ActionEvent arg0) {
		ViewerService service = ViewerService.getInstance();
		Action action = getAction(this.actionName);
		action.execute(service, frame);
	}

}
