package com.cyendra.viewer.action;

import com.cyendra.viewer.ViewerFrame;
import com.cyendra.viewer.ViewerService;

public class OpenAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.open(frame);
	}

}
