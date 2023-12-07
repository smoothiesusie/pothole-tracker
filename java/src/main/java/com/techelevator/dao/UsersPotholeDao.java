package com.techelevator.dao;

import com.techelevator.model.UsersPotholeDto;

import java.util.List;

public interface UsersPotholeDao {
    UsersPotholeDto getUserByPotholeId(int id);

    List<UsersPotholeDto> getAllUsersPotholeList();
}
