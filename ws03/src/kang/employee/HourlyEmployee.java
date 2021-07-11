package kang.employee;

public class HourlyEmployee extends Employee {
	double wage;
	double hours;
	
	public HourlyEmployee() {
	}

	public HourlyEmployee(String first, String last, String ssn, double wage, double hours) throws Exception {
		super(first, last, ssn);
		if(wage <= 0.0) {
			throw new Exception("Wage should be over 0.0");
		}
		this.wage = wage;
		if(hours < 0.0 || hours > 168.0) {
			throw new Exception("Hours should be between 0.0 and 168.0");
		}
		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) throws Exception {
		if(wage <= 0.0) {
			throw new Exception("Wage should be over 0.0");
		}
		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) throws Exception {
		if(hours < 0.0 || hours > 168.0) {
			throw new Exception("Hours should be between 0.0 and 168.0");
		}
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Hourly { Wage: " + getWage()
		+ ", Hours: "+ getHours() + " }";
	}
	
	@Override
	public double getPaymentAmount() {
		double pay;
		if(getHours() <= 40) {
			pay = getWage() * getHours();
		} else {
			pay = (getWage() * 40) + (getWage() * 1.5 * (getHours() - 40));
		}
		return pay;
	}
	
}
