package DAOs;

import jdbc.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import DTOs.*;


public class MemberDao {

	RowMapper<MemberDto> mapper = new RowMapper<MemberDto>() {

		@Override
		public MemberDto mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberDto dto = new MemberDto();
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_nick(rs.getString("member_nick"));
			dto.setMember_tel(rs.getString("member_tel"));
			dto.setMember_email(rs.getString("member_email"));
			dto.setMember_birth(rs.getString("member_birth"));
			dto.setMember_post(rs.getString("member_post"));
			dto.setMember_basic_addr(rs.getString("member_basic_addr"));
			dto.setMember_detail_addr(rs.getString("member_detail_addr"));
			dto.setMember_level(rs.getString("member_level"));
			dto.setMember_point(rs.getInt("member_point"));
			dto.setMember_join(rs.getString("member_join"));
			dto.setMember_login(rs.getString("member_login"));
			return dto;
		}
	};
	
	
	// 등록 C
	public void insert(MemberDto dto)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "insert into member(member_id, member_pw, member_nick, member_tel, member_email,"
				+"member_birth,member_post,member_basic_addr,member_detail_addr,member_level,member_point,"
				+ "member_join,member_login) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = {
				dto.getMember_id(), dto.getMember_pw(), dto.getMember_nick(), dto.getMember_tel(),
				dto.getMember_email(), dto.getMember_birth(), dto.getMember_post(), dto.getMember_basic_addr(),
				dto.getMember_detail_addr(), dto.getMember_level(), dto.getMember_point(), dto.getMember_join(),
				dto.getMember_login()
		};
		jdbcTemplate.update(sql,param); 
	}
	
	// 모두 조회 R
	public List<MemberDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from member order by member_id asc";
		List<MemberDto> list = jdbcTemplate.query(sql,mapper);
		
		return list; 
	}
	
	// 상세 조회 R(오버로딩)
	public List<MemberDto> selectList(String column, String keyword){
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from MemberDto where insrt(#1,?) > 0 order by #1 asc";
		sql = sql.replace("#1",column); 
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper,param); 
	}
	
	// 단일 조회 R
	public MemberDto selectOne(String member_id)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from member where member_id =?"; 
		Object[] param = {member_id};
		List<MemberDto> list = jdbcTemplate.query(sql, mapper,sql); 
		if(list.isEmpty())
		{
			return null; 
		}
		else
		{
			return list.get(0); 
		}
	}
	
	// 단일 조회 R 닉네임(오버로딩)
	public MemberDto selectOne(String member_id, String member_nick)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "select * from member where member_nick =?"; 
		Object[] param = {member_nick};
		List<MemberDto> list = jdbcTemplate.query(sql, mapper,sql); 
		if(list.isEmpty())
		{
			return null; 
		}
		else
		{
			return list.get(0); 
		}
	}
	
	// 업데이트 U
	public boolean update(MemberDto dto)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "update member set member_id=?, member_pw=?, member_nick=?, member_tel=?,"
				+ "member_email=?, member_birth=?, member_post=?, member_basic_addr=?,"
				+ "member_detail_addr=?, member_level=?, member_point=?, member_join=?,"
				+ "member_login";
		Object[] param = {
				dto.getMember_id(), dto.getMember_pw(), dto.getMember_nick(), dto.getMember_tel(),
				dto.getMember_email(), dto.getMember_birth(), dto.getMember_post(), dto.getMember_basic_addr(),
				dto.getMember_detail_addr(), dto.getMember_level(), dto.getMember_point(), dto.getMember_join(),
				dto.getMember_login()
		};
		int result = jdbcTemplate.update(sql,param); 
		return result > 0; 
	}
	
	// 삭제 D
	public boolean delete(String member_id)
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdbcTemplate();
		String sql = "delete member where member_id = ?"; 
		Object[] param = {member_id}; 
		
		int result = jdbcTemplate.update(sql,param); 
		return result > 0; 		
	}
}
