package kang.employee;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	double baseSalary;
	
	public BasePlusCommissionEmployee() {
	}

	public BasePlusCommissionEmployee(String first, String last, String ssn, double grossSales, double commissionRate,
			double baseSalary) throws Exception {
		super(first, last, ssn, grossSales, commissionRate);
		if(baseSalary <= 0.0) {
			throw new Exception("Base Salary should be over 0.0");
		}
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) throws Exception {
		if(baseSalary <= 0.0) {
			throw new Exception("Base Salary should be over 0.0");
		}
		this.baseSalary = baseSalary;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Base { Base Salary: " + getBaseSalary()+ " }";
	}
	
	@Override
	public double getPaymentAmount() {
		return getBaseSalary() * 1.1 + getGrossSales() * getCommissionRate();
	}
	
}
