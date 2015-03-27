package com.uawebchallenge.common;

import com.uawebchallenge.exceptions.InvalidPriorityException;

import java.util.Date;

public class WebPage {
    private final String loc;
    private final Date lastMod;
    private final ChangeFreq changeFreq;
    private final Double priority;

    private WebPage(Builder builder) {
        this.loc = builder.loc;
        this.lastMod = builder.lastMod;
        this.changeFreq = builder.changeFreq;
        this.priority = builder.priority;
    }

    public String getLoc() {
        return loc;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public ChangeFreq getChangeFreq() {
        return changeFreq;
    }

    public Double getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebPage webPage = (WebPage) o;

        if (changeFreq != webPage.changeFreq) return false;
        if (lastMod != null ? !lastMod.equals(webPage.lastMod) : webPage.lastMod != null) return false;
        if (loc != null ? !loc.equals(webPage.loc) : webPage.loc != null) return false;
        if (priority != null ? !priority.equals(webPage.priority) : webPage.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loc != null ? loc.hashCode() : 0;
        result = 31 * result + (lastMod != null ? lastMod.hashCode() : 0);
        result = 31 * result + (changeFreq != null ? changeFreq.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    public static class Builder{
        private String loc;
        private Date lastMod;
        private ChangeFreq changeFreq;
        private Double priority;

        public Builder(){

        }

        public Builder(WebPage webPage){
            this.loc = webPage.loc;
            this.lastMod = webPage.lastMod;
            this.changeFreq = webPage.changeFreq;
            this.priority = webPage.priority;
        }

        public Builder loc(String loc){
            this.loc = loc;
            return this;
        }

        public Builder lastMod(Date lastMod){
            this.lastMod = lastMod;
            return this;
        }

        public Builder changeFreq(ChangeFreq changeFreq){
            this.changeFreq = changeFreq;
            return this;
        }

        public Builder priority(Double priority){
            if(priority < 0.0 || priority > 1.0){
                throw new InvalidPriorityException("Priority should be between 0.0 and 1.0");
            }
            this.priority = priority;
            return this;
        }

        public WebPage builder(){
            return new WebPage(this);
        }
    }
}
