package com.company.domain;

public class Media {
    private final String category;
    private String title;
    private String year;
    private String director;
    private String actor;
    private String description;

    public Media(String category, String title, String year, String director, String actor, String description) {
        this.category = category;
        this.title = title;
        this.year = year;
        this.director = director;
        this.actor = actor;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Media {" +
                "category = '" + category + '\'' +
                ", title = '" + title + '\'' +
                ", year = '" + year + '\'' +
                ", description = '" + description + '\'' +
                '}';
    }
}