package train.jungjun;

public class No_login_join_Num_chk {
	public boolean num_chk() {
		String chk = No_login_join.phone_num;
		boolean result = chk.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
		if(result) {
			return true;
		}
		return false;
	}
}
