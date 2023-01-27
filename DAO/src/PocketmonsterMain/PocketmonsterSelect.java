package PocketmonsterMain;

import java.util.List;

import DAOs.PocketmonsterDao;
import DTOs.PocketmonsterDto;

public class PocketmonsterSelect {
	public static void main(String[] args) {
		PocketmonsterDao dao = new PocketmonsterDao();
		
		String column="name";
		String keyword="이상"; 
		
		List<PocketmonsterDto> list = dao.selectList(); 
		
		if(column != null && keyword !=null) {
			list= dao.selectList(column,keyword); 
		}
		else
		{
			list= dao.selectList();
		}

		if(list.isEmpty())
		{
			System.out.println("데이터가 없으면");		}
		else
		{
			System.out.println("데이터가 있으면");
		}
		
	}
}
