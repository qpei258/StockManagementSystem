
public class UserInfo {
	
	public UserInfo() {
	}
	
	public UserInfo(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	//아이디
	public String id;
	//비밀번호
	public String password;
	//이메일
	public String email;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
