package com.techelevator.dao;

import com.techelevator.model.Pothole;
import com.techelevator.model.inspectedDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class jdbcInspectedDateDao implements inspectedDate {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public jdbcInspectedDateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public inspectedDateDto addNewInspectedDate(Date dateInspected) {
        String insertIntoInspections = "INSERT INTO public.inspections(\n" +
                "\tdateinspected)\n" +
                "\tVALUES (?);";
        jdbcTemplate.update(insertIntoInspections, dateInspected);

        inspectedDateDto newInspection = new inspectedDateDto();
        newInspection.setInspectedDate(dateInspected);
//        newInspection.setPotholeIdFK(inspectedFK);

        return newInspection;
    }

    private inspectedDateDto mapRowToInspectedDateDto(SqlRowSet rowSet) {
        inspectedDateDto inspectedDateDto = new inspectedDateDto();

        inspectedDateDto.setInspectedDate(rowSet.getDate("dateinspected"));
//        inspectedDateDto.setPotholeIdFK(rowSet.getInt("inspectedFK"));

        return inspectedDateDto;
    }
}

