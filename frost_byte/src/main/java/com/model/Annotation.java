package com.model;

public class Annotation {
    private Font font;
    private String comment;

    public Annotation(Font font, String comment) {
        this.font = font;
        this.comment = comment;
    }

    private Font setFont(Font font) {
        this.font = font;
        return this.font;
    }

    private String setComment(String comment) {
        this.comment = comment;
        return this.comment;
    }

    private Font getFont() {
        return this.font;
    }

    private String getComment() {
        return this.comment;
    }
}
