package model;

import java.util.Date;

public class AttendanceList {
    int id;
    int classId;
    int userId;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AttendanceList(int id, int classId, int userId, Date date) {
        this.id = id;
        this.classId = classId;
        this.userId = userId;
        this.date = date;
    }
}

