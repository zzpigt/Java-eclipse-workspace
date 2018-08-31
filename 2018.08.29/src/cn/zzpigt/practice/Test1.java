package cn.zzpigt.practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.zzpigt.bean.Student;

public class Test1 {
	
	public static void main(String[] args) {
		
		//��ϰxml,xml��Ϊdom��sax���֣�dom�Ļ���ȫ�������ڴ���ٴ������ڴ��ռ�ýϴ��ʺ��ڴ��Ļ���
		//sax�Ļ����ͱȽ��ʺ����ֻ������ڴ�С�Ļ��ӣ��Ƕ�һ�㴦��һ��
		//�����ִ������õ�����ģʽ��֮��ҲҪ��ϰ��ϰ��ʦ������һЩ���ģʽ
		
		//��ϰ�Ļ����ȴ���һ��xml���ı����������Ūһ��Student��,studentbuilderģʽ
		
//		List<Student> list = new ArrayList<>();
//		
//		list.add(new Student.StudentBuilder("tong").age(12).marriage(false).builder());
//		list.add(new Student.StudentBuilder("jin").height(123.0).marriage(true).builder());
//		list.add(new Student.StudentBuilder("wen").age(34).height(170.2).builder());
		
		//дһ��xml�ı�
//		saveXml(list);
		
		//DOM parse
		File file = new File("Student.xml");
		
		List<Student> xmlList = parseXml(file);
		
		
		
		
		
		
	}

	/**
	 * DOM����XML�ļ�
	 * @param file
	 * @return 
	 */
	private static List<Student> parseXml(File file) {
		
		List<Student> list = new ArrayList<>();
		
		//�õ�xml������Ȼ���õ�document������element�����ĵ��������е�Ԫ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			Element element = document.getDocumentElement();
				
			
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return list;
		
	}

	private static void saveXml(List<Student> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<stulist>");
		for (Student student : list) {
			sb.append("<student>");
			sb.append(getStuStr(student));
			sb.append("</student>");
		}
		sb.append("</stulist>");
		
		Writer w = null;
		
		try {
			w = new FileWriter("student.xml");
			w.write(sb.toString());
			w.flush();
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

	private static String getStuStr(Student student) {
		StringBuilder sb = new StringBuilder();
		if(student.getName() != null) {
			sb.append("<name>").append(student.getName()).append("</name>");
		}
		if(student.getAge() != null) {
			sb.append("<age>").append(student.getAge()).append("</age>");
		}
		
		if(student.getHeight() != null) {
			sb.append("<height>").append(student.getHeight()).append("</height>");
		}
		
		if(student.isMarriage() != null) {
			sb.append("<marriage>").append(student.isMarriage()).append("</marriage>");
		}
		
		return sb.toString();
	}

}
