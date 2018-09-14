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


/**
 * 
 * 1. javaBean类名必须和表名一致
 * 2. javaBean属性名必须和列名一致
 * 3. 主键必须叫id
 * 4. 必须用包装类型 int -> Integer
 * 5. 必须有公开的无参构造
 * 6. get set方法必须规范
 */

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class<?> gClass;	// T的泛型类型
	
	public BaseDaoImpl() {
		// 获取泛型类型 - T
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		gClass = (Class<?>) pt.getActualTypeArguments()[0];
	}
	

	@Override
	public void insert(Connection conn, T t) throws SQLException {
		// INSERT INTO 表名? (?,?,?,?,...) VALUES (?,?,?,? ...);
		Class clazz = t.getClass();
		String sql = "INSERT INTO " + clazz.getSimpleName().toLowerCase();
		// 拼上所有的属性名
		sql += " (";
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			sql += f.getName();
			if(i < fields.length - 1) {
				sql += ",";
			}
		}
		sql += ") VALUES (";
		
		// 拼接占位符 ?
		for (int i = 0; i < fields.length; i++) {
			sql += "?";
			if(i < fields.length - 1) {
				sql += ",";
			}	
		}
		sql += ")";
		
		System.out.println(sql);
		
		// 预编译
		PreparedStatement ps = conn.prepareStatement(sql);
		
		// 替换占位符
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			// id -> getId
			String getterName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
			// 根据方法名 获取get方法
			try {
				Method getter = clazz.getDeclaredMethod(getterName);
				Object value = getter.invoke(t);
				ps.setObject(i+1, value);
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
		
		// 执行SQL语句
		int count = ps.executeUpdate();
		
	}

	@Override
	public void delete(Connection conn, int id) throws SQLException {
		// DELETE FROM 表名 WHERE id = ?
		String sql = "DELETE FROM " + gClass.getSimpleName().toLowerCase() 
					+ " WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		int count = ps.executeUpdate();
	}

	@Override
	public void update(Connection conn, T t) throws SQLException {
		// UPDATE user SET uname = '张三' , upwd = '456' , money = 300.0 WHERE id = 2;
		// UPDATE user SET uname = ? , upwd = ? , money = ? WHERE id = ?;
		
		String sql = "UPDATE " + gClass.getSimpleName().toLowerCase() + " SET ";
		Field[] fields = gClass.getDeclaredFields();
		for (Field field : fields) {
			if("id".equals(field.getName())) {
				continue;
			}
			sql += field.getName() + " = ?,";
		}
		// 去掉最后一个逗号
		sql = sql.substring(0, sql.length()-1);
		
		sql += " WHERE id = ?";
		
		System.out.println(sql);

		// 预编译SQL语句
		PreparedStatement ps = conn.prepareStatement(sql);
		int index = 1;	// 正在填写的?索引
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			// getter 方法
			// name -> getName
			String getterName = "get" 
								+ field.getName().substring(0, 1).toUpperCase() 
								+ field.getName().substring(1);
			try {
				Method getter = gClass.getDeclaredMethod(getterName);
				Object value = getter.invoke(t);
				if("id".equals(field.getName())) {
					// 是id必须放在最后
					ps.setObject(fields.length, value);
				} else {
					// 不是id就根据遍历到的位置放置
					ps.setObject(index++, value);
				}
				
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
		
		// 执行SQL语句
		int count = ps.executeUpdate();
	}

	@Override
	public T queryById(Connection conn, int id) throws SQLException {
		T t = null;
		// SELECT * FROM 表名 WHERE id = ?
		String sql = "SELECT * FROM " + gClass.getSimpleName().toLowerCase() + " WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			try {
				// 用反射调用公开的无参构造 构造对象
				t = (T) gClass.newInstance();
				// 给t对象设置属性
				Field[] fields = gClass.getDeclaredFields();
				for (Field f : fields) {
					// 从rs中 拿到属性的值
					Object value = rs.getObject(f.getName());
					// 拿到属性的 setter 方法
					// id -> setId(int id)
					String setterName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					Method setter = gClass.getDeclaredMethod(setterName, value.getClass());
					// 调用set方法赋值
					setter.invoke(t, value);
				}
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return t;
	}

	@Override
	public List<T> queryAll(Connection conn) throws SQLException {
		List<T> list = new ArrayList<>();
		
		// SELECT * FROM 表名
		String sql = "SELECT * FROM " + gClass.getSimpleName().toLowerCase();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			try {
				T t = null;
				// 用反射调用公开的无参构造 构造对象
				t = (T) gClass.newInstance();
				list.add(t);
				// 给t对象设置属性
				Field[] fields = gClass.getDeclaredFields();
				for (Field f : fields) {
					// 从rs中 拿到属性的值
					Object value = rs.getObject(f.getName());
					// 拿到属性的 setter 方法
					// id -> setId(int id)
					String setterName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					Method setter = gClass.getDeclaredMethod(setterName, value.getClass());
					// 调用set方法赋值
					setter.invoke(t, value);
				}
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return list;
	}

	@Override
	public int getCount(Connection conn) throws SQLException {
		// SELECT COUNT(*) FROM 表名?
		String sql = "SELECT COUNT(*) FROM " + gClass.getSimpleName().toLowerCase();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		if(rs.next()) {
			return rs.getInt(1);
		}
		
		return 0;
	}

}
