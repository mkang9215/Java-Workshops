package kang.employee;
import kang.payable.Payable;

public abstract class Employee implements Payable {
	String first;
	String last;
	String ssn;
	
	public Employee() {
	}
	

	public Employee(String first, String last, String ssn) {
		super();
		this.first = first;
		this.last = last;
		this.ssn = ssn;
	}
	
	
	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getLast() {
		return last;
	}


	public void setLast(String last) {
		this.last = last;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String toString() {
		return "Employee: " + getFirst() + " "+ getLast()
		+ "; SSN: "+ getSsn() + ";";
	}

}
