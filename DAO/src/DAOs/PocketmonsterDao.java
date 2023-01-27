package DAOs;
//DAO(data access objects) : 데이터베이스에 접근하기 위한 객체 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import DTOs.PocketmonsterDto;
import jdbc.util.JdbcUtils;

public class PocketmonsterDao {

	private RowMapper<PocketmonsterDto> mapper = new RowMapper<PocketmonsterDto>() {

		@Override
		public PocketmonsterDto mapRow(ResultSet rs, int arg1) throws SQLException {
			PocketmonsterDto dto = new PocketmonsterDto(); 
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		}
	};
	
	// 등록C
	public void insert(PocketmonsterDto dto)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "insert into pocketmonster(no,name,type) "
				+ "values(?,?,?)";
		Object[] param = {
				dto.getNo(),dto.getName(),dto.getType()
		};
		jdbcTemplate.update(sql,param);
	
	}
	
	
	// R 목록읽기
	public List<PocketmonsterDto> selectList() {
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from pocketmonster order by no asc"; 
		List<PocketmonsterDto> list = jdbcTemplate.query(sql, mapper);
		
		return jdbcTemplate.query(sql, mapper); 
	}
	// R 상세읽기 
	public List<PocketmonsterDto> selectList(String column, String keyword)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate(); 
		String sql = "select * from pocketmonster where instr(#1,?) > 0 order by #1 asc";
		sql = sql.replace("#1",column); 
		Object[] param = {keyword};
		return jdbcTemplate.query(sql,mapper,param); 
	}
	// R
	public PocketmonsterDto selectOne(int no)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		
		String sql =  "select * from pocketmonster where no =?"; 
		Object[] param = {no};
		
		List<PocketmonsterDto> list = jdbcTemplate.query(sql, mapper, param);
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	// 수정U
	public boolean update(PocketmonsterDto dto) 
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "update pocketmonster set name=?, type=? where no=?"; 
		Object[] param = {
				dto.getName(),
				dto.getType(),
				dto.getNo()	
		};
		int result = jdbcTemplate.update(sql,param); 	
		return result > 0;
	}
	
	
	// 삭제D
	public boolean delete(int no)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "delete pocketmonster where no = ? "; 
		Object[] param = {no}; 
		
		int result = jdbcTemplate.update(sql, param); 
		return result > 0; 
	}
}
