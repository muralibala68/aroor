package org.bala.functional.xface;

import java.util.List;

import org.bala.closure.VolumeWeightedAveragePrice;
import org.bala.md.Trade;

@FunctionalInterface
public interface VWAPStep extends AlgorithmStep {

	@Override
	default double calculateAveragePrice(final List<Trade> trades) {
	    final VolumeWeightedAveragePrice volumeWeigtedAveragePrice = new VolumeWeightedAveragePrice(trades);
	    return volumeWeigtedAveragePrice.calculate().orElse(0.0d);
	}
}
