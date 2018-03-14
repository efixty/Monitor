package com.beans;

public class Musician {

    private final long id;
    private final String text;

    public Musician(long id, String text) {
        this.id = id;
        this.text= text;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return text;
    }

}
