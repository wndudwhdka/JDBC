package search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.JdbcUtils;

public class StudentSearch {
	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate(); 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 항목을 입력하세요");
		String type = sc.next();
		System.out.println("검색할 키워드를 입력하세요");
		String keyword = sc.next(); 
		String sql = "select * from student where instr(#1, ?) > 0 "
				+ "order by #1 asc";
		sc.close(); 
		sql = sql.replace("#1",type); 
		Object[] param = {keyword};
		
		RowMapper<StudentDto> mapper = new RowMapper<StudentDto>() {
			@Override
			public StudentDto mapRow(ResultSet rs, int arg1) throws SQLException {
				StudentDto dto = new StudentDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setKorean(rs.getInt("korean"));
				dto.setEnglish(rs.getInt("english"));
				dto.setMath(rs.getInt("math"));
				return dto;
			} 
		};
		List<StudentDto> list = jdbcTemplate.query(sql,mapper,param);
		for(StudentDto dto : list)
		{
			System.out.println(dto.name);
		}
		
		
	}
}
