package org.bala.scratch;

import org.pojomatic.Pojomatic;

/**
 * User: murali
 * Time: 6/30/12 10:55 AM
 */
public class Pair<FIRST_TYPE, SECOND_TYPE> {

    private final FIRST_TYPE first;
    private final SECOND_TYPE second;

    public Pair(final FIRST_TYPE first,
                final SECOND_TYPE second) {
        this.first = first;
        this.second = second;
    }

    public FIRST_TYPE first() {
        return first;
    }
    public SECOND_TYPE second() {
        return second;
    }

    @Override
    public boolean equals(Object rhs) {
        return Pojomatic.equals(this,rhs);
    }

    @Override
    public int hashCode() {
        return Pojomatic.hashCode(this);
    }

    @Override
    public String toString() {
        return Pojomatic.toString(this);
    }

    public static long getRandomNumber() {
        System.out.println("<********************* RANDOM *******>");
        return Math.round(Math.random() * 10);
    }

}
