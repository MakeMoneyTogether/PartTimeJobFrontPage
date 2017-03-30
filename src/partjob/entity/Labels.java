package partjob.entity;

public class Labels {
	int lcode;
	String lname;
	
	public Labels(int lcode,String lname){
		this.lcode = lcode;
		this.lname = lname;
	}

	public int getLcode() {
		return lcode;
	}

	public void setLcode(int lcode) {
		this.lcode = lcode;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
