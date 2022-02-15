package board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class BoardDAO {

	public int hit(SqlSession session, String boardID) {
		int n = session.insert("BasicMapper.write", boardID);
		return n;
	}
	
	public int write(SqlSession session, BoardDTO boardDTO) {
		int n = session.insert("BasicMapper.write", boardDTO);
		return n;
	}

	public List<BoardDTO> getList(SqlSession session) {
		System.out.println("aaaa");
		List<BoardDTO> boardList  = session.selectList("BasicMapper.getList");
		return boardList;
	}

	public BoardDTO getBoard(SqlSession session, String boardID) {
		BoardDTO dto = session.selectOne("BasicMapper.getBoard", boardID);
		return dto;
	}


}
