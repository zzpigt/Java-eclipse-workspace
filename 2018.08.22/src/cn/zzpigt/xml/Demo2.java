package cn.zzpigt.xml;

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

import cn.zzpigt.bean.Student;

public class Demo2 {
	public static void main(String[] args) {

		
		List<Student> stuList = parse();
		for (Student s : stuList) {
			System.out.println(s);
		}
	}

	/**
	 * DOM解析 parse <-> format
	 * 
	 * DocumentBuilderFactory -> DocumentBuilder -> Document 文档对象 Document -> 根元素节点
	 * -> 所有的子元素 -> 子元素 -> ... -> Text类型节点
	 * 
	 * <?xml version="1.0" encoding="UTF-8"?> <stulist> <student id="1">
	 * <name>童</name> <age>12</age> <height>170.0</height> </student>
	 * <student id="2"> <name>tjw2</name> <age>15</age> <height>171.2</height>
	 * </student> <student id="3"> <name>tjw3</name> <age>17</age>
	 * <height>173.0</height> </student> <student id="4"> <name>tjw4</name>
	 * <age>19</age> <height>172.0</height> </student> <student id="5">
	 * <name>tjw5</name> <age>12</age> <height>178.0</height> </student> </stulist>
	 * 
	 * @return
	 */
	public static List<Student> parse() {
		List<Student> list = new ArrayList<>();
		// 首先拿到xml的docement工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// 拿到了工厂（DocumentBuilderFactory）就可以new拿到DocumentBuilder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 文档对象拿到了d,整个过程就是一个把xml文件导入到内存中的一个操作
			Document d = db.parse(new File("student.xml"));
			// 文档拿到以后，取出文档中的元素，Element
			Element root = d.getDocumentElement();
			// 所有子元素
			NodeList nodeList = root.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Student stu = new Student();
				Node stuNode = nodeList.item(i);
				stu.setID(Integer.valueOf(stuNode.getAttributes().item(0).getNodeValue()));
				NodeList childList = stuNode.getChildNodes();
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
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

}
