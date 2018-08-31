package cn.zzpigt.Thread;

public class StudyRub extends Thread {
	private StudyFar farther;
	
	
	public void setFarther(StudyFar farther) {
		this.farther = farther;
	}


	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			WriteAns();
		}
		
	}


	private void WriteAns() {
		// TODO Auto-generated method stub
		String answer = farther.getAnswer();
		System.out.println("Ñ§Ôü³­µ½ÁË"+answer);
		
	}
	
	
}
