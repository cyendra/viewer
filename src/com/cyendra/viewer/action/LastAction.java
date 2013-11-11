package com.cyendra.viewer.action;

import com.cyendra.viewer.ViewerFrame;
import com.cyendra.viewer.ViewerService;

public class LastAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.last(frame);
	}

}