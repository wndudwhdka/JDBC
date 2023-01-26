package search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.JdbcUtils;

public class SubjectSearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		System.out.println("검색할 항목을 입력해주세요");
		String type = sc.next(); 
		System.out.println("검색할 키워드를 입력해주세요");
		String keyword = sc.next(); 
		String sql = "select * from subject where instr(#1,?) >0";
		sc.close();
		sql = sql.replace("#1",type); 
		Object[] param = {keyword};
		
		RowMapper<SubjectDto> mapper = new RowMapper<SubjectDto>() {
			@Override
			public SubjectDto mapRow(ResultSet rs, int arg1) throws SQLException {
				SubjectDto dto = new SubjectDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPeriod(rs.getInt("period"));
				dto.setPrice(rs.getInt("price"));
				dto.setType(rs.getInt("type"));
				return dto;
			}
		};
			
		List<SubjectDto> list = jdbcTemplate.query(sql, mapper,param); 
		for(SubjectDto dto:list)
		{
			System.out.println(dto.getName());
			System.out.println(dto.getType());
		}
		
	

	}

}
