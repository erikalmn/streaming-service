package com.company;

import com.company.domain.Media;
import com.company.repositories.MediaRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMedia {
    private static Scanner sc = new Scanner(System.in);
    private static MediaRepository mediaRepository = new MediaRepository();
    private static boolean control = true;
    private static int menu = -1;

    public static void main(String[] args) {
        while(control) {
            optionsMenu();
            collectOptionsMenu();

            switch(menu) {
                case 1:
                    registerMedia();
                    break;
                case 2:
                    searchMedia();
                    break;
                case 3:
                    updateMedia();
                    break;
                case 4:
                    deleteMedia();
                    break;
                case 5:
                    exit();
                    break;
            }
        }
    }

    private static void collectOptionsMenu() {
        boolean assistant = true;
        while(assistant) {
            try {
                menu = sc.nextInt();
                sc.nextLine();
                assistant = false;
            } catch(InputMismatchException e) {
                System.out.println("Invalid value!");
                sc.nextLine();
            }
        }
    }

    private static void optionsMenu() {
        System.out.println("1 - Register");
        System.out.println("2 - Search");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");
        System.out.println("5 - Exit");
        System.out.println();
        System.out.print("Choose a menu alternative: ");
    }

    private static void deleteMedia() {
        System.out.println();
        System.out.println("Delete media");
        System.out.print("Enter media title: ");
        String title = sc.nextLine();
        mediaRepository.deleteByTitle(title);

        System.out.println("Click ENTER to go back...");
        sc.nextLine();
    }

    private static void updateMedia() {
        System.out.println();
        System.out.println("Update media");
        System.out.print("Enter media title: ");
        String titleUp = sc.nextLine();

        System.out.print("- Enter the new category: ");
        String categoryNew = sc.nextLine();

        System.out.print("- Enter the new title: ");
        String titleNew = sc.nextLine();

        System.out.print("- Enter the new year: ");
        String yearNew = sc.nextLine();

        System.out.print("- Enter the new director: ");
        String directorNew = sc.nextLine();

        System.out.print("- Enter the new actor: ");
        String actorNew = sc.nextLine();

        System.out.print("- Enter the new description: ");
        String descriptionNew = sc.nextLine();

        Media updateMedia = new Media(categoryNew, titleNew, yearNew, directorNew, actorNew, descriptionNew);
        mediaRepository.updateMedia(updateMedia, titleUp);

        System.out.println();
        System.out.println("Click ENTER to go back...");
        sc.nextLine();
    }

    private static void registerMedia() {
        System.out.println();
        System.out.println("Register media");

        System.out.print("- Enter the category: ");
        String category = sc.nextLine();

        System.out.print("- Enter the title: ");
        String title = sc.nextLine();

        System.out.print("- Enter the year: ");
        String year = sc.nextLine();

        System.out.print("- Enter the director: ");
        String director = sc.nextLine();

        System.out.print("- Enter the actor: ");
        String actor = sc.nextLine();

        System.out.print("- Enter the description: ");
        String description = sc.nextLine();

        Media newMedia = new Media(category, title, year, director, actor, description);
        mediaRepository.addMedia(newMedia);

        System.out.println();
        System.out.println("Click ENTER to go back...");
        sc.nextLine();
    }

    private static void searchMedia() {
        System.out.println();
        System.out.println("Search media");
        System.out.println("1 - By category");
        System.out.println("2 - By title");
        System.out.println("3 - By year");
        System.out.println("4 - By director");
        System.out.println("5 - By actor");
        System.out.println("6 - By description");
        System.out.println();
        System.out.print("Choose a search option: ");
        int N = -1;

        boolean assistant = true;
        while(assistant) {
            try {
                N = sc.nextInt();
                sc.nextLine();
                assistant = false;
            } catch(InputMismatchException e) {
                System.out.println("Invalid value!");
                sc.nextLine();
            }
        }

        switch(N) {
            case 1:
                System.out.print("Search by category: ");
                String category = sc.nextLine();

                List<Media> byCategory = mediaRepository.findByCategory(category);

                if(!byCategory.isEmpty()) {
                    for(Media media : byCategory) {
                        System.out.println(media);
                    }
                }
                System.out.println();
                System.out.println("Click ENTER to go back...");
                sc.nextLine();
                break;
            case 2:
                System.out.print("Search by title: ");
                String title = sc.nextLine();

                List<Media> byTitle = mediaRepository.findByTitle(title);

                if(!byTitle.isEmpty()) {
                    for(Media media : byTitle) {
                        System.out.println(media);
                    }
                }
                System.out.println();
                System.out.println("Click ENTER to go back...");
                sc.nextLine();
                break;
            case 3:
                System.out.print("Search by year: ");
                String year = sc.nextLine();

                List<Media> byYear = mediaRepository.findByYear(year);

                if(!byYear.isEmpty()) {
                    for(Media media : byYear) {
                        System.out.println(media);
                    }
                }
                System.out.println();
                System.out.println("Click ENTER to go back...");
                sc.nextLine();
                break;
            case 4:
                System.out.print("Search by director: ");
                String director = sc.nextLine();

                List<Media> byDirector = mediaRepository.findByDirector(director);

                if(!byDirector.isEmpty()) {
                    for(Media media : byDirector) {
                        System.out.println(media);
                    }
                }
                System.out.println();
                System.out.println("Click ENTER to go back...");
                sc.nextLine();
                break;
            case 5:
                System.out.print("Search by actor: ");
                String actor = sc.nextLine();

                List<Media> byActor = mediaRepository.findByActor(actor);

                if(!byActor.isEmpty()) {
                    for(Media media : byActor) {
                        System.out.println(media);
                    }
                }
                System.out.println();
                System.out.println("Click ENTER to go back...");
                sc.nextLine();
                break;
            case 6:
                System.out.print("Search by description: ");
                String description = sc.nextLine();

                List<Media> byDescription = mediaRepository.findByDescription(description);

                if(!byDescription.isEmpty()) {
                    for(Media media : byDescription) {
                        System.out.println(media);
                    }
                }
                System.out.println();
                System.out.println("Click ENTER to go back...");
                sc.nextLine();
                break;
        }
    }
    
    private static void exit() {
        System.out.println("\nShutting down system...");
        sc.close();
        MainMedia.control = false;
    }
}