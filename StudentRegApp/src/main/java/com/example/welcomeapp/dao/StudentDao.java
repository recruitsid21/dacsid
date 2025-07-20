package com.example.welcomeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.welcomeapp.model.Student;

@Repository
public class StudentDao {
	@Autowired
	private DataSource dataSource;
	
	//save student to DB
	public void save(Student student) throws SQLException {
		String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";  // ✅ 3 placeholders

		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1,student.getName());
			ps.setString(2,student.getEmail());
			ps.setString(3,student.getCourse());
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		

	}
	//Get all student from DB
	public List<Student> findAll() throws SQLException{
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM students";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				list.add(s);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		
		
	}
	
	
	
	

}
