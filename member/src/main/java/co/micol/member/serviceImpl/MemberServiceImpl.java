package co.micol.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.member.command.DAO;
import co.micol.member.service.MemberService;
import co.micol.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	// TODO DB 작업
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO 전체 회원 목록
		List<MemberVO> members = new ArrayList<>();
		MemberVO vo;
		
		conn = DAO.getConnection();
		String sql = "select * from member";		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
				members.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return members;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		conn = DAO.getConnection();
		String sql = "select * from member where id = ?";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
			}
			System.out.println(rs + "건 츨력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		conn = DAO.getConnection();
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getHobby());
			result = psmt.executeUpdate();
			System.out.println(result + "건 생성입력!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		
		conn = DAO.getConnection();
		String sql = "delete from member where id = ?";
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		conn = DAO.getConnection();
		String sql = "update member "
				+ "set password = ?, age = ?, hobby = ? "
				+ "where id = ?";
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPassword());
			psmt.setInt(2, vo.getAge());
			psmt.setString(3, vo.getHobby());
			psmt.setString(4, vo.getId());
			result = psmt.executeUpdate();
			System.out.println(result + "건 삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return result;
	}

	private void disconnect() {
		// TODO 연결 종료를 위해
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
