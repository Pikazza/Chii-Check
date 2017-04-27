package com.haochii.ws.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class WorkingDays {
    @Id
    private String daysId = null;
    private String minAvg= null;
    private String maxavg= null;
    private String minTotalPerWeek= null;
    private String maxTotalPerWeek= null;
    private List<Day> listOfDays = new ArrayList<Day>();
    public String getDaysId() {
        return daysId;
    }
    public String getMinAvg() {
        return minAvg;
    }
    public String getMaxavg() {
        return maxavg;
    }
    public String getMinTotalPerWeek() {
        return minTotalPerWeek;
    }
    public String getMaxTotalPerWeek() {
        return maxTotalPerWeek;
    }
    public List<Day> getListOfDays() {
        return listOfDays;
    }
    public void setDaysId(String daysId) {
        this.daysId = daysId;
    }
    public void setMinAvg(String minAvg) {
        this.minAvg = minAvg;
    }
    public void setMaxavg(String maxavg) {
        this.maxavg = maxavg;
    }
    public void setMinTotalPerWeek(String minTotalPerWeek) {
        this.minTotalPerWeek = minTotalPerWeek;
    }
    public void setMaxTotalPerWeek(String maxTotalPerWeek) {
        this.maxTotalPerWeek = maxTotalPerWeek;
    }
    public void setListOfDays(List<Day> listOfDays) {
        this.listOfDays = listOfDays;
    }
    @Override
    public String toString() {
        return "WorkingDays [daysId=" + daysId + ", minAvg=" + minAvg + ", maxavg=" + maxavg + ", minTotalPerWeek=" + minTotalPerWeek
                + ", maxTotalPerWeek=" + maxTotalPerWeek + ", listOfDays=" + listOfDays + "]";
    }
    
}
