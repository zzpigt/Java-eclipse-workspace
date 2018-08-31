package cn.zzpigt.factory;

public class ShapeFactory {
	
	public Shape getShape(String classname) {
		Shape s = null;
		try {
			Class<?> c = Class.forName(classname);
			s = (Shape) c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
}
