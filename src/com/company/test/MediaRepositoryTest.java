package com.company.test;

import com.company.domain.Media;
import com.company.repositories.MediaRepository;

public class MediaRepositoryTest {
    public static void main(String[] args) {
        MediaRepository mediaRepository = new MediaRepository();

        Media media1 = new Media("Series", "Stranger Things", "2016", "Shawn Levy", "Millie Bobby Brown", "Fiction");
        Media media2 = new Media("Documentary", "Our Planet", "2020", "David Attenborough", "Penélope Cruz", "Nature");
        Media media3 = new Media("Movie", "Like Stars on Earth", "2007", "Aamir Khan", "Darsheel Safary", "Tragedy");
        Media media4 = new Media("Movie", "Mother", "2017", "Darren Aronofsky", "Jennifer Lawrence", "Thriller");

        //Register
        mediaRepository.addMedia(media1);
        mediaRepository.addMedia(media2);
        mediaRepository.addMedia(media3);
        mediaRepository.addMedia(media4);

        //Search
        mediaRepository.findByCategory("Movie");
        mediaRepository.findByTitle("Stranger Things");
        mediaRepository.findByYear("2017");
        mediaRepository.findByDirector("David Attenborough");

        //Delete
        mediaRepository.deleteByTitle("Like Stars on Earth");
    }
}