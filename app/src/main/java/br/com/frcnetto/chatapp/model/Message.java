package br.com.frcnetto.chatapp.model;

/**
 * Created by frcnetto on 21/07/17.
 */

public class Message {
    private int    id;
    private String text;

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
