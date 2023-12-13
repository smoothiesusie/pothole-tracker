package com.techelevator.model;

import java.util.Date;

public class inspectedDateDto {
   private  Date inspectedDate;
    private int inspectedDatePK;

    private int inspectedFk;

    public inspectedDateDto() {
    }

    public inspectedDateDto(Date inspectedDate, int inspectedDatePK, int inspectedFk) {
        this.inspectedDate = inspectedDate;
        this.inspectedDatePK = inspectedDatePK;
        this.inspectedFk = inspectedFk;
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

    public int getInspectedFk() {
        return inspectedFk;
    }

    public void setInspectedFk(int inspectedFk) {
        this.inspectedFk = inspectedFk;
    }
}
