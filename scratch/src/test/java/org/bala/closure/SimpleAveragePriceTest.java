package org.bala.closure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.List;

import org.bala.md.Trade;
import org.junit.Test;

public class SimpleAveragePriceTest {
	
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
	public void testSimpleAvergaePrice() {
		final List<Trade> trades = setupTrades();
		final SimpleAveragePrice simpleAveragePrice = new SimpleAveragePrice(trades);
		assertThat(Math.abs(simpleAveragePrice.calculate().getAsDouble() - 83.58333d), is(lessThan(0.0001)));
	}

	@Test
	public void testSimpleAvergaePrice2() {
		final List<Trade> trades = setupTrades();
		final SimpleAveragePrice simpleAveragePrice = new SimpleAveragePrice(trades);
		final double expectedSimpleAveragePrice = simpleAveragePrice.getSumOfAllTradePrices() / simpleAveragePrice.getAllTradesCount();
		System.out.println(expectedSimpleAveragePrice);
		assertThat(Math.abs(simpleAveragePrice.calculate().getAsDouble() - expectedSimpleAveragePrice), is(lessThan(0.0001)));
	}
}
