package com.model;

public class Annotation {
    private Font font;
    private String comment;

    public Annotation(Font font, String comment) {
        this.font = font;
        this.comment = comment;
    }

    public Font setFont(Font font) {
        this.font = font;
        return this.font;
    }

    public String setComment(String comment) {
        this.comment = comment;
        return this.comment;
    }

    public Font getFont() {
        return this.font;
    }

    public String getComment() {
        return this.comment;
    }
}
