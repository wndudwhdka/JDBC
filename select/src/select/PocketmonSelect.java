package select;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.JdbcUtils;

public class PocketmonSelect {

	public static void main(String[] args) {
		
		
		// Spring JDBC Select
		// 조회 결과를(resultset)을 어떻게 담을지가 중요하다
		// 조회 결과를 담기 위한 객체 DTO(data transfer object)가 필요하다
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		
		String sql = "select * from pocketmonster"; 
		
		int result = jdbcTemplate.update(sql); 
		
		System.out.println("실행완료");
		System.out.println("result = " + result);
		
		// 변환 방법을 정의하는 객체를 생성(RowMapper) 인터페이스 이므로 익명중첩클래스로 선언
		// mapRow 메소드에 기본 제공되는 ResultSet을 PocketmonsterDto로 이동하도록 선언 
		RowMapper<PocketmonsterDto> mapper = new RowMapper<PocketmonsterDto>() {

	
			@Override
			public PocketmonsterDto mapRow(ResultSet rs, int arg1) throws SQLException {
				PocketmonsterDto dto = new PocketmonsterDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setType(rs.getString("type"));
				return dto;
			}
			
		};
		
		List<PocketmonsterDto> list = jdbcTemplate.query(sql, mapper);
		
		System.out.println(list.size());
		for(PocketmonsterDto dto:list)
		{
			System.out.println(dto.getNo());
			System.out.println(dto.getName());
			System.out.println(dto.getType());
		}

	}

}
