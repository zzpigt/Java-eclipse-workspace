package cn.zzpigt.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.dao.BaseDao;

/**
 * 这个类非常依赖javaBean包的类，类名要和数据库中的一致，类中的属性要和表中字段一样
 * get和set方法要规范
 * 表中的id必须是key键
 * @author admin
 *
 * @param <T>
 */

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<?> clazz;

	public BaseDaoImpl() {
		ParameterizedType gs = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<?>) gs.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T t, Connection conn) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ");
		Class<?> ct = t.getClass();
		String tableName = ct.getSimpleName();
		sb.append(tableName.toLowerCase());
		Field[] df = ct.getDeclaredFields();

		sb.append(" (");
		for (int i = 0; i < df.length; i++) {
			Field field = df[i];
			sb.append(field.getName());
			if (i < df.length - 1) {
				sb.append(",");
			}
		}
		sb.append(") values (");

		// 拼接占位符？
		for (int i = 0; i < df.length; i++) {
			sb.append("?");
			if (i < df.length - 1) {
				sb.append(",");
			}
		}
		sb.append(")");

		// 预编译
		PreparedStatement ps = conn.prepareStatement(sb.toString());

		// 替换占位符
		for (int i = 0; i < df.length; i++) {
			Field field = df[i];
			// 拿到get方法的方法名
			String getterName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);

			
			try {
				Method getter = ct.getDeclaredMethod(getterName);
				Object value = getter.invoke(t);
				ps.setObject(i + 1, value);
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

		System.out.println(sb.toString());
		ps.executeUpdate();
	}

	@Override
	public void delete(int id, Connection conn) throws SQLException {
		// delete from 表名 where id = ?\
		String sql = "delete from " + clazz.getSimpleName().toLowerCase() + " where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	@Override
	public void update(T t, Connection conn) throws SQLException {
		// update 表名 set name1 = ? , name2 = ? where id = ?
		StringBuilder sb = new StringBuilder("update ");

		Class<?> ct = t.getClass();
		// 表名
		sb.append(ct.getSimpleName().toLowerCase() + " set ");
		// set
		Field[] fs = ct.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			if("id".equals(f.getName())) {
				continue;
			}
			sb.append(f.getName() + " = ?");
			if (i < fs.length - 1) {
				sb.append(" ,");
			}
		}

		// where
		sb.append(" where id = ?");
		System.out.println(sb.toString());
		
		
		// 预编译
		PreparedStatement ps = conn.prepareStatement(sb.toString());

		// where 之前的占位符
		int index = 1;//这个是占位符的索引，避开id的干扰，
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			try {
				if("id".equals(f.getName())) {
					Method getter = ct.getDeclaredMethod("getId");
					Object value = getter.invoke(t);
					ps.setObject(fs.length, value);
					continue;
				}
				// getter
				String getterName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
				Method getter = ct.getDeclaredMethod(getterName);
				Object value = getter.invoke(t);
				ps.setObject(index++, value);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		
		ps.executeUpdate();

	}

	@Override
	public T queryById(int id, Connection conn) throws SQLException {
		// select * from tableName where id = ?
		String sql = "select * from " + clazz.getSimpleName().toLowerCase() + " where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		T nt = null;
		try {
			nt = (T) clazz.getDeclaredConstructor().newInstance();
			if(rs.next()) {
				Field[] fs = clazz.getDeclaredFields();
				for (int i = 0; i < fs.length; i++) {
					Field f = fs[i];
					// set各个属性的值
					String setterName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					Object value = rs.getObject(f.getName());
					if(value instanceof Timestamp) {
						value = String.valueOf(value);
					}
					/*//不希望子类也可以的话,还可以这样
					if(value.getClass() == Timestamp.class) {
						value = String.valueOf(value);
					}*/
					
					Method setter = clazz.getDeclaredMethod(setterName, value.getClass());
					setter.invoke(nt, value);
				}
			}
//				System.out.println(rs.getObject(3));

		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}

		return nt;
	}

	@Override
	public List<T> queryAll(Connection conn) throws SQLException {
		List<T> list = new ArrayList<>();
		// selece * from tableName
		String sql = "select * from "+clazz.getSimpleName().toLowerCase();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		while(rs.next()) {
//			rs.getObject(columnLabel, type)
			try {
				T t = (T) clazz.newInstance();
				Field[] fs = clazz.getDeclaredFields();
				for (int i = 0; i < fs.length; i++) {
					Field f = fs[i];
					String setterName = "set"+f.getName().substring(0, 1).toUpperCase()+f.getName().substring(1);
					Object value = rs.getObject(f.getName());
					if(value instanceof Timestamp) {
						value = String.valueOf(value);
					}
					Method setter = clazz.getDeclaredMethod(setterName, value.getClass());
					setter.invoke(t, value);
				}
				list.add(t);
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int getCount(Connection conn) throws SQLException {
		// select count(*) from users
		String sql = "select count(*) from " + clazz.getSimpleName().toLowerCase();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}

		return count;
	}

}
