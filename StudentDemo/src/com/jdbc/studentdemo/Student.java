package com.jdbc.studentdemo;

/**
 * Created by Jax on 2016/11/5.
 */
public class Student {

    private String ID;

    private String NAME;

    private String PHONENUMBER;

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", NAME=" + NAME +
                ", PHONENUMBER=" + PHONENUMBER +
                '}';
    }

    public String getID() {
        return ID;
    }

    public String getPHONENUMBER() {
        return PHONENUMBER;
    }

    public String getNAME() {
        return NAME;
    }

    public void setPHONENUMBER(String PHONENUMBER) {

        this.PHONENUMBER = PHONENUMBER;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
