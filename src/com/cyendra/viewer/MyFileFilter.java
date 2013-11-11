package com.cyendra.viewer;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {
	String[] suffarr;
	String decription;

	public MyFileFilter() {
		super();
	}
	
	public MyFileFilter(String[] suffarr, String decription) {
		super();
		this.suffarr = suffarr;
		this.decription = decription;
	}
	
	public boolean accept(File f) {
		for (String s : suffarr) {
			if (f.getName().toUpperCase().endsWith(s)) {
				return true;
			}
		}
		return f.isDirectory();
	}

	public String getDescription() {
		return this.decription;
	}

}
