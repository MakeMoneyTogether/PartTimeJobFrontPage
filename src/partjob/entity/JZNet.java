package partjob.entity;

public class JZNet {
	int jid;
	String jname;
	String jlabel;
	String jdate;
	double money;
	
	public JZNet(int jid,String jname,String jlabel,String jdate,double money){
		this.jid = jid;
		this.jname = jname;
		this.jlabel = jlabel;
		this.jdate = jdate;
		this.money = money;
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
	public String getJdate() {
		return jdate;
	}
	public void setJdate(String jdate) {
		this.jdate = jdate;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
}
