package com.cyendra.viewer;

import java.io.File;
import javax.swing.JFileChooser;

public class ViewerFileChooser extends JFileChooser {
	
	private static final long serialVersionUID = 1L;
	
	private String defaultDisk = "e:/";
	
	public ViewerFileChooser() {
		super();
		setAcceptAllFileFilterUsed(false);
		addFilter();
		setDefault();
	}
	
	public ViewerFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		setAcceptAllFileFilterUsed(false);
		addFilter();
		setDefault();
	}
	
	private void addFilter() {
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP" },
																	"BMP (*.BMP)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".JPG",".JPEG", ".JPE", ".JFIF" },
																	"JPEG (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".GIF" },
																	"GIF (*.GIF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".TIF",".TIFF" }, 
																	"TIFF (*.TIF;*.TIFF)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".PNG" },
																	"PNG (*.PNG)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".ICO" },
																	"ICO (*.ICO)"));
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",".JPG", ".JPEG", ".JPE", ".JFIF",
																	".GIF", ".TIF", ".TIFF",".PNG", ".ICO" }, 
																	"所有图形文件"));
	}
	private void setDefault() {
		this.setCurrentDirectory(new File(defaultDisk));
	}
}
