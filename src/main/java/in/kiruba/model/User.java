package in.kiruba.model;

public class User {
	private String name;
	private String password;
	private String email;
	private int age;
	private long mobileNumber;
	private long aadharNumber;

	public User(String name, String password, String email, int age, long mobileNumber, long aadharNumber) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.aadharNumber = aadharNumber;
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

	public long getMobileNo() {
		return mobileNumber;
	}

	public void setMobileNo(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getAdhaarNo() {
		return aadharNumber;
	}

	public void setAdhaarNo(long aadharNumber) {
		this.aadharNumber = aadharNumber;
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
				+ mobileNumber + ", adhaarNo=" + aadharNumber + "]";
	}

}
