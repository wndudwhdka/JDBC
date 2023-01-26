package update;


import org.springframework.jdbc.core.JdbcTemplate;

// jdbc.util의 모든 클래스 호출
import jdbc.util.*;


public class Test03 {

	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		

		int no = 1; 
		String name = "JDBC APi 과정2";
		int period = 120;
		int price = 1500000;
		int type = 1; 
		
		Object[] parser = {name,period,price,type,no};
		String sql = "update subject set name =?, period=?, price=?, type=? where no =?";
		int count = jdbcTemplate.update(sql,parser);
//		if(jdbcTemplate.update(sql,parser)>0) System.out.println("실행이 제대로 되었습니다.");
//		else System.out.println("실행이 제대로 되지 않았습니다.");
		System.out.println(count);
	}

}
