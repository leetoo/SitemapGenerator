package com.uawebchallenge.common;

public enum ChangeFreq {
    ALWAYS, HOURLY, DAILY, WEEKLY, MONTHLY, YEARLY, NEVER;

    private String lowerCase;

    private ChangeFreq() {
        lowerCase = name().toLowerCase();
    }

    @Override
    public String toString() {
        return lowerCase;
    }
}
