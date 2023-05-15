package train.jungjun.login_join_page;

public class ID_chk {
	public boolean id_chk(String id) {
		String chk = Login_and_join.id2;
		boolean result = chk.matches("^[a-zA-Z]+[a-zA-Z0-9]{3,19}$");
		if(result) {
			return true;
		}else{
			return false;
		}		
	}
}