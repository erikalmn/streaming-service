package com.company.repositories;

import com.company.domain.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MediaRepository {
    private List<Media> mediaDataBase = new ArrayList<>();

    public MediaRepository() {
        movieBase();
    }

    public boolean addMedia(Media newMedia) {
        boolean result = mediaDataBase.add(newMedia);
        if(result) {
            System.out.println("\nMedia successfully added!");
            return result;
        }
        System.out.println("\nError! Media not added!");
        return false;
    }

    //Research
    public Media otherServiceTitle(String title) {
        for(Media media : mediaDataBase) {
            if(title.equalsIgnoreCase(media.getTitle())) {
                System.out.println("\nSuccessfully!");
                return media;
            }
        }
        System.out.println("\nNot found! Try again...");
        return null;
    }

    public List<Media> findByTitle(String title) {
        title = title.toLowerCase();

        List<Media> effect = new ArrayList<>();
        for(Media media : mediaDataBase) {
            String titleMedia = media.getTitle().toLowerCase();
            if(titleMedia.contains(title)) {
                effect.add(media);
            }
        }
        if(effect.isEmpty()) {
            System.out.println("\nMedia not found!");
            return new ArrayList<>();
        }
        System.out.println("\nMedia found!");
        return effect;
    }

    public List<Media> findByCategory(String category) {
        category = category.toLowerCase();

        List<Media> effect = new ArrayList<>();
        for(Media media : mediaDataBase) {
            String categoryMedia = media.getCategory().toLowerCase();
            if(categoryMedia.contains(category)) {
                effect.add(media);
            }
        }
        if(effect.isEmpty()) {
            System.out.println("\nMedia not found!");
            return new ArrayList<>();
        }
        System.out.println("\nMedia found!");
        return effect;
    }

    public List<Media> findByYear(String year) {
        year = year.toLowerCase();

        List<Media> effect = new ArrayList<>();
        for(Media media : mediaDataBase) {
            String yearMedia = media.getYear().toLowerCase();
            if(yearMedia.contains(year)) {
                effect.add(media);
            }
        }
        if(effect.isEmpty()) {
            System.out.println("\nMedia not found!");
            return new ArrayList<>();
        }
        System.out.println("\nMedia found!");
        return effect;
    }

    public List<Media> findByDirector(String director) {
        director = director.toLowerCase();

        List<Media> effect = new ArrayList<>();
        for(Media media : mediaDataBase) {
            String directorMedia = media.getDirector().toLowerCase();
            if(directorMedia.contains(director)) {
                effect.add(media);
            }
        }
        if(effect.isEmpty()) {
            System.out.println("\nMedia not found!");
            return new ArrayList<>();
        }
        System.out.println("\nMedia found!");
        return effect;
    }

    public List<Media> findByActor(String actor) {
        actor = actor.toLowerCase();

        List<Media> effect = new ArrayList<>();
        for(Media media : mediaDataBase) {
            String actorMedia = media.getActor().toLowerCase();
            if(actorMedia.contains(actor)) {
                effect.add(media);
            }
        }
        if(effect.isEmpty()) {
            System.out.println("\nMedia not found!");
            return new ArrayList<>();
        }
        System.out.println("\nMedia found!");
        return effect;
    }

    public List<Media> findByDescription(String description) {
        description = description.toLowerCase();

        List<Media> effect = new ArrayList<>();
        for(Media media : mediaDataBase) {
            String descriptionMedia = media.getDescription().toLowerCase();
            if(descriptionMedia.contains(description)) {
                effect.add(media);
            }
        }
        if(effect.isEmpty()) {
            System.out.println("\nMedia not found!");
            return new ArrayList<>();
        }
        System.out.println("\nMedia found!");
        return effect;
    }

    //Update
    public boolean updateMedia(Media mediaUpdated, String title) {
        Media mediaCurrent = otherServiceTitle(title);
        if(Objects.isNull(mediaCurrent)) {
            System.out.println("Media not found for update!");
            return false;
        }
        String newTitle = mediaUpdated.getTitle();
        String newYear = mediaUpdated.getYear();
        String newDirector = mediaUpdated.getDirector();
        String newActor = mediaUpdated.getActor();
        String newDescription = mediaUpdated.getDescription();

        if(isValidString(newTitle)) {
            mediaCurrent.setTitle(newTitle);
        }
        if(isValidString(newYear)) {
            mediaCurrent.setYear(newYear);
        }
        if(isValidString(newDirector)) {
            mediaCurrent.setDirector(newDirector);
        }
        if(isValidString(newActor)) {
            mediaCurrent.setActor(newActor);
        }
        if(isValidString(newDescription)) {
            mediaCurrent.setDescription(newDescription);
        }
        System.out.println("Media updated successfully!");
        return true;
    }

    //Delete
    public boolean deleteByTitle(String title) {
        Media media = otherServiceTitle(title);
        return mediaDataBase.remove(media);
    }

    private void movieBase() {
        Media media1 = new Media("Movie", "10 Things I Hate About You", "1999", "Gil Junger", "Julia Stiles", "Romance/Comedy");
        Media media2 = new Media("Movie", "The Orphanage", "2007", "J. A. Bayona", "Édgar Vivar", "Thriller");
        Media media3 = new Media("Movie", "Like Stars on Earth", "2007", "Aamir Khan", "Darsheel Safary", "Tragedy");
        Media media4 = new Media("Movie", "Mother", "2017", "Darren Aronofsky", "Jennifer Lawrence", "Thriller");

        mediaDataBase.add(media1);
        mediaDataBase.add(media2);
        mediaDataBase.add(media3);
        mediaDataBase.add(media4);
    }

    private boolean isValidString(String value) {
        return value != null && !value.isBlank();
    }
}