package com.cyendra.viewer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.io.File;

import javax.swing.filechooser.FileFilter;

import java.util.List;
import java.util.ArrayList;

public class ViewerService {
	
	private static ViewerService service = null;
	
	private ViewerFileChooser fileChooser = new ViewerFileChooser();
	private File currentDirectory = null;
	private List<File> currentFiles = null;
	private File currentFile = null;
	private ImageIcon baseIcon = null;
	
	private double range = 0.2;
	private int rangeTime = 0;
	
	private ViewerService() {
		//empty
	}
	
	public static ViewerService getInstance() {
		if (service == null) service = new ViewerService();
		return service;
	}
	
	private void refreshIcon(ImageIcon icon) {
		baseIcon=icon;
		rangeTime=0;
	}

	public void zoom(ViewerFrame frame, boolean isEnlarge) {
		if (isEnlarge)  rangeTime++;
		else rangeTime--;
		double enLargeRange=Math.pow(1+range,rangeTime);
		if (baseIcon!=null){
			int width=(int)(baseIcon.getIconWidth()*enLargeRange);
			ImageIcon newIcon=new ImageIcon(baseIcon.getImage().getScaledInstance(width, -1, Image.SCALE_DEFAULT));
			frame.getLabel().setIcon(newIcon);
		}
	}

	public void last(ViewerFrame frame) {
		if (this.currentFiles!=null&&!this.currentFiles.isEmpty()){
			int n=this.currentFiles.size();
			int index=this.currentFiles.indexOf(this.currentFile);
			index=(index-1+n)%n;
			File file=(File)this.currentFiles.get(index);
			ImageIcon icon=new ImageIcon(file.getPath());
			frame.getLabel().setIcon(icon);
			refreshIcon(icon);
			this.currentFile=file;
		}
	}

	public void next(ViewerFrame frame) {
		if (this.currentFiles!=null&&!this.currentFiles.isEmpty()){
			int n=this.currentFiles.size();
			int index=this.currentFiles.indexOf(this.currentFile);
			index=(index+1)%n;
			File file=(File)this.currentFiles.get(index);
			ImageIcon icon=new ImageIcon(file.getPath());
			frame.getLabel().setIcon(icon);
			refreshIcon(icon);
			this.currentFile=file;
		}
	}
	
	private MyFileFilter getAllFile() {
		return new MyFileFilter(new String[] { ".BMP",".JPG", ".JPEG", ".JPE", ".JFIF",
				".GIF", ".TIF", ".TIFF",".PNG", ".ICO" }, 
				"所有图形文件");
	}
	
	public void open(ViewerFrame frame) {
		if (fileChooser.showOpenDialog(frame)==ViewerFileChooser.APPROVE_OPTION){
			this.currentFile=fileChooser.getSelectedFile();
			String name=this.currentFile.getPath();
			File cd=fileChooser.getCurrentDirectory();
			if (cd!=this.currentDirectory||this.currentDirectory==null){
				FileFilter filter=getAllFile();
				File files[]=cd.listFiles();
				this.currentFiles=new ArrayList<File>();
				for (File file:files){
					if (filter.accept(file)) this.currentFiles.add(file);
				}
			}
			ImageIcon icon=new ImageIcon(name);
			frame.getLabel().setIcon(icon);
			refreshIcon(icon);
		}
	}

	public void menuDo(ViewerFrame frame, String cmd) {
		if (cmd.equals("打开(O)")) open(frame);
		if (cmd.equals("放大(M)")) zoom(frame, true);
		if (cmd.equals("缩小(O)")) zoom(frame, false);
		if (cmd.equals("上一个(X)")) last(frame);
		if (cmd.equals("下一个(P)")) next(frame);
		if (cmd.equals("退出(X)")) System.exit(0);
		if (cmd.equals("关于")) JOptionPane.showMessageDialog(frame, "图片浏览器 悦图 v1.0","关于",JOptionPane.INFORMATION_MESSAGE);
	}

}
