package cn.zzpigt.Homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Hw2 {
	public static void main(String[] args) {
//		1. ����HashMap�Ķ���map����������2����ֵ�ԣ��ֱ��ǣ�name-������������(age-23)���ж�height�Ƿ�Ϊmap��һ��key
		Map<String,String> map = new HashMap<>();
		map.put("name", "����");
		map.put("age", "23");
		
		System.out.println("height�Ƿ�Ϊmap��һ��key:"+map.containsKey("heigth"));
		
//		2. �жϡ����������ֵ�Ƿ��ڸ�map��
		System.out.println("�����������ֵ�Ƿ��ڸ�map��:"+map.containsValue("����"));
		
//		3. �ֱ�ͨ��name��age����keyȡ����ֵ
		System.out.println("ͨ��name:"+map.get("name"));
		System.out.println("ͨ��age:"+map.get("age"));
//		4. ��ȡmap������key��ɵ�Set
		System.out.println("��ȡmap������key��ɵ�Set:");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.print(key+"  ");
		}
		System.out.println();
//		5. ��ȡmap������ӳ���ϵ���Set
		System.out.println("��ȡmap������ӳ���ϵ���Set:");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
//		6. ��ȡmap�����е�ֵ��ɵ�Collection����
		System.out.println("��ȡmap�����е�ֵ��ɵ�Collection����:");
		Collection<String> values = map.values();
		for (String value : values) {
			System.out.print(value+"  ");
		}
		System.out.println();
		
//		7. ʹ��name���keyͨ��get������ȡ������
		System.out.println("ʹ��name���keyͨ��get������ȡ������:"+map.get("name"));
		
//		8. �Ƴ�age���key
		System.out.println(" �Ƴ�age���key:"+map.remove("age"));
		
//		9. �Ƴ����е�ӳ���ϵ
		map.clear();
		System.out.println(map.size());
		
	}
	public void name() {
		
	}
}
