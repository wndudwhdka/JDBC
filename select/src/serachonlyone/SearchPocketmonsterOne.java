package serachonlyone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jdbc.util.JdbcUtils;
import search.PocketmonsterDto;

public class SearchPocketmonsterOne {

	public static void main(String[] args) {
		
		// 검색 기준은 primary key이다, 한개만 존재하기 때문에 primary key를 기준으로한다. 
		Scanner sc = new Scanner(System.in); 
		int no = sc.nextInt();
		sc.close(); 
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from pocketmonster where no= ?";
		Object[] param = {no}; 
		
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
		
		
		List<PocketmonsterDto> list = jdbcTemplate.query(sql, mapper,param); 
		// 여기까지는 같으나 list에 최대로 존재할 수 있는 개수가 하나밖에 없다. 
		if(list.isEmpty()) {
			System.out.println("해당 번호의 몬스터는 존재하지 않습니다.");
		}
		else
		{
			PocketmonsterDto dto = list.get(0);
			System.out.println(dto.getName());
		}
		
	}
	
}
