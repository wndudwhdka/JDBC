package select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.JdbcUtils;

public class SubjectSelect {

	public static void main(String[] args) {
		
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		
		String sql = "select * from Subject";
		
		RowMapper<SubjectDto> mapper = new RowMapper<SubjectDto>() {

			@Override
			public SubjectDto mapRow(ResultSet rs, int arg1) throws SQLException {
				SubjectDto dto = new SubjectDto(); 
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("Name"));
				dto.setPeriod(rs.getInt("period"));
				dto.setPrice(rs.getInt("price"));
				dto.setType(rs.getInt("type"));
				return dto;
			}
			
		};
		
		List<SubjectDto> list = jdbcTemplate.query(sql, mapper);
		
		for(SubjectDto dto : list)
		{
			System.out.println(dto.getNo());
			System.out.println(dto.getName());
			System.out.println(dto.getPeriod());
			System.out.println(dto.getPrice());
			System.out.println(dto.getType());
		}
		
	}
}
