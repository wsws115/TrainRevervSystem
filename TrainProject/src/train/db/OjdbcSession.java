package train.db;

import java.sql.Connection;

public class OjdbcSession implements AutoCloseable {
	
	private Connection conn;
	private boolean using;
	
	public OjdbcSession(Connection conn) {
		this.conn = conn;
	}
	
	public Connection getConnection() {
		using = true;
		return conn;
	}
	
	void setUse() {
		using = true;
	}
	
	boolean using() {
		return using;
	}
	
	// 커넥션이 닫히는게 아닌, 사용중이 아닌것으로 boolean값이 바뀜
	@Override
	public void close() throws Exception {
		using = false;
	}
	

}
