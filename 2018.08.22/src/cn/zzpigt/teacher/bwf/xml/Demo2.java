package com.bwf.xml;

import java.beans.FeatureDescriptor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.bwf.bean.Student;

public class Demo2 {

	public static void main(String[] args) {
		List<Student> list = parse();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	/**
	 * DOM解析     parse <-> format
	 * 
	 * DocumentBuilderFactory -> DocumentBuilder -> Document
	 * 文档对象 Document -> 根元素节点 -> 所有的子元素 -> 子元素  -> ... -> Text类型节点
	 * 
	 * @return
	 */
	public static List<Student> parse(){
		
		List<Student> list = new ArrayList<>();
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 文档对象 Document
			Document document = db.parse(new File("stu.xml"));
			// 根元素节点
			Element root = document.getDocumentElement();
			// 所有的子元素
			NodeList nodeList = root.getChildNodes();
			for(int i = 0; i < nodeList.getLength(); i ++) {
				Student s = new Student();
				// 子元素 student节点
				Node stuNode = nodeList.item(i);
				s.setId(Integer.parseInt(stuNode.getAttributes().item(0).getNodeValue()));
		
				// 拿出所有的子节点  - 属性
				NodeList fieldlist = stuNode.getChildNodes();
				for(int j = 0; j < fieldlist.getLength(); j ++) {
					// 子元素节点 name age height
					Node fieldNode = fieldlist.item(j);
					switch (fieldNode.getNodeName()) {
					case "name":
						s.setName(fieldNode.getTextContent());
						break;
					case "age":
						s.setAge(Integer.parseInt(fieldNode.getTextContent()));
						break;
					case "height":
						s.setHeight(Double.parseDouble(fieldNode.getTextContent()));
						break;

					default:
						break;
					}
				
				}
				
				list.add(s);
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
