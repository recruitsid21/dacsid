
package com.example.studentCRUDapp.dao;

import com.example.studentCRUDapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private DataSource dataSource;

    /* CREATE */
    public void save(Student s) {
        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    /* READ ALL */
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection c = dataSource.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                list.add(s);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    /* READ ONE */
    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                return s;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    /* UPDATE */
    public void update(Student s) {
        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    /* DELETE */
    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
