package org.bala.scratch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
    private static final Logger LOG = LoggerFactory.getLogger(Hello.class);

    final Pair<String,String> pair;

    public Hello(Pair<String, String> pair) {
        this.pair = pair;
    }

    public void sayHelloToThePair() {
        long times = getRandomNumber();
        LOG.info("Hello to " + pair.first() + ", " + times + " times");
        LOG.info("Hello to " + pair.second() + ", " + times + " times");
    }

    public long getRandomNumber() {
        return Pair.getRandomNumber();
    }

    public static void main(String[] args) {
        LOG.info("Hello");

        Pair<String,String> pair = new Pair<String, String>("Bala","Suba");
        LOG.info("Pair: " + pair);

        Hello hello = new Hello(pair);
        hello.sayHelloToThePair();

    }
}
