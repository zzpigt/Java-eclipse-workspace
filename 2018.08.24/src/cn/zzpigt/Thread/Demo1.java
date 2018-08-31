package cn.zzpigt.Thread;

public class Demo1 {
	public static void main(String[] args) {
		StudyRub sr = new StudyRub();
		StudyFar sf = new StudyFar();
		sr.setFarther(sf);
		
		sr.start();
		sf.start();
		
	}
}
