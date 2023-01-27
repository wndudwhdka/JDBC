package PocketmonsterMain;

import java.util.List;

import DAOs.PocketmonsterDao;
import DTOs.PocketmonsterDto;

public class PocketmonsterSelectAll {

	public static void main(String[] args) {
		PocketmonsterDao dao = new PocketmonsterDao();
		
		List<PocketmonsterDto> list = dao.selectList(); 
		
		if(list.isEmpty()) 
		{
			System.out.println("데이터가 없어요");
		}
		else
		{
			System.out.println("데이터 개수 : " + list.size());
			for(PocketmonsterDto dto : list)
			{
				System.out.println(dto);
			}
		}

	}

}
