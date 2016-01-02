package org.bala.closure;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import org.bala.md.Trade;

public class VWAP {
	private final List<Trade> trades;
	
	public VWAP(List<Trade> trades) {
		this.trades = trades;
	}
	
	public void printAllTrades_v1() {
		trades.forEach( (Trade t) -> {
			System.out.println(t); 
			}
		);
	}

	public void printAllTrades_v2() {
		trades.forEach( t -> {
			System.out.println(t); 
			}
		);
	}

	public void printAllTrades_v3() {
		trades.forEach( t -> System.out.println(t) );
	}
	
	public void printAllTrades() {
		trades.forEach(System.out::println);
	}

	public long getAllTradesCount_v1() {
		return trades.stream().mapToLong(t -> 1L).reduce(0, Long::sum);
	}

	public long getAllTradesCount_v2() {
		return trades.stream().mapToLong(t -> 1L).sum();
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

	public void printAllTradeValues_v1() {
		trades.forEach( t -> System.out.println( t.getValue() ) );
	}

	public void printAllTradeValues() {
		trades.stream().map(Trade::getValue).forEach(System.out::println);
	}
	
	public void printValidTradeValues_v1() {
		final Predicate<Trade> validTrade = (Trade t) -> t.getPrice() > 0.0d && t.getSize() > 0.0d;
		trades.stream().filter(validTrade).map(Trade::getValue).forEach(System.out::println);
	}
	
	public void printValidTradeValues_v2() {
		final Predicate<Trade> validTrade = Trade::isValid;
		trades.stream().filter(validTrade).map(Trade::getValue).forEach(System.out::println);
	}
	
	public void printValidTradeValues_v3() {
		trades.stream().filter(Trade::isValid).map(Trade::getValue).forEach(System.out::println);
	}

	private Double getSumOfAllTradeSizes_v1() {
		final Double identity = new Double(0.0d);
		final BiFunction<Double, Trade, Double> tradeSizeAccumulator = (Double totalSize,Trade trade) -> totalSize + trade.getSize();
		final BinaryOperator<Double> tradeSizeCombiner = (Double ts1, Double ts2) -> ts1 + ts2;
		final Double sumOfAllTradeSizes = trades.parallelStream().reduce(identity, tradeSizeAccumulator, tradeSizeCombiner);
		return sumOfAllTradeSizes;
	}

	private Double getSumOfAllTradeSizes_v2() {
		return trades.parallelStream().reduce(0.0d, (ts,t)-> ts + t.getSize(), (ts1,ts2)-> ts1 + ts2);
	}

	private Double getSumOfAllTradeSizes_v3() {
		return trades.stream().mapToDouble(Trade::getSize).sum();
	}

	private Optional<Double> getSumOfAllTradeSizes() {
		final Optional<Double> sumOfAllTradeSizes = trades.stream().map(t -> t.getSize()).reduce((ts1,ts2)-> ts1 + ts2);
		return sumOfAllTradeSizes;
	}

	private Double getSumOfAllTradeValues_v1() {
		return trades.stream().mapToDouble(Trade::getValue).sum();
	}

	private Optional<Double> getSumOfAllTradeValues() {
		final Optional<Double> sumOfAllTradeValues = trades.stream().map(Trade::getValue).reduce((tv1,tv2) -> tv1 + tv2);
		return sumOfAllTradeValues;
	}

	public Optional<Double> calculate() {
		final Optional<Double> sumOfAllTradeValues = getSumOfAllTradeValues();
		sumOfAllTradeValues.ifPresent(System.out::println);

		final Optional<Double> sumOfAllTradeSizes = getSumOfAllTradeSizes();
		sumOfAllTradeSizes.ifPresent(System.out::println);

		final Optional<Double> vwap = sumOfAllTradeValues.isPresent() && sumOfAllTradeSizes.isPresent() ?
			  Optional.of(sumOfAllTradeValues.get() / sumOfAllTradeSizes.get()) :
			  Optional.empty();
		vwap.ifPresent(System.out::println);
		return vwap;
	}
	
	public OptionalDouble calculateSimpleAveragePrice() {
		final OptionalDouble avg = trades.stream().mapToDouble(Trade::getPrice).average();
		avg.ifPresent(System.out::println);
		return avg;
	}
}