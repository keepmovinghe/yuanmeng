package com.keepmoving.yuanmeng.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * 工具类
 * 
 * @author JayYounger
 * 
 */
public class Utils {

	/**
	 * 200 成功
	 */
	public static final String SUCCESS = "200";

	/**
	 * 201 数据为空
	 */
	public static final String EMPTY_DATA = "201";

	/**
	 * 202 系统异常
	 */
	public static final String SYSTEM_EXCEPTION = "202";

	/**
	 * 301 用户名/密码错误
	 */
	public static final String ERR_USERNAMEORPWD = "301";

	/**
	 * 302 用户名/密码为空
	 */
	public static final String EMPTY_USERNAMEORPWD = "302";

	/**
	 * 303 用户信息不存在
	 */
	public static final String NOT_USERINFO = "303";

	/**
	 * 401 注册时用户名或邮箱不可用
	 */
	public static final String EMAIL_DISABLED = "401";

	/**
	 * 402 参数不全
	 */
	public static final String PARAMETER_NOT_COMPLETE = "402";

	/**
	 * 403 非法用户
	 */
	public static final String ILLEGAL_USER = "403";

	/**
	 * 配置文件VersionOfConfiguration.xml中version节点名称
	 */
	public static final String VERSION_NODE_NAME = "version";
	/**
	 * 配置文件VersionOfConfiguration.xml中url节点名称
	 */
	public static final String URL_NODE_NAME = "url";

	/**
	 * 配置文件VersionOfConfiguration.xml中app节点名称
	 */
	public static final String APP_NODE_NAME = "app";

	/**
	 * 配置文件Notice.xml中notice节点名称
	 */
	public static final String NOTICE_NODE_NAME = "notice";

	/**
	 * 用户角色-教师
	 */
	public static final String USER_ROLE_TEACHER = "5";

	/**
	 * 用户角色-学生
	 */
	public static final String USER_ROLE_STUDENT = "4";

	/**
	 * 组合字符串
	 * 
	 * @param status
	 * @param result
	 * @return
	 */
	public static String spliceStr(String status, String result) {
		String str = "";
		str = "{\"status\":\"" + status + "\",\"result\":" + result + "}";
		return str;
	}

	/**
	 * 组合字符串
	 * 
	 * @param status
	 * @param result
	 * @param error
	 *            错误值返回
	 * @return
	 */
	public static String spliceStr(String status, String result, String error) {
		String str = "";
		str = "{\"status\":\"" + status + "\",\"result\":" + result + ",\"error\":\"" + error + "\"}";
		return str;
	}

	/**
	 * 验证字符串是否为空或null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		boolean result = true;
		if (str != null && !"".equals(str)) {
			result = false;
		}
		return result;
	}

	/**
	 * 验证字符串是否为空或null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		boolean result = false;
		if (str != null && !"".equals(str)) {
			result = true;
		}
		return result;
	}

	/** 系统日期转换 */
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String dataStr = sdf.format(date);
		return dataStr;
	}

	/** 系统日期转换为指定格式 */
	public static String getDate(String dateStr) {
		String dataStr = "";
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
			dataStr = sdf.format(date);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataStr;
	}

	/** 比较两个日期 */
	public static int dateCompare(String dataOne, String dataTwo) {
		// Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d1 = new Date();
		Date d2 = new Date();
		try {
			d1 = sdf.parse(dataOne);
			d2 = sdf.parse(dataTwo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (d1.getTime() > d2.getTime()) {
			return 1;
		} else if (d1.getTime() < d2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * 取得APP的版本号
	 * 
	 * @param request
	 * @return 版本号
	 * @throws Exception
	 */
	public static String getAppVersionCode(HttpServletRequest request) {
		String versionCode = "";
		// documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
		DocumentBuilder dBuilder = null;
		// documentBuilder 工厂
		DocumentBuilderFactory dBuilderFactory = null;
		// element
		// Element element = null;
		try {
			// 文件名称
			String filePath = "/VersionOfConfiguration.xml";

			// 读取文件
			File file = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/") + filePath);
			// 从工厂中取得DocumentBuilderFactory
			dBuilderFactory = DocumentBuilderFactory.newInstance();
			// 得到DocumentBuilder
			dBuilder = dBuilderFactory.newDocumentBuilder();
			// 得到一个DOM并返回给document对象
			Document document = dBuilder.parse(file);
			// 得到一个element 根元素
			// element = document.getDocumentElement();
			// NodeList nodeList = document.getElementsByTagName(APP_NODE_NAME);
			// for (int i = 0; i < nodeList.getLength(); i++) {
			versionCode = document.getElementsByTagName(VERSION_NODE_NAME).item(0).getFirstChild().getNodeValue();
			// }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return versionCode;
	}

	/**
	 * 取得APP的下载地址
	 * 
	 * @param request
	 * @return 下载地址
	 * @throws Exception
	 */
	public static String getAppUrl(HttpServletRequest request) {
		String appUrl = "";
		// documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
		DocumentBuilder dBuilder = null;
		// documentBuilder 工厂
		DocumentBuilderFactory dBuilderFactory = null;
		// element
		// Element element = null;
		try {
			// 文件名称
			String filePath = "/VersionOfConfiguration.xml";

			// File file = new File(request.getContextPath()+filePath);
			// 读取文件
			File file = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/") + filePath);
			// 从工厂中取得DocumentBuilderFactory
			dBuilderFactory = DocumentBuilderFactory.newInstance();
			// 得到DocumentBuilder
			dBuilder = dBuilderFactory.newDocumentBuilder();
			// 得到一个DOM并返回给document对象
			Document document = dBuilder.parse(file);
			// 得到一个element 根元素
			// element = document.getDocumentElement();
			// NodeList nodeList = document.getElementsByTagName(APP_NODE_NAME);
			// for (int i = 0; i < nodeList.getLength(); i++) {
			appUrl = document.getElementsByTagName(URL_NODE_NAME).item(0).getFirstChild().getNodeValue();
			// }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return appUrl;
	}

	/**
	 * 获取通知信息
	 * 
	 * @param request
	 * @return
	 */
	public static String getNotice(HttpServletRequest request) {
		String resutl = "";
		// documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
		DocumentBuilder dBuilder = null;
		// documentBuilder 工厂
		DocumentBuilderFactory dBuilderFactory = null;
		try {
			// 文件名称
			String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/") + "/Notice.xml";
			// File file = new File(request.getContextPath()+filePath);
			// 读取文件
			File file = new File(filePath);
			// 从工厂中取得DocumentBuilderFactory
			dBuilderFactory = DocumentBuilderFactory.newInstance();
			// 得到DocumentBuilder
			dBuilder = dBuilderFactory.newDocumentBuilder();
			// 得到一个DOM并返回给document对象
			Document document = dBuilder.parse(file);
			// 得到一个element 根元素
			// element = document.getDocumentElement();
			// NodeList nodeList = document.getElementsByTagName(APP_NODE_NAME);
			resutl = document.getElementsByTagName(NOTICE_NODE_NAME).item(0).getFirstChild().getNodeValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return resutl;
	}

	/**
	 * 向xml中写入内容
	 * 
	 * @param request
	 * @param content
	 *            要写入的内容
	 */
	public static void saveContentToXml(HttpServletRequest request, String value) {
		Document document = null;
		try {
			// 文件路径
			String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/") + "/Notice.xml";
			// 创建file对象
			File file = new File(filePath);
			// 通过document工厂创建Dodument对象
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
			// 创建一个Element 取得根元素
			Element root = document.getDocumentElement();
			// 取得修改的的节点
			root.getElementsByTagName(NOTICE_NODE_NAME).item(0).setTextContent(value);
			// 调用输出方法
			output(root, filePath);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写回XML文件，保存修改或打印到控制台
	 * 
	 * @param node
	 *            内容节点
	 * @param filename
	 *            文件名
	 */
	public static void output(Node node, String filename) {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer();
			// 设置各种输出属性
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");
			DOMSource source = new DOMSource();
			// 将待转换输出节点赋值给DOM源模型的持有者(holder)
			source.setNode(node);
			StreamResult result = new StreamResult();
			if (filename == null) {
				// 设置标准输出流为transformer的底层输出目标
				result.setOutputStream(System.out);
			} else {
				result.setOutputStream(new FileOutputStream(filename));
			}
			// 执行转换从源模型到控制台输出流
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数字转换对应字母
	 * 
	 * @param num
	 * @return
	 */
	public static String getNumToLetter(int num) {
		String result = "";
		try {
			switch (num) {
			case 1: {
				result = "A";
				break;
			}
			case 2: {
				result = "B";
				break;
			}
			case 3: {
				result = "C";
				break;
			}
			case 4: {
				result = "D";
				break;
			}
			case 5: {
				result = "E";
				break;
			}
			case 6: {
				result = "F";
				break;
			}
			case 7: {
				result = "G";
				break;
			}
			case 8: {
				result = "H";
				break;
			}
			case 9: {
				result = "I";
				break;
			}
			default:
				result = "";
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 将数字星期几转换为对应的大写汉字。（例如：1-一，2-二，3-三...）
	 * 
	 * @param number
	 * @return
	 */
	public static String getNumToUpper(Character number) {
		String result = "";
		switch (number) {
		case '1':
			result = "一";
			break;
		case '2':
			result = "二";
			break;
		case '3':
			result = "三";
			break;
		case '4':
			result = "四";
			break;
		case '5':
			result = "五";
			break;
		case '6':
			result = "六";
			break;
		case '7':
			result = "七";
			break;

		default:
			break;
		}
		return result;
	}

	/**
	 * 获取16进制颜色代码
	 * 
	 * @return
	 */
	public static String getColor() {
		StringBuffer color = new StringBuffer("#");
		String colors[] = { "fdfecc", "cdffff", "ffccce", "ffff99", "cdffcc", "ccccff", "fecc9a", "cccccc", "ff6566",
				"ffd2d2", "ffd2ef", "d9d2ff", "d2ecff", "d2fff3", "d2ffd2", "9acbff", "66cacd", "fdf382", "fbd9b4",
				"68f1fd", "b5fd68", "fdb9e7", "708efe", "cdf8e9", "22fcb1", "f1fdc7", "f5f333", "f8df88", "f69dd8",
				"f9d8ee", "f9dae5", "3efbfd", "f8b2ad" };
		// 红色块
		// String red = "FF";
		// 绿色块
		// String green = "FF";
		// 蓝色块
		// String blue = "FF";
		// 初始化随机对象
		Random random = new Random();
		// 随机生成红色块代码
		// red = colors[random.nextInt(colors.length-1)].toUpperCase();
		// 随机生成绿色块代码
		// green = colors[random.nextInt(colors.length-1)].toUpperCase();
		// 随机生成蓝色块代码
		// blue = colors[random.nextInt(colors.length-1)].toUpperCase();

		// 组合颜色代码
		// color.append(red).append(green).append(blue);
		color.append(colors[random.nextInt(colors.length)].toUpperCase());
		return color.toString();
	}

	/**
	 * 输出结果JSON客串
	 * 
	 * @param request
	 * @param response
	 * @param status
	 *            状态
	 * @param result
	 *            结果
	 */
	public static void printWriter(HttpServletRequest request, HttpServletResponse response, String status,
			String result) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			result = spliceStr(status, result);
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
