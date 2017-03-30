package partjob.entity;

public class District {
	int dcode;
	String dname;
	int ccode;
	public District(int dcode,String dname){
		this.dcode = dcode;
		this.dname = dname;
	}
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getCcode() {
		return ccode;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
}
