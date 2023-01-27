package PocketmonsterMain;

import java.util.List;

import DAOs.PocketmonsterDao;
import DTOs.PocketmonsterDto;

public class PocketmonsterSpecificSelect {

	public static void main(String[] args) {
		
		
		
		String column = "name"; 
		String keyword = "이";
		
		PocketmonsterDao dao = new PocketmonsterDao();
		List<PocketmonsterDto> list = dao.selectList(column, keyword);
		
		
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
