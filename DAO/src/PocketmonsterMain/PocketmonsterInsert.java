package PocketmonsterMain;

import DAOs.*;
import DTOs.*;
import jdbc.util.*;

public class PocketmonsterInsert {

	public static void main(String[] args) {
		PocketmonsterDto dto = new PocketmonsterDto();
		dto.setNo(44);
		dto.setName("메가킹카");
		dto.setType("노말");
	
		PocketmonsterDao dao = new PocketmonsterDao(); 
		dao.insert(dto);
		
		System.out.println("실행완료");
		
	}

}
