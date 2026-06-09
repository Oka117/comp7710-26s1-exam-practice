// collected from
// https://gitlab.comp.anu.edu.au/comp1110/extra/comp1110-exam-2022s1/-/blob/master/src/comp1110/exam/Q7BoardGame.java
package hashing.Q1;

import java.util.Random;


/**
 * This class represents a BoardGame, which is uniquely identified by a combination of genre, name
 * and year published.
 */
public class BoardGame {

    public enum Genre {
        CARD, SOCIAL_DECEPTION, CHILDREN, COOPERATIVE, STRATEGY, CAMPAIGN, DECK_BUILDING,
        DUNGEON_CRAWLER, PARTY, DEXTERITY, EURO, AREA_CONTROL, CLASSIC
    }

    /**
     * The genre of a board game may be any value from the Genre enum
     */
    Genre genre;

    /**
     * The name of a board game is a String of ASCII characters
     */
    String name;

    /**
     * The year the game was published is any number from 2000 to 2022 inclusive
     */
    int year;

    public BoardGame(String name, Genre genre, int year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    /**
     * @return a hash code value for this board game. In implementing this method, you may *not* use
     * the default Java implementations in Object.hashCode() or Objects.hash().
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for(int i = 0; i < name.length(); i++){
            hash = 31 * hash + name.charAt(i);
        }
        hash += year * 31;
        for(int i = 0; i < genre.toString().length(); i++){
            hash = 31 * hash + genre.toString().charAt(i);
        }

        return hash; // FIXME complete this method
    }

    /**
     * @return true if other object is a Q7BoardGame and their fields are equal
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if(object == this) return true;
        if(object == null) return false;
        if(object instanceof BoardGame bg){
            return bg.genre.equals(genre) && bg.name.equals(name) && bg.year == year;
        }

        return false; // FIXME complete this method
    }

    @Override
    public String toString() {
        String g = null;
        if (genre != null) {
            g = genre.toString();
        }
        return name + ", " + g + ", " + year;
    }

    // DO NOT DELETE OR CALL THIS METHOD
    int passThroughHash() {
        return super.hashCode();
    }
}
