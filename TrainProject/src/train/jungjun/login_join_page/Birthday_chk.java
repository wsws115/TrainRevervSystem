package train.jungjun.login_join_page;

public class Birthday_chk {
	public boolean birthday_chk() {
		String chk = Login_and_join.birthday;
		boolean result = chk.matches
				("^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$");
		if(result) {
			return true;
		}
		return false;
	}
}