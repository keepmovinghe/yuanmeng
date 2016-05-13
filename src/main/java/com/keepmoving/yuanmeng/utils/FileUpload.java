package com.keepmoving.yuanmeng.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

public class FileUpload {

	private String savePath;
	/** 这里的名字和html的名字必须对称 */
	private File img;
	/** 要上传的文件类型 */
	private String imgContentType;
	/** 文件的名称 */
	private String imgFileName;

	private String orderId;

	public String getSavePath() {
		return savePath;
	}

	public File getImg() {
		return img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 指定的上传类型图片格式的文件
	 */
	private static final String[] allowFiles = { ".pjpeg", ".pjpeg", ".x-png", ".jpeg", ".png" };

	// 原始文件名
	private String originalName = "";
	// 上传文件名
	private String fileName = "";
	// 文件大小限制，单位KB
	private int maxSize = 1;

	/**
	 * 上传文件操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String upload(HttpServletRequest request, HttpServletResponse response, String uId, String fileType)
			throws Exception {
		String servletPath = "/";// request.getServletPath();
		String realPath = request.getSession().getServletContext().getRealPath(servletPath);
		this.savePath = new File(realPath) + "\\" + "upload" + "\\" + uId + "\\" + fileType;

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			return "";
		}
		DiskFileItemFactory dff = new DiskFileItemFactory();
		String savePath = this.getFolder(this.savePath);
		dff.setRepository(new File(savePath));
		try {
			ServletFileUpload sfu = new ServletFileUpload(dff);
			sfu.setSizeMax(this.maxSize * 1024);
			sfu.setHeaderEncoding("UTF-8");
			FileItemIterator fii = sfu.getItemIterator(request);
			while (fii.hasNext()) {
				FileItemStream fis = fii.next();
				if (!fis.isFormField()) {
					this.originalName = fis.getName()
							.substring(fis.getName().lastIndexOf(System.getProperty("file.separator")) + 1);
					if (!this.checkFileType(this.originalName)) {
						// this.state = this.errorInfo.get("TYPE");
						continue;
					}
					this.fileName = this.getName(this.originalName);
					// this.type = this.getFileExt(this.fileName);
					savePath += "/" + this.fileName;
					BufferedInputStream in = new BufferedInputStream(fis.openStream());
					FileOutputStream out = new FileOutputStream(new File(savePath));
					BufferedOutputStream output = new BufferedOutputStream(out);
					Streams.copy(in, output, true);
					// this.state = this.errorInfo.get("SUCCESS");
					// UE中只会处理单张上传，完成后即退出
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savePath;
	}

	/**
	 * 根据字符串创建本地目录 并按照日期建立子目录返回
	 * 
	 * @param path
	 * @return
	 */
	private String getFolder(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				return "";
			}
		}
		return path;
	}

	/**
	 * 文件类型判断
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 依据原始文件名生成新文件名
	 * 
	 * @return
	 */
	private String getName(String fileName) {
		Random random = new Random();
		return this.fileName = "" + random.nextInt(10000) + System.currentTimeMillis() + this.getFileExt(fileName);
	}
}
