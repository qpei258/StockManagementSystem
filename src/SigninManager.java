
public interface SigninManager {
	//로그인
	public boolean signin(UserInfo user);
	//회원가입
	public boolean signup(UserInfo user);
	
	
	
	
	
	//비밀번호 찾기
	public boolean selectUserInfo(UserInfo user);
}
