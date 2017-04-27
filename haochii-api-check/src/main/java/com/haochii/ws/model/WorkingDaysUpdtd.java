package com.haochii.ws.model;

import java.util.ArrayList;
import java.util.List;

public class WorkingDaysUpdtd {
    
    private String daysId = null;
    private List<Day> listOfDays = new ArrayList<Day>();
    
    public String getDaysId() {
        return daysId;
    }
    public void setDaysId(String daysId) {
        this.daysId = daysId;
    }
    public List<Day> getListOfDays() {
        return listOfDays;
    }
    public void setListOfDays(List<Day> listOfDays) {
        this.listOfDays = listOfDays;
    }
    @Override
    public String toString() {
        return "WorkingDaysUpdtd [daysId=" + daysId + ", listOfDays=" + listOfDays + "]";
    }
}
