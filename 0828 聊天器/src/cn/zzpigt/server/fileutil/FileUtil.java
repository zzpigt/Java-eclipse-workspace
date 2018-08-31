package cn.zzpigt.server.fileutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.zzpigt.bean.LogRecord;
import cn.zzpigt.bean.User;



public class FileUtil {

	public static void saveUserList(List<User> list) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("ulist.bin")));
			oos.writeObject(list);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<User> loadUserList(){
		try {
			
			if(!new File("ulist.bin").exists()) {
				return new ArrayList<>();
			}
			
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("ulist.bin")));
	
			return (List<User>) ois.readObject();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	public static synchronized void saveLog(LogRecord log) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("log.log",true));
			StringBuilder sb = new StringBuilder("请求时间：").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(log.getDate()))
					//ip
					.append(" 请求IP：").append(log.getIP())
					//request
					.append(" 请求数据：").append(log.getRequest())
					.append(" 响应：").append(log.getResponse());
			
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
