package org.bala.closure;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import org.bala.md.Trade;

public class SimpleAveragePrice {
	private final List<Trade> trades;
	
	public SimpleAveragePrice(List<Trade> trades) {
		this.trades = trades;
	}
	
	public void printAllTrades() {
		trades.forEach(System.out::println);
	}

	public long getAllTradesCount() {
		return trades.stream().count();
	}

	public void printValidTrades() {
		trades.stream().filter(Trade::isValid).forEach(System.out::println);
	}

	public long getValidTradesCount() {
		return trades.stream().filter(Trade::isValid).count();
	}

	public void printAllTradeValues() {
		trades.stream().map(Trade::getValue).forEach(System.out::println);
	}
	
	public void printValidTradeValues() {
		trades.stream().filter(Trade::isValid).map(Trade::getValue).forEach(System.out::println);
	}

	public Double getSumOfAllTradePrices() {
		return trades.stream().mapToDouble(Trade::getPrice).sum();
	}

	public OptionalDouble calculate() {
		final OptionalDouble avg = trades.stream().mapToDouble(Trade::getPrice).average();
		avg.ifPresent(System.out::println);
		return avg;
	}
}