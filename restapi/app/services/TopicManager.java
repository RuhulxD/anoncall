package services;

import models.Topics;

import java.util.ArrayList;
import java.util.List;

public class TopicManager {
    List<Topics> topicsList;

    private static class Holder{
        private static TopicManager manager = new TopicManager();
    }

    private TopicManager(){
        topicsList = getSomeTopics();
    }

    public static TopicManager getInstance(){
        return Holder.manager;
    }

    public List<Topics> getTopics(){
        return topicsList;
    }

    public Topics addTopics(Topics topic){
        topic.setId(System.currentTimeMillis());
        topicsList.add(topic);
        return topic;
    }

    public boolean deleteTopics(long id){
        try {
            int idx = -1;
            for (int i = 0; i < topicsList.size(); i++) {
                if (id == topicsList.get(i).getId()) {
                    idx = i;
                    break;
                }
            }
            if (idx >= 0) {
                topicsList.remove(idx);
            }
        }catch (Exception ex){

        }
        return true;
    }

    public List<Topics> getSomeTopics(){
        List<Topics> list = new ArrayList<>();

        Topics t = new Topics(System.currentTimeMillis(), "Improve English!", null, "Improve your English skill by talking to each other.");
        list.add(t);
        t = new Topics(System.currentTimeMillis(), "Feeling bored!", null, "Ignore boredness just by talking to strangers.");
        list.add(t);
        t = new Topics(System.currentTimeMillis(), "Random Thought!", null, "Just keep talking....");
        list.add(t);
        t = new Topics(System.currentTimeMillis(), "Politics!", null, "Love politics? Lets talk!");
        list.add(t);
        return list;
    }




}
