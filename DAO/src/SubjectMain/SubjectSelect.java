package SubjectMain;

import java.util.List;

import DAOs.SubjectDao;
import DTOs.SubjectDto;

public class SubjectSelect {

	public static void main(String[] args) {
		
		// 목록 조회
		SubjectDao dao = new SubjectDao();
		List<SubjectDto> list= dao.selectList();
		System.out.println("모든 목록조회입니다.");
		for(SubjectDto dto : list)
		{
			System.out.println(dto);
		}
		System.out.println();
		
		
		// column 기반 keyword 검색
		String column = "name";
		String keyword = "이";
		
		List<SubjectDto> search = dao.selectList(column, keyword); 
		if(search.isEmpty())
		{
			System.out.println("검색결과가 없습니다"); 
		}
		else
		{
			System.out.println("'"+column+"'열에서의 '"+keyword+"'키워드 검색결과는 다음과 같습니다.");
			for(SubjectDto dto:search)
			{
				System.out.println(dto);
			}
		}
		System.out.println();
		
		// Primary Key 기반 단일 행 검색
		int no = 1; 
		SubjectDto one = dao.selectOne(no);
		System.out.println("PK가 "+no+"인 키의 행입니다.");
		System.out.println(one);
		
		
		
		
		
		
		
		
	}

}
