package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;

import board.BoardDAO;
import board.BoardDTO;

public class BoardService {
	BoardDAO dao;
	

	public int write(BoardDTO boardDTO) {
		 SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  BoardDAO dao = new BoardDAO();
			  System.out.println("aa");
			  n = dao.write(session, boardDTO);
			  System.out.println(n);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;		
	}
	


	public int replyUpdate(BoardDTO parent) {
		 SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  BoardDAO dao = new BoardDAO();
			  System.out.println("aa");
			  n = dao.replyUpdate(session, parent);
			  System.out.println(n);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;
	}
	
	public int hit(String boardID) {
		 SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  BoardDAO dao = new BoardDAO();
			  System.out.println("aa");
			  n = dao.hit(session, boardID);
			  System.out.println(n);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;
		
	}
	
	
	public List<BoardDTO> getList() {
		 SqlSession session = MySqlSessionFactory.getSession();
		 List<BoardDTO> list = null; 
		 try {
			  BoardDAO dao = new BoardDAO();	  
			 list = dao.getList(session);
		  }finally {
			session.close();
		}
		  return list;
		
	}
	
	public BoardDTO getBoard(String boardID) {
		 SqlSession session = MySqlSessionFactory.getSession();
		 BoardDTO dto = new BoardDTO();
		 try {
			  BoardDAO dao = new BoardDAO();	  
			  dto = dao.getBoard(session, boardID);
		
		  }finally {
			session.close();
		}
		  return dto;
		
	}
	
	}
