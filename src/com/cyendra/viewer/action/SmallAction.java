package com.cyendra.viewer.action;

import com.cyendra.viewer.ViewerFrame;
import com.cyendra.viewer.ViewerService;

public class SmallAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, false);
	}

}
