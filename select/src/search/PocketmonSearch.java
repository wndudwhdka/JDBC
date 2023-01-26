package search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.*;

public class PocketmonSearch {

	public static void main(String[] args) {
		//
		// 검색 방법에는 완전 동일 검색
		// instr 검색
		// like 검색이 있다. 시작검색일 경우 like가 아닐경우 instr가 일반적으로 좋다.

		String type = "name"; // 검색 분류 여기서 type을 동적 바인딩하여 instr(?,?) 방식을 사용하면 처음 ?에 'name'에서 따옴표가
		// 정적할당을 해주어야 한다 .
		String keyword = "라큐"; // 검색 키워드 (동적 바인딩)

		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from pocketmonster where instr(#1,?) >0";
		sql = sql.replace("#1", type);
		Object[] param = { keyword };

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

		List<PocketmonsterDto> list = jdbcTemplate.query(sql, mapper, param);
		for (PocketmonsterDto dto : list) 
		{

			System.out.println(dto.getName());
			System.out.println(dto.getType());
		}

	}

}
