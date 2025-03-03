package class10_polymorphism.product2;

class Product {
	int price;
	int bonuspoint;
	
	Product(int price) {
		this.price = price;
		this.bonuspoint = price / 10;
	}
}
class TV extends Product{
	TV() {
		super(100);
	}
	@Override
	public String toString() {
		return "TV";
	}
}
class Computer extends Product{
	Computer() {
		super(300);
	}
	@Override
	public String toString() {
		return "Computer";
	}
}

class SmartPhone extends Product{
	public SmartPhone() {
		super(400);
	}
	
	@Override
	public String toString() {
		return "SmartPhone";
	}
}


