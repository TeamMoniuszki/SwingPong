package com.company;

public class Player {
    private Platform platform;
    private Score score;
    private String nickname;

    public Player(Platform platform, Score score, String nickname){
        this.platform = platform;
        this.score = score;
        this.nickname = nickname;
    }

    public Platform getPlatform(){
        return this.platform;
    }

    public Score getScore(){
        return this.score;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setPlatform(Platform platform){
        this.platform = platform;
    }

    public void setScore(Score score){
        this.score = score;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static Player createPlayer(Platform platform, Score score, String nickname){
        return new Player(platform, score, nickname);
    }

}
