package user;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;


public class UserDAO {

	public UserDTO login(SqlSession session, HashMap<String, String> map) {
		UserDTO dto = session.selectOne("BasicMapper.login", map); 
		return dto;
	}

	public int register(SqlSession session, UserDTO dto) {
		int n = session.insert("BasicMapper.register", dto);
		return n;
	}

	public UserDTO getUser(SqlSession session, String userID) {
		UserDTO dto = session.selectOne("BasicMapper.getUser",userID);
		return dto;
	}

	public int update(SqlSession session, UserDTO dto) {
		int n = session.update("BasicMapper.update", dto);
		return n;
	}

	public int profile(SqlSession session, HashMap<String, String> map) {
		int n = session.update("BasicMapper.profile", map);
		return n;
	}

}
