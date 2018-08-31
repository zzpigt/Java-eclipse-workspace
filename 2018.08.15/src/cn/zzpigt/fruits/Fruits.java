package cn.zzpigt.fruits;

import java.util.Comparator;

public class Fruits implements Comparable<Fruits> {

	// 每种水果必须有水果id，水果名，水果数量，水果价格
	private int ID;
	private String name;
	private int fNum;
	private double fPrice;

	public Fruits(int ID, String name, int fNum, double fPrice) {
		super();
		this.ID = ID;
		this.name = name;
		this.fNum = fNum;
		this.fPrice = fPrice;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getfNum() {
		return fNum;
	}

	public void setfNum(int fNum) {
		this.fNum = fNum;
	}

	public double getfPrice() {
		return fPrice;
	}

	public void setfPrice(double fPrice) {
		this.fPrice = fPrice;
	}

	@Override
	public String toString() {
		return "Fruits [ID=" + ID + ", name=" + name + ", fNum=" + fNum + ", fPrice=" + fPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Fruits other = (Fruits) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Fruits o) {
		return this.getID() - o.getID();
	}

}
