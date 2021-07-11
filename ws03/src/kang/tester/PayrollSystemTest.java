package kang.tester;

import kang.employee.Employee;
import kang.employee.CommissionEmployee;
import kang.employee.HourlyEmployee;
import kang.employee.SalariedEmployee;
import kang.employee.BasePlusCommissionEmployee;

public class PayrollSystemTest {
	public static void main(String[] args) throws Exception {
		Employee[] e = { new CommissionEmployee("Jack", "Barney", "112-112-112", 25000.00, 0.12),
			new HourlyEmployee("Kyle", "Wright", "123-123-123", 25.00, 50),
			new SalariedEmployee("John", "Smith", "111-111-111", 800.00),
			new BasePlusCommissionEmployee("Minjung", "Kang", "345-345-345", 20000.00, 0.1, 1000.00) };

		System.out.println(e[0].toString());
		System.out.println(e[1].toString());
		System.out.println(e[2].toString());
		System.out.println(e[3].toString());
		System.out.println();
		
		for (int i = 0; i < e.length; i++) {
			System.out.printf("%s%nEarned: $%.2f%n%n", e[i].toString(), e[i].getPaymentAmount());
		}

		for (int i = 0; i < e.length; i++) {
			System.out.print(e[i].getFirst() + " " + e[i].getLast() + " is of class ");
			if (e[i] instanceof BasePlusCommissionEmployee)
				System.out.println("BasePlusCommissionEmployee");
			else if (e[i] instanceof CommissionEmployee)
				System.out.println("CommissionEmployee");
			else if (e[i] instanceof HourlyEmployee)
				System.out.println("HourlyEmployee");
			else if (e[i] instanceof SalariedEmployee)
				System.out.println("SalariedEmployee");
			else
				System.out.println("Employee");
		}
		
		//Employee e2 = new CommissionEmployee("Jack", "Barney", "112-112-112", 25000.00, 1.12);

	}
}
