package delete;

import org.springframework.jdbc.core.JdbcTemplate;
import jdbc.util.*;

public class Test01 {

	public static void main(String[] args) {
		
		// 수정과 동일하게 결과 행 수를 토대로 삭제 성공/실패를 판정 
		
		int no = 1; 
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		
			
		String sql = "delete pocketmonster where no = ?";
		Object[] param = {no}; 
		
		int result = jdbcTemplate.update(sql,param); 
		if(result >0)
		{
			System.out.println("삭제 완료");
		}
		else
		{
			
			System.out.println("삭제 실패");
		}
		
		
		
		
	}

}
