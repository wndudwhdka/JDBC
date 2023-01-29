package memberMain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DAOs.*;
import DTOs.*;

public class MemberMain {

	public static void main(String[] args) {
		
		MemberDto dto = new MemberDto(); 
				
		System.out.println("회원가입 진행입니다.");
		
		Scanner sc = new Scanner(System.in); 
		String id,pw,nick,tel,email,birth,post,basic_addr,detail_addr;
		MemberDao dao = new MemberDao(); 
		
		
		System.out.println("아이디를 입력해주세요 5~20자 영문 소문자, 숫자, 대시(-), 언더바(_)(중복 불가)");
		while(true)
		{
			id = sc.next();
			if(id.matches("[a-z-_0-9]{5,20}")) {
				// 아이디 중복검사 
				if(dao.selectOne(id)!=null)
				{
					System.out.println("중복 아이디입니다. ");
				}
				else
				{
					dto.setMember_id(id);
					break;
				}
				 
			}
			else System.out.println("다시 입력하세요 5~20자 영문 소문자, 숫자, 대시(-), 언더바(_)(중복 불가)");
		}
		System.out.println();

		
		System.out.println("비밀번호를 입력해주세요 8~16자 영문 대 소문자, 숫자, 특수문자를 사용");
		while(true)
		{
			pw = sc.next();
			if(pw.matches("[A-Za-z0-9-=+@#$%^&*\\(\\)_+\\\\\\|\\[\\]\\'\\\"/?.\\<\\>;:,\\`~]{8,16}")) 
			{
				dto.setMember_pw(pw);
				break; 
			}
			else System.out.println("다시 입력하세요8~16자 영문 대 소문자, 숫자, 특수문자를 사용");
		}
		System.out.println();
		
		
		System.out.println("닉네입을 입력하세요 2~10자 한글 또는 숫자를 사용(중복 불가)");
		while(true)
		{
			nick = sc.next();
			if(nick.matches("[가-힣0-9]{2,7}")) 
			{
				if(dao.selectOne(id,nick)!=null)
				{
					System.out.println("중복된 닉네임입니다.");
				}
				else
				{
					dto.setMember_nick(nick);
					break; 
				}
				
			}
			else System.out.println("다시 입력하세요 2~10자 한글 또는 숫자를 사용(중복 불가)");
		}
		System.out.println();
		
		
		System.out.println("전화번호를 입력하세요 휴대폰 번호만 가능(010XXXXXXXX), 대시 제외");
		while(true)
		{
			tel = sc.next();
			if(tel.matches("010[0-9]{8}"))
			{
				dto.setMember_tel(tel);
				break; 
			}
			else System.out.println("다시 입력하세요 휴대폰 번호만 가능(010XXXXXXXX), 대시 제외");
		}
		System.out.println();
		
		
		System.out.println("이메일을 입력하세요 넉넉하게 다합쳐서 100byte(선택 항목)");
		while(true)
		{
			email = sc.next();
			if(email.length()<100)
			{
				dto.setMember_email(email);
				break; 
			}
			else System.out.println("너무 긴 이메일을 입력하셨습니다.");
			
		}
		System.out.println();

		
		
		System.out.println("생년월일을 입력하세요 문자열 YYYY-MM-DD ");
		while(true)
		{
			birth = sc.next();
			if(birth.matches("[12][0-9]{3}-[01][0-9]-[0123][0-9]"))
			{
				dto.setMember_birth(birth);
				break; 
			}
			else System.out.println("다시 입력하세요 문자열 YYYY-MM-DD 형태");
		}
		System.out.println();
		
		
		System.out.println("우편번호를 입력하세요 5~6자리 숫자만 가능");
		while(true)
		{
			post = sc.next();
			if(post.matches("[0-9]{5,6}")) 
			{
				dto.setMember_post(post);
				break; 
			}
			
		}
		System.out.println();
		
		
		System.out.println("기본주소를 입력하세요 한글 100자 이내");
		while(true)
		{
			basic_addr = sc.next();
			if(basic_addr.matches("[가-힣]{10,100}"))
			{
				dto.setMember_basic_addr(basic_addr);
				break; 
			}
			else System.out.println("다시 입력하세요 한글 100자 이내");
		}
		System.out.println();
		
		
		System.out.println("상세주소를 입력하세요 한글 100자 이내");
		while(true)
		{
			detail_addr = sc.next();
			if(detail_addr.matches("[가-힣]{10,100}")) 
			{
				dto.setMember_detail_addr(detail_addr);
				break; 
			}
			else System.out.println("다시 입력하세요 한글 100자 이내");
		}
		System.out.println();	
		sc.close();
		
		
		// 회원 가입 시 기본 입력
		// 포인트
		dto.setMember_point(0);
		// 가입 시간
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dto.setMember_join(formatter.format(date));
		// 로그인 시간 
		dto.setMember_login("미입력"); 
		// 맴버 레벨
		dto.setMember_level("준회원");
	
		dao.insert(dto); 
		System.out.println("실행완료");
	
	}

}
