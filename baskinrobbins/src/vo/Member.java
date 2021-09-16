package vo;

import cartBean.CartBean;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String address_number;
	private String address;
	private String address_contents;
	private String email;
	private String birth;
	private String gender;
	private String grade;
	private String id_code;
	private String join_member;
	private String money;
	private String point;
	private String author;

	/* 장바구니 */
	private CartBean cart;
	// CratBean객체 생성하고 중복이면 CartBean객체 반환

	public CartBean getCart() {
		// 카트가 없을 때
		if (cart == null)
			// 새로운 카트 생성
			cart = new CartBean();

		// 카트가 있으면 cart리턴
		return cart;

	}

	public Member() {
	}

	public Member(String id, String pw, String name, String address_number, String address, String address_contents,
			String email, String birth, String gender, String grade, String id_code, String join_member, String money,
			String point, String author, CartBean cart) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address_number = address_number;
		this.address = address;
		this.address_contents = address_contents;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.grade = grade;
		this.id_code = id_code;
		this.join_member = join_member;
		this.money = money;
		this.point = point;
		this.author = author;
		this.cart = cart;
	}
	
	public Member(String id, String pw,String name, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress_number() {
		return address_number;
	}

	public void setAddress_number(String address_number) {
		this.address_number = address_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_contents() {
		return address_contents;
	}

	public void setAddress_contents(String address_contents) {
		this.address_contents = address_contents;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId_code() {
		return id_code;
	}

	public void setId_code(String id_code) {
		this.id_code = id_code;
	}

	public String getJoin_member() {
		return join_member;
	}

	public void setJoin_member(String join_member) {
		this.join_member = join_member;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", address_number=" + address_number
				+ ", address=" + address + ", address_contents=" + address_contents + ", email=" + email + ", birth="
				+ birth + ", gender=" + gender + ", grade=" + grade + ", id_code=" + id_code + ", join_member="
				+ join_member + ", money=" + money + ", point=" + point + ", author=" + author + ", cart=" + cart + "]";
	}

}
