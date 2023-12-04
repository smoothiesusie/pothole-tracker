package com.techelevator.dao;

import com.techelevator.model.Pothole;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface PotholeDao {

        Pothole createNewPothole(int userId, double latitude, double longitude, int severity, String status);

        List<Pothole> getAllPotholes();






}
