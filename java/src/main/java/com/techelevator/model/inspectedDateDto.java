package com.techelevator.model;

import java.util.Date;

public class inspectedDateDto {
   private  Date inspectedDate;
    private int inspectedDatePK;

    private int potholeIdFK;

    public inspectedDateDto() {
    }

    public inspectedDateDto(int inspectedDatePK, int potholeIdFK) {

        this.inspectedDatePK = inspectedDatePK;
        this.potholeIdFK = potholeIdFK;
    }

    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public int getInspectedDatePK() {
        return inspectedDatePK;
    }

    public void setInspectedDatePK(int inspectedDatePK) {
        this.inspectedDatePK = inspectedDatePK;
    }

    public int getPotholeIdFK() {
        return potholeIdFK;
    }

    public void setPotholeIdFK(int potholeIdFK) {
        this.potholeIdFK = potholeIdFK;
    }
}
