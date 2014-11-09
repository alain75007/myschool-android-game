package com.myschool.game.core;

/**
 * Cette classe représente un personnage générique
 */
public class Character {
    private static int playerCount;
    private String name;
    private int livePoint;

    public Character(String name) {
        this.setName(name);
        playerCount++;
    }

    public Character(String name, int livePoint) {
        this.setName(name);
        this.livePoint = livePoint;
    }

    public static int getPlayerCount() {
        return Character.playerCount;
    }

    public void setLiveScore(int liveScore) {
        this.setLivePoint(liveScore);
    }

    public void getLiveScore() {
        this.getLivePoint();
    }

    public void disBonjour(Character character) {
        dit("Bonjour " + character.getName() + "!");
    }

    public void disBonjour() {
        dit(": Bonjour tout le monde!");
    }

    public int getLivePoint() {
        return livePoint;
    }

    public void setLivePoint(int livePoint) {
        this.livePoint = livePoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void dit(String string) {
        System.out.println(this.getName() + " dit: " + string);
    }
}
