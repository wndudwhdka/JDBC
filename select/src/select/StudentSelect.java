package select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.JdbcUtils;

public class StudentSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		
		String sql = "select * from student"; 
		
		int result = jdbcTemplate.update(sql); 
		
		
		// 변환 방법을 정의하는 객체를 생성(RowMapper) 인터페이스 이므로 익명중첩클래스로 선언
		// mapRow 메소드에 기본 제공되는 ResultSet을 PocketmonsterDto로 이동하도록 선언 
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
		
		List<StudentDto> list = jdbcTemplate.query(sql, mapper);
		
		
		for(StudentDto dto:list)
		{
			System.out.println(dto.getNo());
			System.out.println(dto.getName());
			System.out.println(dto.getKorean());
			System.out.println(dto.getEnglish());
			System.out.println(dto.getMath());
		}
	}

}
