package com.bwf.context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ApplicationContext {

	private static Map<String, Object> beanmap = new HashMap<>();


	public static void init() {
		// 初始化,用jar包加载xml文件
		SAXReader reader = new SAXReader();
		Document dc;
		try {
			dc = reader.read(ApplicationContext.class.getClassLoader().getResourceAsStream("applicationcontext.xml"));
			// 获得根节点
			Element re = dc.getRootElement();
			// 第一遍遍历xml将bean的类名实例化存入map,控制反转
			paresxml(re);
			// System.out.println(beanmap);
			// 第二遍遍历map,把xml的属性值赋值给bean的成员属性,
			// 若某个类依赖于另一个类,则通过map再次实例化被依赖的类,依赖注入
			di(re);

		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void di(Element re) {
		// TODO Auto-generated method stub
		// 第二遍遍历xml文件,注入依赖
		//bean节点
		List<Element> list = re.elements();
		try {
			//遍历bean节点
			for (Element element : list) {
				// String name=element.getName();
				
				String name = element.attributeValue("name");
				//通过bean的name属性值,根据第一遍加载xml文件获得的map找到对应的对象
				Object object = beanmap.get(name);
				// System.out.println(beanmap);
				//拿到并遍历property节点
				List<Element> propertys = element.elements();
				for (Element element2 : propertys) {
					//拿到对象的成员属性名name(被依赖的接口对象名)
					String p_name = element2.attributeValue("name");
					//System.out.println(p_name);
					//拿到对象的成员属性名name(被依赖的接口类名)
					String p_value = element2.attributeValue("value");
					//System.out.println(p_value);
					Field df = object.getClass().getDeclaredField(p_name);
					//通过反射,调用set方法获得被依赖的类的对象
					//us实例化的对象,us的成员属性,us的成员属性名name(被依赖的接口类名)
					getElement(object, df, p_value);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void paresxml(Element re) {
		// 第一遍遍历,把所有的beans实例化并放入map
		// TODO Auto-generated method stub
		try {
			List<Element> list = re.elements();
			for (Element element : list) {
				// String name=element.getName();
				String name = element.attributeValue("name");
				String classname = element.attributeValue("class");
				// System.out.println(classname);
				Class<?> forName = Class.forName(classname);
				Object object = forName.newInstance();
				// 存放 接口名和实例化的对象,若有接口要实例化对象直接调用getElement方法,传入类名即可返回对象
				beanmap.put(name, object);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private static void getElement(Object object, Field df, String p_value)
			throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ParseException {
		Class<?> class1 = object.getClass();
		//组装set方法名
		String setter = "set" + df.getName().substring(0, 1).toUpperCase() + df.getName().substring(1);
		// System.out.println(setter);
		//反射获得set方法,参数为set方法名和成员属性类型
		Method dm = class1.getDeclaredMethod(setter, df.getType());
		Object value = null;
		//因为xml读取的数据类型只能是string,
		//但是成员属性不一定为string类型,所以反射调用set方法传非string参数会报错
		//所以根据df成员属性的属性类型进行强制转换类型
		switch (df.getType().getSimpleName()) {
		case "Double":
			value = Double.parseDouble(p_value);
			break;
		case "Integer":
			value = Integer.parseInt(p_value);
			break;
		// 成员属性date为string类型
		// case"Date":
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// value= sdf.parse(p_value);
		// break;
		case "String":
			value = p_value;
			break;
		default:
			//若非基本数据类型和string,那么一定是被依赖的某个类
			//这时根据成员属性的接口名从map取出相应的实例调用反射赋值给成员属性
			value = beanmap.get(p_value);
			// System.err.println(p_value);
			break;
		}
		// System.out.println(dm+" "+value);
		//调用set方法赋值
		dm.invoke(object, value);
	}

	public static Object getBean(String name) {
		return beanmap.get(name);
	}

}
