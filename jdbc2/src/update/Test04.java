package update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.*;

public class Test04 {

	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		
		int no = 2; 
		String name = "김영이이이";
		int korean = 50;
		int english = 50;
		int math = 70; 
		
		Object[] param= {name,korean,english,math,no}; //,no
		String sql1 = "update STUDENT set NAME =?, KOREAN=?, ENGLISH=?, MATH=? where NO=?";
		int count = jdbcTemplate.update(sql1,param);
//		if(jdbcTemplate.update(sql,parser)>0) System.out.println("실행이 온전히 되었습니다.");
//		else System.out.println("실행이 온전히 되지 않았습니다.");
		System.out.println(count);

	}

}
