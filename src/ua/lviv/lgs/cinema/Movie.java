package ua.lviv.lgs.cinema;

import java.util.Objects;
import java.util.Scanner;

public class Movie {
    private String title;
    private Time duration;

    public Movie(String title, Time duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public static Movie inputMovie() throws IllegalTimeFormatException {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter title of the movie: ");
        String title = scanner.nextLine();
        if (title.equals("")) {
            System.err.println("The title of the movie was entered incorrectly!");
            title = "Some unnamed movie";
        }

        System.out.print("Film duration - ");
        Time duration = Time.inputTime();

        return new Movie(title, duration);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (title == "Some unnamed movie" || title == "Maintenance break") {
            return title + ", duration: " + duration.toLiteral();
        } else
            return "Movie " + title + ", duration: " + duration.toLiteral();
    }
}
