package serachonlyone;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.*;
import java.util.List;

public class SearchStudentOne {
	
	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		
		int no = 1; 
		
		String sql = "select * from student where no =?";
		Object[] param = {no}; 
		
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
				
		List <StudentDto> list = jdbcTemplate.query(sql, mapper,param);
		if(list.isEmpty()) {
			System.out.println("없어요...");
		}
		else
		{
			System.out.println("있어요!");
		}
		
		
	}
}
