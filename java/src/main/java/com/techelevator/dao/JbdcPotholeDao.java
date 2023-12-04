package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pothole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class JbdcPotholeDao implements PotholeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JbdcPotholeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Pothole createNewPothole(int userId, double latitude, double longitude, int severity, String status) {
        String insertPotholeSql = "INSERT INTO public.potholes(userid, latitude, longitude, severity, status, reportedat) " +
                "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP);";
        Pothole newPothole = new Pothole();
        newPothole.setUserId(userId);
        newPothole.setLatitude(latitude);
        newPothole.setLongitude(longitude);
        newPothole.setSeverity(severity);
        newPothole.setStatus(status);
        newPothole.setReportedAt(new Date());
        jdbcTemplate.update(insertPotholeSql, newPothole.getUserId(), newPothole.getLatitude(), newPothole.getLongitude(), newPothole.getSeverity(), newPothole.getStatus());
        return newPothole;
    }

    @Override
    public List<Pothole> getAllPotholes() {
        List<Pothole> potholes = new ArrayList<>();

        String sql = "SELECT potholeid, userid, latitude, longitude, severity, status, reportedat FROM potholes";


        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                Pothole pothole = mapRowToPotholes(results);
                potholes.add(pothole);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return potholes;
    }


    private Pothole mapRowToPotholes(SqlRowSet rowSet) {
        Pothole pothole = new Pothole();

        pothole.setPotholeId(rowSet.getInt("potholeid"));
        pothole.setUserId(rowSet.getInt("userid"));
        pothole.setLatitude(rowSet.getDouble("latitude"));
        pothole.setLongitude(rowSet.getDouble("longitude"));
        pothole.setSeverity(rowSet.getInt("severity"));
        pothole.setStatus(rowSet.getString("status"));
        pothole.setReportedAt(rowSet.getDate("reportedat"));

        return pothole;


    }


}
