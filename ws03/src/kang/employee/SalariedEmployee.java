package kang.employee;

public class SalariedEmployee extends Employee {
	double weeklySalary;
	
	public SalariedEmployee() {
	}

	public SalariedEmployee(String first, String last, String ssn, double weeklySalary) throws Exception {
		super(first, last, ssn);
		if(weeklySalary <= 0.0) {
			throw new Exception("Weekly Salary should be over 0.0");
		}
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) throws Exception {
		if(weeklySalary <= 0.0) {
			throw new Exception("Weekly Salary should be over 0.0");
		}
		this.weeklySalary = weeklySalary;
	}	
	
	@Override
	public String toString() {
		return super.toString() + " Salaried { Weekly Salary: " + getWeeklySalary() + " }";
	}
	
	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
	
		
}
