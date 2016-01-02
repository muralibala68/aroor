package org.bala.functional.xface;

import java.util.List;

import org.bala.closure.SimpleAveragePrice;
import org.bala.md.Trade;

@FunctionalInterface
public interface AlgorithmStep {
    void execute();
    
    default double calculateAveragePrice(final List<Trade> trades) {
        final SimpleAveragePrice simpleAveragePrice = new SimpleAveragePrice(trades);
        return simpleAveragePrice.calculate().orElse(0.0d);
    }

}
