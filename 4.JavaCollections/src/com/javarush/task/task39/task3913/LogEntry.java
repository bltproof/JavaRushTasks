package com.javarush.task.task39.task3913;

public class LogEntry {
    private String ip;
    private String user;
    private Long date;
    private Event event;
    private Integer taskNumber;
    private Status status;

    public LogEntry(String ip, String user, Long date, Event event, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}