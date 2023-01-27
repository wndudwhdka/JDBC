package DTOs;

public class SubjectDto {
	private int no, period, price; 
	private String name, type;
	public SubjectDto() {
		super();
	}
	@Override
	public String toString() {
		return "SubjectDto [no=" + no + ", period=" + period + ", price=" + price + ", type=" + type + ", name=" + name
				+ "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
