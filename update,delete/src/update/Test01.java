package update;
//import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01 {

	public static void main(String[] args) {
		
		
		int no = 13; 
		String name = "디그다"; 
		String type = "땅"; 
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		//dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");//구버전(deprecated)
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh11");
		dataSource.setPassword("kh11");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "update pocketmonster set name = ?,type= ? where no= ?";
		Object[] param = {name,type,no};
		
		int count = jdbcTemplate.update(sql, param);
		if(count>0) System.out.println("실행 완료");
		else System.out.println("실행은 완료되었지만 대상은 없다"); 
		
		// 실행이 되더라도 대상이 있거나 없을 수 있다. 
		
	}
	
}
