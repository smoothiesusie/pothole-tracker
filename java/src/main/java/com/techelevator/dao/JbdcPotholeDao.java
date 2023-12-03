package com.techelevator.dao;

import com.techelevator.model.Pothole;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JbdcPotholeDao implements PotholeDao {

    private final JdbcTemplate jbdcTemplate;

    public JbdcPotholeDao(JdbcTemplate jbdcTemplate) {
        this.jbdcTemplate = jbdcTemplate;
    }

    @Override
    public Pothole createNewPothole(int userId, double latitude, double longitude, int severity, String status) {
        Pothole newPothole = null;
        String insertPotholeSql = "INSERT INTO public.potholes(\n" +
                "\tpotholeid, userid, latitude, longitude, severity, status, reportedat)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?);";
        jbdcTemplate.update();
        return null;
    }

    @Override
    public Pothole createNewPothole() {
        return null;
    }

    //@Override
//    public User createUser(RegisterUserDto user) {
//        User newUser = null;
//        String insertUserSql = "INSERT INTO users (username, password_hash, role) values (?, ?, ?) RETURNING user_id";
//        String password_hash = new BCryptPasswordEncoder().encode(user.getPassword());
//        String ssRole = user.getRole().toUpperCase().startsWith("ROLE_") ? user.getRole().toUpperCase() : "ROLE_" + user.getRole().toUpperCase();
//        try {
//            int newUserId = jdbcTemplate.queryForObject(insertUserSql, int.class, user.getUsername(), password_hash, ssRole);
//            newUser = getUserById(newUserId);
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
//        return newUser;
//    }

    private Pothole mapRowToPotholes(SqlRowSet rowSet) {
        Pothole
    }
}
