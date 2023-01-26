package serachonlyone;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.*;
import java.util.List;

public class SearchSubjectOne {

	public static void main(String[] args) {
		
		//PK(primary key) 
		int no = 1;
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from subject where no= ?";
		Object[] param = {no};
		
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
		
		if(list.isEmpty()) System.out.println("없어요");
		else System.out.println("있어요!");
		
		
		
	}
	
}
