package bao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public List queryAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBGet.getConnection();
			String sql = "select * from stu";
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			List list = new ArrayList();
			Student student;
			while(rs.next()) {
				student = new Student();
				student.setStuId(rs.getString("stuId"));
				student.setStuName(rs.getString("stuName"));
				student.setStuSex(rs.getString("stuSex"));
				student.setStuAge(rs.getString("stuAge"));
				student.setStuWeight(rs.getString("stuWeight"));
				list.add(student);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBGet.closeResultSet(rs);
			DBGet.closePreparedStatement(ps);
			DBGet.closeConnection(conn);
		}
		return null;
	}
	
	//修改学生信息同步到数据库
	public boolean update(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBGet.getConnection();
			String sql = "update stu set stuName=?,stuSex=?,stuAge=?,stuWeight=? where stuID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,student.getStuName());
            ps.setString(2,student.getStuSex());
            ps.setString(3,student.getStuAge());
            ps.setString(4,student.getStuWeight());
            ps.setString(5,student.getStuId());                
            int num = ps.executeUpdate();
            if(num > 0)
            	return true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBGet.closePreparedStatement(ps);
			DBGet.closeConnection(conn);
		}
		return false;
	}
	
	//修改学生信息同步到数据库
		public boolean insert(Student student) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = DBGet.getConnection();
				//String sql = "insert into stu values('"+student.getStuId()+"','"+student.getStuName()+"','"+student.getStuSex()+"','"+student.getStuAge()+"','"+student.getStuWeight()+"')";
				String sql = "insert into stu values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1,student.getStuId());
				ps.setString(2,student.getStuName());
	            ps.setString(3,student.getStuSex());
	            ps.setString(4,student.getStuAge());
	            ps.setString(5,student.getStuWeight());
				int num = ps.executeUpdate();
	            if(num > 0)
	            	return true;
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBGet.closePreparedStatement(ps);
				DBGet.closeConnection(conn);
			}
			return false;
		}
		
		//修改学生信息同步到数据库
		public boolean delete(Student student) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = DBGet.getConnection();
				String sql="delete  from stu where stuID=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, student.getStuId());
				int num = ps.executeUpdate();
			    if(num > 0)
			    	return true;
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBGet.closePreparedStatement(ps);
				DBGet.closeConnection(conn);
			}
			return false;
		}
}
