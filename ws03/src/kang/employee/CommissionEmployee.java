package kang.employee;

public class CommissionEmployee extends Employee {
	double grossSales;
	double commissionRate;
	
	public CommissionEmployee() {
	}

	public CommissionEmployee(String first, String last, String ssn, double grossSales, double commissionRate) throws Exception {
		super(first, last, ssn);
		if(grossSales <= 0.0) {
			throw new Exception("Gross Sales should be over 0.0");
		}
		this.grossSales = grossSales;

		if(commissionRate < 0.0 || commissionRate > 1.0) {
			throw new Exception("Commission Rate should be between 0.0 and 1.0");
		}
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) throws Exception {
		if(grossSales <= 0.0) {
			throw new Exception("Gross Sales should be over 0.0");
		}
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) throws Exception {
		if(commissionRate < 0.0 || commissionRate > 1.0) {
			throw new Exception("Commission Rate should be between 0.0 and 1.0");
		}
		this.commissionRate = commissionRate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Commission { Gross Sales: " + getGrossSales()
		+ ", Commission Rate: "+ getCommissionRate() + " }";
	}
	
	@Override
	public double getPaymentAmount() {
		return getGrossSales() * getCommissionRate();
	}
	
}
