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
 * 1. javaBean��������ͱ���һ��
 * 2. javaBean���������������һ��
 * 3. ���������id
 * 4. �����ð�װ���� int -> Integer
 * 5. �����й������޲ι���
 * 6. get set��������淶
 */

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class<?> gClass;	// T�ķ�������
	
	public BaseDaoImpl() {
		// ��ȡ�������� - T
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		gClass = (Class<?>) pt.getActualTypeArguments()[0];
	}
	

	@Override
	public void insert(Connection conn, T t) throws SQLException {
		// INSERT INTO ����? (?,?,?,?,...) VALUES (?,?,?,? ...);
		Class clazz = t.getClass();
		String sql = "INSERT INTO " + clazz.getSimpleName().toLowerCase();
		// ƴ�����е�������
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
		
		// ƴ��ռλ�� ?
		for (int i = 0; i < fields.length; i++) {
			sql += "?";
			if(i < fields.length - 1) {
				sql += ",";
			}	
		}
		sql += ")";
		
		System.out.println(sql);
		
		// Ԥ����
		PreparedStatement ps = conn.prepareStatement(sql);
		
		// �滻ռλ��
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			// id -> getId
			String getterName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
			// ���ݷ����� ��ȡget����
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
		
		// ִ��SQL���
		int count = ps.executeUpdate();
		
	}

	@Override
	public void delete(Connection conn, int id) throws SQLException {
		// DELETE FROM ���� WHERE id = ?
		String sql = "DELETE FROM " + gClass.getSimpleName().toLowerCase() 
					+ " WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		int count = ps.executeUpdate();
	}

	@Override
	public void update(Connection conn, T t) throws SQLException {
		// UPDATE user SET uname = '����' , upwd = '456' , money = 300.0 WHERE id = 2;
		// UPDATE user SET uname = ? , upwd = ? , money = ? WHERE id = ?;
		
		String sql = "UPDATE " + gClass.getSimpleName().toLowerCase() + " SET ";
		Field[] fields = gClass.getDeclaredFields();
		for (Field field : fields) {
			if("id".equals(field.getName())) {
				continue;
			}
			sql += field.getName() + " = ?,";
		}
		// ȥ�����һ������
		sql = sql.substring(0, sql.length()-1);
		
		sql += " WHERE id = ?";
		
		System.out.println(sql);

		// Ԥ����SQL���
		PreparedStatement ps = conn.prepareStatement(sql);
		int index = 1;	// ������д��?����
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			// getter ����
			// name -> getName
			String getterName = "get" 
								+ field.getName().substring(0, 1).toUpperCase() 
								+ field.getName().substring(1);
			try {
				Method getter = gClass.getDeclaredMethod(getterName);
				Object value = getter.invoke(t);
				if("id".equals(field.getName())) {
					// ��id����������
					ps.setObject(fields.length, value);
				} else {
					// ����id�͸��ݱ�������λ�÷���
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
		
		// ִ��SQL���
		int count = ps.executeUpdate();
	}

	@Override
	public T queryById(Connection conn, int id) throws SQLException {
		T t = null;
		// SELECT * FROM ���� WHERE id = ?
		String sql = "SELECT * FROM " + gClass.getSimpleName().toLowerCase() + " WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			try {
				// �÷�����ù������޲ι��� �������
				t = (T) gClass.newInstance();
				// ��t������������
				Field[] fields = gClass.getDeclaredFields();
				for (Field f : fields) {
					// ��rs�� �õ����Ե�ֵ
					Object value = rs.getObject(f.getName());
					// �õ����Ե� setter ����
					// id -> setId(int id)
					String setterName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					Method setter = gClass.getDeclaredMethod(setterName, value.getClass());
					// ����set������ֵ
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
		
		// SELECT * FROM ����
		String sql = "SELECT * FROM " + gClass.getSimpleName().toLowerCase();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			try {
				T t = null;
				// �÷�����ù������޲ι��� �������
				t = (T) gClass.newInstance();
				list.add(t);
				// ��t������������
				Field[] fields = gClass.getDeclaredFields();
				for (Field f : fields) {
					// ��rs�� �õ����Ե�ֵ
					Object value = rs.getObject(f.getName());
					// �õ����Ե� setter ����
					// id -> setId(int id)
					String setterName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
					Method setter = gClass.getDeclaredMethod(setterName, value.getClass());
					// ����set������ֵ
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
		// SELECT COUNT(*) FROM ����?
		String sql = "SELECT COUNT(*) FROM " + gClass.getSimpleName().toLowerCase();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		if(rs.next()) {
			return rs.getInt(1);
		}
		
		return 0;
	}

}
