package com.example.android.assignment09app;

import java.util.Date;

/**
 * Created by Android on 11/1/2017.
 */

public class Member {
    private String stageName;
    private String realName;
    private String birthDate;
    private int age;
    private int photoID;
	private int soloSong;
    private String soloSongTitle;
    private String description;

    public Member(String stageName, String realName, String birthDate, int age, int photoID, int soloSong, String soloSongTitle, String description) {
        this.stageName = stageName;
        this.realName = realName;
        this.birthDate = birthDate;
        this.age = age;
        this.photoID = photoID;
		this.soloSong = soloSong;
        this.soloSongTitle = soloSongTitle;
        this.description = description;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSoloSongTitle() {
        return soloSongTitle;
    }

    public void setSoloSongTitle(String soloSongTitle) {
        this.soloSongTitle = soloSongTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoID() {
        return photoID;
    }
	
	public int getSoloSong(){
		return soloSong;
	}

}
