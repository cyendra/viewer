package com.cyendra.viewer.action;

import com.cyendra.viewer.ViewerFrame;
import com.cyendra.viewer.ViewerService;

public interface Action {
	void execute(ViewerService service, ViewerFrame frame);
}
