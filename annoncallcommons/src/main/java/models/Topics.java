package models;

public class Topics {
    Long id;
    String title;
    String thumb;
    String descrpition;

    public Topics() {
        id = System.currentTimeMillis();
    }

    public Topics(Long id, String title, String thumb, String descrpition) {
        this.id = id;
        this.title = title;
        this.thumb = thumb;
        this.descrpition = descrpition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumb='" + thumb + '\'' +
                ", descrpition='" + descrpition + '\'' +
                '}';
    }
}
