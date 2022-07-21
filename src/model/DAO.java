package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_insert="INSERT INTO MELONTOPRANK VALUES((SELECT NVL(MAX(NUM),0)+1 FROM MELONTOPRANK),?,?,?,?,?,?,?)";
	public boolean insert(VO vo) {
		conn=JDBCUtil.connect();
		try {         
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getAlbum());
			pstmt.setString(4, vo.getDay());
			pstmt.setString(5, vo.getGenre());
			pstmt.setString(6, vo.getPublisher());
			pstmt.setString(7, vo.getAgency());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
}
