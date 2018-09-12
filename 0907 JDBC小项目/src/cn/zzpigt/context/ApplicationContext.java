package cn.zzpigt.context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;

public class ApplicationContext {
	/**
	 * 		1. ������һ��user������xml�ļ���
 			��java�����зֱ��ȡ2����ͬ��user����, ����ӡ���
 
 
			2. ��xml�ļ�������һ����¼����, ����ֵ����
 			��java�����л�ȡ�����¼����, ����ӡ���(���ܻ������, ���Ž��һ��)
	 */

	private static Map<String, Object> beanMap = new HashMap<>();

	public static void main(String[] args) {
		init();
		Users u1 = (Users) getBean("users1");
		Users u2 = (Users) getBean("users2");
		Record r1 = (Record) getBean("record1");
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(r1);
	}

	public static void init() {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(ApplicationContext.class.getClassLoader().getSystemResourceAsStream("applicationContext.xml"));
			Element root = document.getRootElement();
			//����xml���洢���еĶ���
			parseXml(root);
			//�ٽ���һ�飬��bean�е�Ԫ��set��������
			di(root);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����xml�������е���Ķ���д��map
	 */
	private static void parseXml(Element root) {
		List<Element> list = root.elements();
		for (Element e : list) {
			String name = e.attributeValue("name");
			String className = e.attributeValue("class");
			try {
				Class<?> clazz = Class.forName(className);
				Object object = clazz.newInstance();
				beanMap.put(name, object);
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}  catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			}

		}
	}
	
	/**
	 * ע������
	 * @param root
	 */
	private static void di(Element root) {
		List<Element> list = root.elements();
		for (Element e : list) {
			List<Element> properties = e.elements();
			String bean = e.attributeValue("name");
			Object object = beanMap.get(bean);
			for (Element p : properties) {
				String pName = p.attributeValue("name");
				String pValue = p.attributeValue("value");
				// ��property��ֵ�ŵ�������
				Field field;
				try {
					field = object.getClass().getDeclaredField(pName);
					setProperty(object, field, pValue);
				} catch (NoSuchFieldException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
			}
			
		}
	}

	private static void setProperty(Object object, Field field, String pValue) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = object.getClass();
		// set����
		String setterName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
		Object value = null;
		switch (field.getType().getSimpleName()) {
		case "Integer":
			value = Integer.parseInt(pValue);
			break;
		case "Double":
			value = Double.parseDouble(pValue);
			break;
		case "String":
			value = pValue;
			break;
			
		default:
			value = beanMap.get(pValue);
			break;
		}
		
		Method setter = clazz.getDeclaredMethod(setterName, field.getType());
		setter.invoke(object, value);
	}

	public static Object getBean(String name) {
		return beanMap.get(name);
	}

}
