package app.model;

public class User {
	private String name;
	private String password;
	private String email;
	private String moblieNo;
	private String age;
	private String adhaarNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Register [name=" + name + ", password=" + password + ", email=" + email + ", moblieNo=" + moblieNo
				+ ", age=" + age + ", adhaarNo=" + adhaarNo + "]";
	}
	public User(String name, String password, String email, String moblieNo, String age, String adhaarNo) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.moblieNo = moblieNo;
		this.age = age;
		this.adhaarNo = adhaarNo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMoblieNo() {
		return moblieNo;
	}
	public void setMoblieNo(String moblieNo) {
		this.moblieNo = moblieNo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAdhaarNo() {
		return adhaarNo;
	}
	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

}
