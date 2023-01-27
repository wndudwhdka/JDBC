package SubjectMain;

import DAOs.SubjectDao;

public class SubjectDelete {

	public static void main(String[] args) {
		
		SubjectDao dao = new SubjectDao();
		int no = 4; 
		if(dao.delete(no))System.out.println("실행완료");
		else System.out.println("실행실패");
		
	}
}
