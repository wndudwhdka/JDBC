package SubjectMain;

import DAOs.SubjectDao;
import DTOs.SubjectDto;

public class SubjectUpdate {

	public static void main(String[] args) {
		
		SubjectDto dto = new SubjectDto();
		int no = 3, period = 90, price = 1000000;
		String name = "웹 개발자 마스터",type ="1"; 
		dto.setNo(no);
		dto.setName(name);
		dto.setPeriod(period);
		dto.setPrice(price);
		dto.setType(type);
		
		
		SubjectDao dao = new SubjectDao(); 
		if(dao.update(dto))System.out.println("실행완료");
		else System.out.println("실행실패");

	}

}
