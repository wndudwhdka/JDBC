package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import DTOs.SubjectDto;
import jdbc.util.JdbcUtils;

public class SubjectDao {

	private RowMapper<SubjectDto> mapper = new RowMapper<SubjectDto>(){

		@Override
		public SubjectDto mapRow(ResultSet rs, int arg1) throws SQLException {
			SubjectDto dto = new SubjectDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setPeriod(rs.getInt("period"));
			dto.setPrice(rs.getInt("price"));
			dto.setType(rs.getString("type"));
			return dto;
		}
		
	};
	
	//create 
	public void insert(SubjectDto dto)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "insert into subject(no,name,period,price,type)"
				+ "values(?,?,?,?,?)"; 
		Object[] param = {
				dto.getNo(),dto.getName(),dto.getPeriod(),dto.getPrice(),dto.getType()
		};
		jdbcTemplate.update(sql,param); 
	}	
	
	//read 전체 목록읽기
	public List<SubjectDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from subject order by no asc"; 
		return jdbcTemplate.query(sql,mapper);	
	}
	//read 검색 프로그램 selectList() 오버로딩 
	public List<SubjectDto> selectList(String column,String keyword)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from subject where instr(#1,?)>0 order by no asc"; 
		sql = sql.replace("#1",column);
		Object[] param = {keyword}; 
		return jdbcTemplate.query(sql,mapper,param);
		
	}
	public SubjectDto selectOne(int no)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from subject where no=?"; 
		Object[] param = {no}; 
		List<SubjectDto> list=  jdbcTemplate.query(sql,mapper,param);
		if(list.isEmpty())
		{
			return null; 
		}
		else {
			return list.get(0); 
		}
	}
	
	
	//update
	public boolean update(SubjectDto dto)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "update subject set name=?,period=?,price=?,type=? where no=?";
		Object[] param = {
				
				dto.getName(),
				dto.getPeriod(),
				dto.getPrice(),
				dto.getType(),
				dto.getNo()
		};
		int result = jdbcTemplate.update(sql,param); 
		return result >0; 
		
	}
	
	//delete
	public boolean delete(int no)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "delete subject where no=?"; 
		Object[] param = {no}; 
		
		int result = jdbcTemplate.update(sql,param); 
		return result >0; 
		
	}
	
}
