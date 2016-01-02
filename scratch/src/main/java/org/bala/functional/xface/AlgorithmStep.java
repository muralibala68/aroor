package org.bala.functional.xface;

import java.util.List;

import org.bala.md.Trade;

@FunctionalInterface
public interface AlgorithmStep {
	void execute();
	
default double calculateVWAP(final List<Trade> trades) {
		double vwap = 0.0d;
		//trades.forEach(t -> vwap = vwap + (t.getSize() * t.getPrice()) );
		
		
		return vwap;
	}

}
