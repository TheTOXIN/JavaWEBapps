package com.toxin.fullstack.mvc.bean;

import java.io.Serializable;

public class DBLog implements Serializable {

    private static final long serialVersionUID = 1L;
    private int IDLOG;
    private String LOGSTRING;

    public DBLog() {}

    public DBLog(int IDLOG, String LOGSTRING) {
        this.IDLOG = IDLOG;
        this.LOGSTRING = LOGSTRING;
    }

    public int getIDLOG() {
        return IDLOG;
    }

    public void setIDLOG(int IDLOG) {
        this.IDLOG = IDLOG;
    }

    public String getLOGSTRING() {
        return LOGSTRING;
    }

    public void setLOGSTRING(String LOGSTRING) {
        this.LOGSTRING = LOGSTRING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DBLog log = (DBLog) o;

        if (IDLOG != log.IDLOG) return false;
        return LOGSTRING != null ? LOGSTRING.equals(log.LOGSTRING) : log.LOGSTRING == null;
    }

    @Override
    public int hashCode() {
        int result = IDLOG;
        result = 31 * result + (LOGSTRING != null ? LOGSTRING.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DBLog{" +
            "IDLOG=" + IDLOG +
            ", LOGSTRING='" + LOGSTRING + '\'' +
            '}';
    }

}

