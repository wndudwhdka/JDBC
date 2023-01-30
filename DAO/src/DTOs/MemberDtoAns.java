package DTOs;

import java.sql.Date;

public class MemberDtoAns {

	private String memberId, memberPw, memberNick, memberTel,
	memberEmail, memberBirth, memberPost, memberBasicAddr,
	memberDetailAddr, memberLevel;
	private Date memberJoin, memberLogin;
	@Override
	public String toString() {
		return "MemberDtoAns [memberId=" + memberId + ", memberPw=" + memberPw + ", memberNick=" + memberNick
				+ ", memberTel=" + memberTel + ", memberEmail=" + memberEmail + ", memberBirth=" + memberBirth
				+ ", memberPost=" + memberPost + ", memberBasicAddr=" + memberBasicAddr + ", memberDetailAddr="
				+ memberDetailAddr + ", memberLevel=" + memberLevel + ", memberJoin=" + memberJoin + ", memberLogin="
				+ memberLogin + ", getMemberId()=" + getMemberId() + ", getMemberPw()=" + getMemberPw()
				+ ", getMemberNick()=" + getMemberNick() + ", getMemberTel()=" + getMemberTel() + ", getMemberEmail()="
				+ getMemberEmail() + ", getMemberBirth()=" + getMemberBirth() + ", getMemberPost()=" + getMemberPost()
				+ ", getMemberBasicAddr()=" + getMemberBasicAddr() + ", getMemberDetailAddr()=" + getMemberDetailAddr()
				+ ", getMemberLevel()=" + getMemberLevel() + ", getMemberJoin()=" + getMemberJoin()
				+ ", getMemberLogin()=" + getMemberLogin() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public MemberDtoAns() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberPost() {
		return memberPost;
	}
	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}
	public String getMemberBasicAddr() {
		return memberBasicAddr;
	}
	public void setMemberBasicAddr(String memberBasicAddr) {
		this.memberBasicAddr = memberBasicAddr;
	}
	public String getMemberDetailAddr() {
		return memberDetailAddr;
	}
	public void setMemberDetailAddr(String memberDetailAddr) {
		this.memberDetailAddr = memberDetailAddr;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public Date getMemberJoin() {
		return memberJoin;
	}
	public void setMemberJoin(Date memberJoin) {
		this.memberJoin = memberJoin;
	}
	public Date getMemberLogin() {
		return memberLogin;
	}
	public void setMemberLogin(Date memberLogin) {
		this.memberLogin = memberLogin;
	} 
}
