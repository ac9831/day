package project.hackerton.day;


import java.io.Serializable;

public class Diary implements Serializable {
    String date;
    String sentence;

    public Diary(String date, String sentence) {
        this.date = date;
        this.sentence = sentence;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
