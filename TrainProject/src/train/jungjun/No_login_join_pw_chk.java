package train.jungjun;

public class No_login_join_pw_chk {
	public boolean pw_chk() {
		String chk = No_login_join.pw;
		boolean result = chk.matches("^[0-9]{4}$");
		if(result) {
			return true;
		}
		return false;
	}
}
