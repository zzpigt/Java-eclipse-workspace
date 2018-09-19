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
		// ��ʼ��,��jar������xml�ļ�
		SAXReader reader = new SAXReader();
		Document dc;
		try {
			dc = reader.read(ApplicationContext.class.getClassLoader().getResourceAsStream("applicationcontext.xml"));
			// ��ø��ڵ�
			Element re = dc.getRootElement();
			// ��һ�����xml��bean������ʵ��������map,���Ʒ�ת
			paresxml(re);
			// System.out.println(beanmap);
			// �ڶ������map,��xml������ֵ��ֵ��bean�ĳ�Ա����,
			// ��ĳ������������һ����,��ͨ��map�ٴ�ʵ��������������,����ע��
			di(re);

		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void di(Element re) {
		// TODO Auto-generated method stub
		// �ڶ������xml�ļ�,ע������
		//bean�ڵ�
		List<Element> list = re.elements();
		try {
			//����bean�ڵ�
			for (Element element : list) {
				// String name=element.getName();
				
				String name = element.attributeValue("name");
				//ͨ��bean��name����ֵ,���ݵ�һ�����xml�ļ���õ�map�ҵ���Ӧ�Ķ���
				Object object = beanmap.get(name);
				// System.out.println(beanmap);
				//�õ�������property�ڵ�
				List<Element> propertys = element.elements();
				for (Element element2 : propertys) {
					//�õ�����ĳ�Ա������name(�������Ľӿڶ�����)
					String p_name = element2.attributeValue("name");
					//System.out.println(p_name);
					//�õ�����ĳ�Ա������name(�������Ľӿ�����)
					String p_value = element2.attributeValue("value");
					//System.out.println(p_value);
					Field df = object.getClass().getDeclaredField(p_name);
					//ͨ������,����set������ñ���������Ķ���
					//usʵ�����Ķ���,us�ĳ�Ա����,us�ĳ�Ա������name(�������Ľӿ�����)
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
		// ��һ�����,�����е�beansʵ����������map
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
				// ��� �ӿ�����ʵ�����Ķ���,���нӿ�Ҫʵ��������ֱ�ӵ���getElement����,�����������ɷ��ض���
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
		//��װset������
		String setter = "set" + df.getName().substring(0, 1).toUpperCase() + df.getName().substring(1);
		// System.out.println(setter);
		//������set����,����Ϊset�������ͳ�Ա��������
		Method dm = class1.getDeclaredMethod(setter, df.getType());
		Object value = null;
		//��Ϊxml��ȡ����������ֻ����string,
		//���ǳ�Ա���Բ�һ��Ϊstring����,���Է������set��������string�����ᱨ��
		//���Ը���df��Ա���Ե��������ͽ���ǿ��ת������
		switch (df.getType().getSimpleName()) {
		case "Double":
			value = Double.parseDouble(p_value);
			break;
		case "Integer":
			value = Integer.parseInt(p_value);
			break;
		// ��Ա����dateΪstring����
		// case"Date":
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// value= sdf.parse(p_value);
		// break;
		case "String":
			value = p_value;
			break;
		default:
			//���ǻ����������ͺ�string,��ôһ���Ǳ�������ĳ����
			//��ʱ���ݳ�Ա���ԵĽӿ�����mapȡ����Ӧ��ʵ�����÷��丳ֵ����Ա����
			value = beanmap.get(p_value);
			// System.err.println(p_value);
			break;
		}
		// System.out.println(dm+" "+value);
		//����set������ֵ
		dm.invoke(object, value);
	}

	public static Object getBean(String name) {
		return beanmap.get(name);
	}

}
