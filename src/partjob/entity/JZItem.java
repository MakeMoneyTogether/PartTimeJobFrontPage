package partjob.entity;

public class JZItem {
	int jid;
	String jname;
	String jlabel;
	String jlocal;
	String jstdate;
	String jmoney;
	String jtime;
	public JZItem(int jid,String jname,String jlabel,String jlocal,String jstdate,String jmoney,String jtime){
		this.jid = jid;
		this.jname = jname;
		this.jlabel = jlabel;
		this.jlocal = jlocal;
		this.jstdate = jstdate;
		this.jmoney = jmoney;
		this.jtime = jtime;
	}
	
	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getJlabel() {
		return jlabel;
	}
	public void setJlabel(String jlabel) {
		this.jlabel = jlabel;
	}
	public String getJlocal() {
		return jlocal;
	}
	public void setJlocal(String jlocal) {
		this.jlocal = jlocal;
	}
	public String getJstdate() {
		return jstdate;
	}
	public void setJstdate(String jstdate) {
		this.jstdate = jstdate;
	}
	public String getJmoney() {
		return jmoney;
	}
	public void setJmoney(String jmoney) {
		this.jmoney = jmoney;
	}
	public String getJtime() {
		return jtime;
	}
	public void setJtime(String jtime) {
		this.jtime = jtime;
	}
	
}
