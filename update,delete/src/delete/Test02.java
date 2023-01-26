package delete;

import org.springframework.jdbc.core.JdbcTemplate;
import jdbc.util.*;

public class Test02 {

	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();  

		int no = 2;
		String sql = "delete student where no=?";
		Object[] param = {no};
		int n = jdbcTemplate.update(sql,no); 
		if(n>0)
		{
			System.out.println("삭제완료");	
		}
		else
		{
			System.out.println("삭제실패");
		}
	
		
	}

}
