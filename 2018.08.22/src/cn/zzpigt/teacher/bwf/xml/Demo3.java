package cn.zzpigt.teacher.bwf.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import cn.zzpigt.bean.Student;

public class Demo3 {

	public static void main(String[] args) {
		List<Student> list = parse();
		
		for (Student s : list) {
			System.out.println(s);
		}
	}

	/**
	 * SAX解析
	 * 用事件流的方式一点点分析
	 */
	public static List<Student> parse(){
		List<Student> list = new ArrayList<>();
 		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser parser = spf.newSAXParser();
			
			parser.parse(new FileInputStream("student.xml"), new MyHandler());
			list = MyHandler.myHandlerlist;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	static class MyHandler extends DefaultHandler {
		public static List<Student> myHandlerlist = new ArrayList<>();
		public static Student stu = new Student();
		public String characterStr = null;


		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if("student".equals(qName)) {
				if (attributes.getValue(0) != null) {
					stu.setID(Integer.parseInt(attributes.getValue(0)));
				}
			}
			
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			this.characterStr = new String(ch,start,length);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			switch (qName) {
			
			case "name":
				stu.setName(this.characterStr);
				this.characterStr = null;
				break;
				
			case "age":
				stu.setAge(Integer.parseInt(this.characterStr));
				this.characterStr = null;
				break;
			case "height":
				stu.setHeight(Double.parseDouble(this.characterStr));
				this.characterStr = null;
				break;
			case "student":
				myHandlerlist.add(stu);
				stu = new Student();
				break;
			default:
				break;
			}
		}

	}

}
