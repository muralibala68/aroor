package org.bala.scratch;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair pair = (Pair) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        if (second != null ? !second.equals(pair.second) : pair.second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static long getRandomNumber() {
        System.out.println("<********************* RANDOM *******>");
        return Math.round(Math.random() * 10);
    }

}
