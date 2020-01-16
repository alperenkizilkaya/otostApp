package com.example.otostapp;

import androidx.annotation.Nullable;

import java.util.Set;

public class User {
    private long id;
    private String name;
    private String eMail;
    private String password;
    private Sex sex;
    private int age;
    private String bio;
    private Set<MusicType> musicTypes;
    private Set<FilmGenre> filmGenres;

    public User(String name, String eMail, String password, Sex sex, int age,
                String bio, Set<FilmGenre> filmGenres, Set<MusicType> musicTypes)
    {
        this.name = name;
        this.eMail = eMail;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.bio = bio;
        this.musicTypes = musicTypes;
        this.filmGenres = filmGenres;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }

    public Set<MusicType> getMusicTypes() {
        return musicTypes;
    }

    public Set<FilmGenre> getFilmGenres() {
        return filmGenres;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setMusicTypes(Set<MusicType> musicTypes) {
        this.musicTypes = musicTypes;
    }

    public void setFilmGenres(Set<FilmGenre> filmGenres) {
        this.filmGenres = filmGenres;
    }
}
