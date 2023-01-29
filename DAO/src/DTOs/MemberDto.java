package DTOs;

public class MemberDto {

	private int member_point;
	private String member_id, member_pw, member_nick, member_tel,
	member_email, member_birth, member_post, member_basic_addr,
	member_detail_addr, member_level;
	private String member_join, member_login;
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MemberDto [member_point=" + member_point + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_nick=" + member_nick + ", member_tel=" + member_tel + ", member_email=" + member_email
				+ ", member_birth=" + member_birth + ", member_post=" + member_post + ", member_basic_addr="
				+ member_basic_addr + ", member_detail_addr=" + member_detail_addr + ", member_level=" + member_level
				+ ", member_join=" + member_join + ", member_login=" + member_login + ", getMember_point()="
				+ getMember_point() + ", getMember_id()=" + getMember_id() + ", getMember_pw()=" + getMember_pw()
				+ ", getMember_nick()=" + getMember_nick() + ", getMember_tel()=" + getMember_tel()
				+ ", getMember_email()=" + getMember_email() + ", getMember_birth()=" + getMember_birth()
				+ ", getMember_post()=" + getMember_post() + ", getMember_basic_addr()=" + getMember_basic_addr()
				+ ", getMember_detail_addr()=" + getMember_detail_addr() + ", getMember_level()=" + getMember_level()
				+ ", getMember_join()=" + getMember_join() + ", getMember_login()=" + getMember_login()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getMember_point() {
		return member_point;
	}
	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_post() {
		return member_post;
	}
	public void setMember_post(String member_post) {
		this.member_post = member_post;
	}
	public String getMember_basic_addr() {
		return member_basic_addr;
	}
	public void setMember_basic_addr(String member_basic_addr) {
		this.member_basic_addr = member_basic_addr;
	}
	public String getMember_detail_addr() {
		return member_detail_addr;
	}
	public void setMember_detail_addr(String member_detail_addr) {
		this.member_detail_addr = member_detail_addr;
	}
	public String getMember_level() {
		return member_level;
	}
	public void setMember_level(String member_level) {
		this.member_level = member_level;
	}
	public String getMember_join() {
		return member_join;
	}
	public void setMember_join(String member_join) {
		this.member_join = member_join;
	}
	public String getMember_login() {
		return member_login;
	}
	public void setMember_login(String member_login) {
		this.member_login = member_login;
	}
}
