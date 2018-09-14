package com.bwf.context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bwf.bean.Record;
import com.bwf.bean.User;

public class ApplicationContext {
	
	private static Map<String, Object> beanMap = new HashMap<>();
	

	public static void main(String[] args) {
		init();
		
		// 获取user对象
		User u = (User) getBean("user");
		System.out.println(u);
		
		User u2 = (User) getBean("user2");
		System.out.println(u2);
		
		// 获取record对象
		Record r = (Record) getBean("record");
		System.out.println(r);
		
	}
	
	
	public static void init() {
		// 读取XML
		SAXReader reader = new SAXReader();
        try {
			Document document = reader.read(ApplicationContext.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
			Element root = document.getRootElement();
			parseXML(root);
			di(root);
        } catch (DocumentException e) {
			e.printStackTrace();
		}
        
	}
	
	/**
	 * 解析XML
	 */
	private static void parseXML(Element root) {
		List<Element> list = root.elements();
		for (Element element : list) {
			String name = element.attributeValue("name");
			String classname = element.attributeValue("class");
			
			try {
				Class<?> clazz = Class.forName(classname);
				Object object = clazz.newInstance();
				
				beanMap.put(name, object);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}  catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		
		}
	}
	/**
	 * 注入依赖
	 */
	private static void di(Element root) {
		List<Element> list = root.elements();
		
		for (Element element : list) {
			String name = element.attributeValue("name");
			Object object = beanMap.get(name);
			
			// 设置依赖
			// 拿到所有Property节点
			List<Element> propertys = element.elements();
			for (Element property : propertys) {
				String pName = property.attributeValue("name");
				String pValue = property.attributeValue("value");
				
				Field field;
				try {
					field = object.getClass().getDeclaredField(pName);
					// uname -> setUname
					setProperty(object, field, pValue);
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}
		

		
		
	}
	
	
	
	private static void setProperty(Object object, Field field, String pValue) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		Class clazz = object.getClass();
		String setterName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
		Method setter = clazz.getDeclaredMethod(setterName, field.getType());
		
		Object value = null;
		
		switch (field.getType().getSimpleName()) {
		case "Integer":
			value = Integer.parseInt(pValue);
			break;
			
		case "Double":
			value = Double.parseDouble(pValue);
			break;
			
		case "Date":
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			value = sdf.parse(pValue);
			break;
			
		case "String":
			value = pValue;
			break;
			
		default:
			value = beanMap.get(pValue);
			break;
		}
		
		
		setter.invoke(object, value);		
	}


	public static Object getBean(String name) {
		return beanMap.get(name);
	}
	
}
