package property;

public class Products {
	private int id;
	private String name;
	private String brand;
	private String type;
	private double cost;

	
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", brand=" + brand + ", type=" + type + ", cost=" + cost + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
