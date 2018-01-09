package models;

import javafx.util.Pair;

public class CallInformation {
    Pair<Users, Users> users;
    int rating;
    CallType callType;
    String topicid;
    int duration;

    public CallInformation() {
    }

    public Pair<Users, Users> getUsers() {
        return users;
    }

    public void setUsers(Pair<Users, Users> users) {
        this.users = users;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
