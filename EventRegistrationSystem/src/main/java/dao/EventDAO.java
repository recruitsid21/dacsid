package dao;



import model.EventRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDAO {

    @Autowired
    private DataSource dataSource;

    public void save(EventRegistration reg) {
        String sql = "INSERT INTO registrations (name, email, event_name) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, reg.getName());
            stmt.setString(2, reg.getEmail());
            stmt.setString(3, reg.getEventName());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<EventRegistration> getAll() {
        List<EventRegistration> list = new ArrayList<>();
        String sql = "SELECT * FROM registrations";
        try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EventRegistration reg = new EventRegistration();
                reg.setId(rs.getInt("id"));
                reg.setName(rs.getString("name"));
                reg.setEmail(rs.getString("email"));
                reg.setEventName(rs.getString("event_name"));
                list.add(reg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
