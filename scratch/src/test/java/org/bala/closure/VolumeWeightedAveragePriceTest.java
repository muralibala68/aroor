package org.bala.closure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bala.md.Trade;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VolumeWeightedAveragePriceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VolumeWeightedAveragePriceTest.class);   

    public static void main(String[] args) {
        final List<Trade> trades = setupTrades();
        final VolumeWeightedAveragePrice vwap = new VolumeWeightedAveragePrice(trades);
        vwap.printAllTrades();
        vwap.printAllTradeValues();
        Optional<Double> vwaprice = vwap.calculate();
        vwaprice.ifPresent(System.out::println);
        vwaprice.ifPresent(p -> LOGGER.info("VWAP: " + p));
        //trades.forEach(System.out::println);
        //trades.forEach(t -> LOGGER.info(t.toString()));
        trades.stream().map(Trade::toString).forEach(LOGGER::info);
    }

    private static List<Trade> setupTrades() {
        final List<Trade> trades = new ArrayList<>();
        trades.add(new Trade("I1",   0,   0,   System.currentTimeMillis() - 6000));
        trades.add(new Trade("I1",  11, 100.5, System.currentTimeMillis() - 5000));
        trades.add(new Trade("I1", 200, 100.1, System.currentTimeMillis() - 4000));
        trades.add(new Trade("I1",  31, 100.4, System.currentTimeMillis() - 3000));
        trades.add(new Trade("I1",  41, 100.3, System.currentTimeMillis() - 2000));
        trades.add(new Trade("I1", 100, 100.2, System.currentTimeMillis() - 1000));
        return trades;
    }

    @Test
    public void testAllTradesCount() {
        final List<Trade> trades = setupTrades();
        final VolumeWeightedAveragePrice vwap = new VolumeWeightedAveragePrice(trades);
        assertThat(vwap.getAllTradesCount(),is(6L));
        assertThat(vwap.getAllTradesCount_v1(),is(6L));
        assertThat(vwap.getAllTradesCount_v2(),is(6L));
    }

    @Test
    public void testValidTradesCount() {
        final List<Trade> trades = setupTrades();
        final VolumeWeightedAveragePrice vwap = new VolumeWeightedAveragePrice(trades);
        assertThat(vwap.getValidTradesCount(),is(5L));
    }

    @Test
    public void testVWAPPrice() {
        final List<Trade> trades = setupTrades();
        final VolumeWeightedAveragePrice vwap = new VolumeWeightedAveragePrice(trades);
        assertThat(Math.abs(vwap.calculate().get() - 100.18328), is(lessThan(0.0001)));
    }
}