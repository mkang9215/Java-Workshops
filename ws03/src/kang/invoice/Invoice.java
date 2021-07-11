package kang.invoice;
import kang.payable.Payable;

public class Invoice implements Payable {
	String part;
	String description;
	int count;
	double price;
	
	public Invoice() {
	}
	
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Invoice part: " + getPart()
		+ " description: "+ getDescription() 
		+ " count: " + getCount()
		+ " price: "+ getPrice();
	}

	@Override
	public double getPaymentAmount() {
		return 0;
	}

}
