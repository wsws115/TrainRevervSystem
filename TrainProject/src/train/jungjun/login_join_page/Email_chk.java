package train.jungjun.login_join_page;

public class Email_chk {
	public boolean email_chk() {
		String chk_email = Login_and_join.email;
		boolean result = chk_email.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?");
		if(result) {
			return true;
		}
		return false;
	}
}