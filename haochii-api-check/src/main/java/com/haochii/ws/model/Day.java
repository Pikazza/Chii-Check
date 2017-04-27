package com.haochii.ws.model;

public class Day {
    
    private String day= null;
    private String hours= null;
    
    public Day() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Day(String day, String hours) {
        super();
        this.day = day;
        this.hours = hours;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
    @Override
    public String toString() {
        return "Day [day=" + day + ", hours=" + hours + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((day == null) ? 0 : day.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Day other = (Day) obj;
        if (day == null) {
            if (other.day != null)
                return false;
        } else if (!day.equals(other.day))
            return false;
        return true;
    }
    
    
}
