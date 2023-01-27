package SubjectMain;

import DAOs.SubjectDao;
import DTOs.SubjectDto;

public class SubjectInsert {

	public static void main(String[] args) {
		
		SubjectDto dto = new SubjectDto();
		dto.setNo(4);
		dto.setName("자바알고리즘");
		dto.setPeriod(30);
		dto.setPrice(2000000);
		dto.setType("0");
		
		SubjectDao dao = new SubjectDao();
		dao.insert(dto); 
		
		System.out.println("실행완료");
		
	}

}
