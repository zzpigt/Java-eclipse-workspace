package cn.zzpigt.bean;

public class Record {

	private Integer id;
	private String connect;
	private String date;
	private Integer uid;
	
	public Record() {
		super();
	}
	
	public Record(Integer id, String connect, String date, Integer uid) {
		super();
		this.id = id;
		this.connect = connect;
		this.date = date;
		this.uid = uid;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConnect() {
		return connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", connect=" + connect + ", date=" + date + ", uid=" + uid + "]";
	}
	
	
	
	
	
}
