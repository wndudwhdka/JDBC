package PocketmonsterMain;

import DTOs.*;
import DAOs.*;

public class PocektmonsterUpdate {

	public static void main(String[] args) {
		PocketmonsterDto dto = new PocketmonsterDto();
		dto.setNo(44);
		dto.setName("업데이트");
		dto.setType("얼음");
		
		PocketmonsterDao dao = new PocketmonsterDao();
		boolean result = dao.update(dto); 
		
		if(result) {
			System.out.println("변경 완료");
		}
		else
		{
			System.out.println("변경 실패");
		}
		
		

	}

}
