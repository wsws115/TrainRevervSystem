package train.jungjun.login_join_page;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OjdbcConnectionPool {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// List
	private List<OjdbcSession> sessions = new ArrayList<>();
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static int initPoolSize = 5; // 임의로 설정한 연결 수
	
	// 커넥션을 List에 넣어놓는다
	public OjdbcConnectionPool(String id, String password) {
		// 초기 크기만큼 연결을 미리 생성해서 List에 넣어놓는다
		try {
			for (int i = 0; i < initPoolSize; ++i) {
				sessions.add(new OjdbcSession
						(DriverManager.getConnection(url, id, password)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 꺼내서 쓰기, 사용중이면 true 값
	public OjdbcSession getSession() {
		
		for (OjdbcSession session : sessions) {
			if (!session.using()) {
				session.setUse();
				return session;
			}
		}
		
		System.out.println("모든 DB 연결이 사용중입니다.");
		return null;
	}
	
	public void status() {
		int size = sessions.size();
		
		for (int i = 0; i < size; ++i) {
			System.out.printf("Session %d : %s\n", i, sessions.get(i).using() ? "사용중" : "미사용(사용가능)");
		}
	}

}