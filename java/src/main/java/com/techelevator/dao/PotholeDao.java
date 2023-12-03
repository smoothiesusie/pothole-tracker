package com.techelevator.dao;

public interface PotholeDao {

    PotholeDao createNewPothole(int userId, double latitude, double longitude,
                                int severity, String status);

    PotholeDao createNewPothole();
}
