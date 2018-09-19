package com.bwf.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bwf.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class<?> gclass;

	public BaseDaoImpl() {
		// 构造获取类对象
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();

		gclass = (Class<?>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T t, Connection conn) throws SQLException {
		System.out.println(t.toString());
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ");
		Class<?> ct = t.getClass();
		String tableName = ct.getSimpleName();
		sb.append(tableName.toLowerCase());
		Field[] df = ct.getDeclaredFields();

		sb.append(" (");
		for (int i = 0; i < df.length; i++) {
			Field field = df[i];
			if (!field.getName().equals("serialVersionUID")) {
				sb.append(field.getName());

				if (i < df.length - 1) {
					sb.append(",");
				}
			}
		}
		sb.append(") values (");

		// 拼接占位符？
		for (int i = 0; i < df.length; i++) {

			if (!df[i].getName().equals("serialVersionUID")) {
				sb.append("?");

				if (i < df.length - 1) {
					sb.append(",");
				}
			}

		}
		sb.append(")");

		// 预编译
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		// 替换占位符
		int index = 1;
		for (int i = 0; i < df.length; i++) {
			Field field = df[i];
			// 拿到get方法的方法名

			if (!field.getName().equals("serialVersionUID")) {

				String getterName = "get" + field.getName().substring(0, 1).toUpperCase()
						+ field.getName().substring(1);

				try {
					Method getter = ct.getDeclaredMethod(getterName);
					Object value = getter.invoke(t);
					ps.setObject(index++, value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println(sb.toString());
		ps.executeUpdate();
	}

	@Override
	public void delete(int id, Connection conn) throws SQLException {

		String tableName = gclass.getSimpleName();
		String sql = "delete from " + tableName + " where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		System.out.println(ps);
		int executeUpdate = ps.executeUpdate();

	}

	@Override
	public void update(T t, Connection conn) throws SQLException {
		// 获得类对象
		Class<?> class1 = t.getClass();
		String tableName = class1.getSimpleName();
		String getName = null;
		// 获得成员属性
		Field[] df = class1.getDeclaredFields();
		// 拼接sql语句
		// update User set id=?,uname=?,upwd=?,money=? where id=?
		String sql = "update " + tableName + " set ";
		for (int i = 0; i < df.length; i++) {
			Field field = df[i];
			getName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			//跳过成员属性:序列化
			if (getName.equals("getSerialVersionUID")) {
				continue;
			}
			sql += field.getName() + "=?";
			if (i < df.length - 1) {
				sql += ",";
			} else {
				sql += " where id=?";
			}
		}
		// update User set id=?,uname=?,upwd=?,money=? where id=?
		// 填充占位符
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		// 存放条件表达式 即id,数组下标第一
		String where;
		int index = 1;
		for (int i = 0; i < df.length; i++) {
			Field field = df[i];
			getName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			// 存放条件表达式 即id,数组下标第0位,填充第length+1位占位符
			try {
				if (i == 1) {
					where = getName;
					// 反射调用getId方法并把值拼接到最后一位
					ps.setObject(df.length, class1.getDeclaredMethod(where).invoke(t));
				}
				if (!getName.equals("getSerialVersionUID")) {
					Method method = class1.getDeclaredMethod(getName);
					ps.setObject(index++, method.invoke(t));
				}

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		int executeUpdate = ps.executeUpdate();
		System.out.println(sql);
	}

	@Override
	public T querybyid(int id, Connection conn) throws SQLException {

		String sql = "select *from " + gclass.getSimpleName() + " where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, id);
		ResultSet rs = ps.executeQuery();
		// 实例化对象
		T t;
		try {
			t = (T) gclass.newInstance();
			if (rs.next()) {
				Field[] df = gclass.getDeclaredFields();
				for (int i = 0; i < df.length; i++) {
					Field f = df[i];
					// 拿到属性的值
					if(f.getName().equals("serialVersionUID")) {
						continue;
					}
					Object value = rs.getObject(f.getName());
					// 拿到setter方法
					String setter = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					// 获得对象的属性
					Method method = gclass.getMethod(setter, value.getClass());
					method.invoke(t, value);

				}

			}

			return t;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<T> queryAll(Connection conn) throws SQLException {
		List<T> list = new ArrayList<>();
		String sql = "select *from " + gclass.getSimpleName();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			T t;
			try {
				t = (T) gclass.newInstance();
				Field[] df = gclass.getDeclaredFields();
				for (int i = 0; i < df.length; i++) {
					Field f = df[i];
					if(f.getName().equals("serialVersionUID")) {
						continue;
					}
					Object value = rs.getObject(f.getName());

					if (value.getClass().getSimpleName().equals("Timestamp")) {

						value = String.valueOf(value);

					}

					String setter = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);

					Method method = gclass.getMethod(setter, value.getClass());
					method.invoke(t, value);

				}

				list.add(t);

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;
	}

	@Override
	public int queryCount(Connection conn) throws SQLException {
		String tableName = gclass.getSimpleName();
		String sql = "select count(*) from " + tableName;
		Statement cs = conn.createStatement();
		System.out.println(sql);
		ResultSet eq = cs.executeQuery(sql);
		// System.out.println(eq.toString());
		if (eq.next()) {

			return eq.getInt(1);
		}

		return 0;
	}

}
