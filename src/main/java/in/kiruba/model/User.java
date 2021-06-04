package in.kiruba.model;

public class User {
	private String name;
	private String password;
	private String email;
	private int age;
	private String mobileNo;
	private String adhaarNo;

	public User(String name, String password, String email, int age, String mobileNo, String adhaarNo) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
		this.mobileNo = mobileNo;
		this.adhaarNo = adhaarNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", age=" + age + ", mobileNo="
				+ mobileNo + ", adhaarNo=" + adhaarNo + "]";
	}

}
