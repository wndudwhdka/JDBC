package PocketmonsterMain;

import DAOs.*;

public class PockemonsterDelete {

	public static void main(String[] args) {
		
		int no = 44; 
		PocketmonsterDao dao = new PocketmonsterDao(); 
		boolean result = dao.delete(no); 
		if(result) System.out.println("삭제완료");
		else System.out.println("삭제실패");
		
	}

}
