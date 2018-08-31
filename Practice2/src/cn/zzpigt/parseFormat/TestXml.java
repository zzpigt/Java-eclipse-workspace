package cn.zzpigt.parseFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestXml {
	public static void main(String[] args) {
//		List<Student> list = new ArrayList<>();
//
//		list.add(new Student(1, "刘备", 23, 160.6));
//		list.add(new Student(2, "张飞", 20, 179.4));
//		list.add(new Student(3, "关羽", 22, 200.2));
//		list.add(new Student(4, "赵云", 23, 189.7));
//		
//		saveXml(list);
		
//		List<Student> list1 = parseDom();
		List<Student> list2 = parseSax();
		for (Student s : list2) {
			System.out.println(s);
		}
	}

	//format
	private static void saveXml(List<Student> list) {
		StringBuilder sb = new StringBuilder();
		Writer w = null;
		
		sb.append("<?xml version=\"1.0\" enconding=\"UTF-8\"?>");
		sb.append("<stulist>");
		for (Student s : list) {
			sb.append(getStr(s));
		}
		sb.append("</stulist>");
		
		try {
			w = new FileWriter("student.xml");
			w.write(new String(sb.toString().getBytes("UTF-8")));
			w.flush();
			System.out.println("生成XMl成功！！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private static String getStr(Student s) {
		StringBuilder sb = new StringBuilder();
		sb.append("<student id=\"").append(s.getID()).append("\">");
		sb.append("<name>").append(s.getName()).append("</name>");
		sb.append("<age>").append(s.getAge()).append("</age>");
		sb.append("<height>").append(s.getHeight()).append("</height>");
		sb.append("</student>");
		
		return sb.toString();
	}
	
	//parse
	
	
	/**
	 * DOM的方式解析，这种解析是整个读进内存，然后解析，可以随机进行读取
	 * @return
	 */
	private static List<Student> parseDom(){
		List<Student> list = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(new File("student.xml"));
			//拿到了文档后，获得里面的元素Element
			Element element = document.getDocumentElement();
			//再拿到里面的属性节点
			NodeList nodeList = element.getChildNodes();
			for(int i=0;i<nodeList.getLength();i++) {
				Student stu = new Student();
				String stuId = nodeList.item(i).getAttributes().item(0).getNodeValue();
				stu.setID(Integer.parseInt(stuId));
				NodeList childList = nodeList.item(i).getChildNodes();
				for(int j=0;j<childList.getLength();j++) {
					Node item = childList.item(j);
					switch (item.getNodeName()) {
					case "name":
						stu.setName(String.valueOf(item.getTextContent()));
						break;
					case "age":
						stu.setAge(Integer.parseInt(item.getTextContent()));
						break;
					case "height":
						stu.setHeight(Double.parseDouble(item.getTextContent()));
						break;
					default:
						break;
					}
				}
				list.add(stu);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	//SAX解析
	private static List<Student> parseSax(){
		List<Student> list = new ArrayList<>();
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			MyHandler mh = new MyHandler();
			sp.parse(new File("student.xml"), mh);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	static class MyHandler extends DefaultHandler{
		private List<Student> list = null;
		private Student stu = null;
		private String qName;
		
		
		@Override
		public void startDocument() throws SAXException {
			list = new ArrayList<>();
		}

		@Override
		public void endDocument() throws SAXException {
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if("student".equals(qName)) {
				stu = new Student();
				String Id = attributes.getValue(0);
				stu.setID(Integer.parseInt(Id));
			}
			this.qName = qName;
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if("student".equals(qName)) {
				list.add(stu);
				stu = null;
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			String str = new String(ch,start,length);
			switch (qName) {
			case "name":
				stu.setName(str);
				break;
			case "age":
				stu.setAge(Integer.parseInt(str));
				break;
			case "height":
				stu.setHeight(Double.parseDouble(str));
				break;
			default:
				break;
			}
			qName = null;
			
		}

		
		
		
	}
	
	
	
}
