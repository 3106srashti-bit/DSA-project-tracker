public class Question {

    private String name;
    private String topic;
    private String difficulty;
    private String platform;

    public Question(String name, String topic, String difficulty, String platform) {
        this.name = name;
        this.topic = topic;
        this.difficulty = difficulty;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getPlatform() {
        return platform;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return name + " | " + topic + " | " + difficulty + " | " + platform;
    }
}