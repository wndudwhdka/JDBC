package PocketmonsterMain;

import DAOs.PocketmonsterDao;
import DTOs.PocketmonsterDto;

public class PocketmonsterSpecificSelectOne {

	public static void main(String[] args) {
		
		int no = 1;
		
		PocketmonsterDao dao = new PocketmonsterDao(); 
		PocketmonsterDto dto = dao.selectOne(no);
		
		if(dto == null)
		{
			System.out.println("찾으시는 번호의 몬스터가 없어요");
		} 
		else
		{
			System.out.println(dto);
		}

	}

}
