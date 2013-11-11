package com.cyendra.viewer.action;

import com.cyendra.viewer.ViewerFrame;
import com.cyendra.viewer.ViewerService;

public class NextAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.next(frame);
	}

}