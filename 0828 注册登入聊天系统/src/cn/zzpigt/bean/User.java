package cn.zzpigt.bean;

public class User {
	private String uName;
	private String uPwd;
	
	public User(String uName, String uPwd) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	@Override
	public String toString() {
		return "User [uName=" + uName + ", uPwd=" + uPwd + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + ((uPwd == null) ? 0 : uPwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (uPwd == null) {
			if (other.uPwd != null)
				return false;
		} else if (!uPwd.equals(other.uPwd))
			return false;
		return true;
	}
	
	
	
	

}
