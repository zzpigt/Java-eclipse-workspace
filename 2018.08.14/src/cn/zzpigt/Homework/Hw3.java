package cn.zzpigt.Homework;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Hw3 {
	public static void main(String[] args) {
//		1. 创建一个TreeSet对象ts，向ts分别添加3,5,1,2,4几个元素，然后通过迭代方式输出元素，
//		查看其输出顺序和添加顺序是否相同，判断其中是否有大于3的数最小元素，是否有大于等于1的最小元素，
//		如果有具体是多少
		TreeSet ts = new TreeSet();
		
		ts.add(3);
		ts.add(5);
		ts.add(1);
		ts.add(2);
		ts.add(4);
		
		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
		System.out.println("是否有大于3的数最小元素:"+ts.higher(3));
		System.out.println("是否有大于等于1的最小元素:"+ts.ceiling(1));
		
		
//		2. 获取ts中小于4的这部分元素是Set对象，并获取迭代器进行输出
		System.out.println("获取ts中小于4的这部分元素是Set对象"+ts.headSet(4));
		for (Object object : ts.headSet(4)) {
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		3. 获取ts中大于等于2的这部分元素Set组成的Set子集，使用迭代器进行输出
		System.out.println("获取ts中大于等于2的这部分元素Set组成的Set子集，使用迭代器进行输出:");
		for (Object object : ts.tailSet(2)) {
			System.out.print(object+"  ");
		}
		System.out.println();
		
		
//		4. 获取ts中元素大于等于1小于4的这部分Set子集使用迭代器进行输出
		System.out.println("获取ts中元素大于等于1小于4的这部分Set子集使用迭代器进行输出:");
		for (Object object : ts.tailSet(1).headSet(4)) {
			System.out.print(object+"  ");
		}
		System.out.println();
		
		
//		5. 将ts清空，向其中分别添加’c’,’d’,’z’,’a’,’f’几个元素，然后通过迭代方式输出元素，
		System.out.println("添加’c’,’d’,’z’,’a’,’f’几个元素，然后通过迭代方式输出元素:");
		ts.clear();
		ts.add('c');
		ts.add('d');
		ts.add('z');
		ts.add('a');
		ts.add('f');

		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		查看其输出顺序和添加顺序是否相同，输出顺序有什么规律
		//不同，输出顺序是按字母表的顺序输出，这是因为charactor或者String类型都有自己的排序规则
		//comparable
		
//		6. 再将ts清空，向其中分别添加”Hello”,”你好”,”我好”,”他好”,”大家好”，然后通过迭代方式
//		输出元素，查看其输出顺序和添加顺序是否相同，输出顺序有什么规律
		System.out.println("添加”Hello”,”你好”,”我好”,”他好”,”大家好”，然后通过迭代方式:");
		ts.clear();
		ts.add("Hello");
		ts.add("你好");
		ts.add("我好");
		ts.add("他好");
		ts.add("大家好");
		
		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		7. 将ts清空，将1,’a’,”Haha”，添加到ts中运行，看看会有什么现象
		System.out.println("将1,’a’,”Haha”，添加到ts中运行:");
		ts.clear();
//		ts.add(1);
//		ts.add('a');
//		ts.add("Haha");
		//类型不同，不能进行排序
//		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
//			Object object = (Object) iterator.next();
//			System.out.print(object+"  ");
//		}
//		System.out.println();
		
		
//		8. 获取一个逆序迭代器，使用该逆序迭代器进行迭代输出
		ts.clear();
		ts.add('c');
		ts.add('d');
		ts.add('z');
		ts.add('a');
		ts.add('f');
		
		System.out.println("获取一个逆序迭代器，使用该逆序迭代器进行迭代输出:");
		for (Iterator iterator = ts.descendingIterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		9. 获取一个逆序的set对象，并获取正序迭代器进行迭代输出
		System.out.println("获取一个逆序的set对象，并获取正序迭代器进行迭代输出:");
		NavigableSet descendingSet = ts.descendingSet();
		for (Iterator iterator = descendingSet.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();

//		10. 定义一个类Student
//		a)	属性：学号、年龄、姓名、成绩
//		b)	行为：showInfo展示学生信息
//		c)	构造方法：初始化所有属性
//		Student实现Comparable接口，覆写compareTo方法，通过学号进行升序排列
//		创建一个TreeSet对象treeSet 并创建出5个Student对象分别添加到treeSet中，
//		使用迭代器将所有元素输出，查看排序情况
		
		System.out.println("并创建出5个Student对象分别添加到treeSet:");
		
		Set<Student> treeSet = new TreeSet<>();
		
		treeSet.add(new Student(3, 23, "tong", 78.8));
		treeSet.add(new Student(2, 25, "jin", 58.8));
		treeSet.add(new Student(5, 24, "wen", 78.3));
		treeSet.add(new Student(7, 26, "zui", 66.3));
		treeSet.add(new Student(13, 27, "shuai", 98.3));
		
		for (Iterator iterator = treeSet.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
		

	}
}


class Student implements Comparable<Student >{
	private int stuNum;
	private int age;
	private String name;
	private double score;
	public Student(int stuNum, int age, String name, double score) {
		super();
		this.stuNum = stuNum;
		this.age = age;
		this.name = name;
		this.score = score;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public void showInfo() {
		System.out.println("学号\t年龄\t姓名\t成绩");
		System.out.println(this.getStuNum()+"\t"+this.getAge()+"\t"+this.getName()+"\t"+this.getScore());
	}
	
	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", age=" + age + ", name=" + name + ", score=" + score + "]";
	}
	@Override
	public int compareTo(Student o) {
		return this.getStuNum()-o.getStuNum();
	}
	
	
	
	
}