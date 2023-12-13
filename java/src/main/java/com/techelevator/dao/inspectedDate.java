package com.techelevator.dao;

import com.techelevator.model.inspectedDateDto;

import java.util.Date;

public interface inspectedDate {

     inspectedDateDto addNewInspectedDate(Date dateInspected, int inspectedFK);
}
