package train.jungjun.login_join_page;

public class Name_chk {
	public boolean name_chk(String name) {
		String chk = Login_and_join.name1;
		boolean result = chk.matches("^[가-힣]{2,}");
		if(result) {
			return true;
		}else {
			return false;
		}
	}
}