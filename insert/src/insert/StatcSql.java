package insert;

import org.springframework.jdbc.core.JdbcTemplate;
import jdbc.util.*;

public class StatcSql {

	public static void main(String[] args) {
		
		// 정적 SQL 방식
		// - SQL 구문을 내가 다 만들어서 전송하는 방식
		// - 단점 : 구문이 지저분함, 못쓰는 글자가 있음, 보안에 최악

		// 데이터 준비
		int rank = 2;
		String name = "리오넬 메시";
		String nation = "아르헨티나";
		int goal = 7;

		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();

		String sql = "insert into worldcup(rank,name,nation,goal) " + "values(" + rank + ", '" + name + "', '" + nation
				+ "', " + goal + ")";

		jdbcTemplate.update(sql);

		System.out.println("실행 완료");

	}

}
