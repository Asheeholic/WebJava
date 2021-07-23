package co.micol.member.vo;

/**
 * @author admin VO 객체는 테이블과 1:1대응하면서 작성 
 * 필요하다면 join 테이블도 따로 만들어서 작성.
 *
 */
public class MemberVO { // member table과 컬럼명 및 타입이 일치하도록 만듬.
	private String id;
	private String password;
	private String name;
	private int age;
	private String hobby;

	public MemberVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
