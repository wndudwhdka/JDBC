package select;

public class PocketmonsterDto {
	// - 일반적으로 DB와 같은 이름의 필드를 마늘고 기본생성자, getter/ setter 메소드까지 구현한다. 
	// - DTO는 테이블당 한개를 구현한다. 
	private int no;
	private String name; 
	private String type; 

	public PocketmonsterDto() {
		super(); 
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
