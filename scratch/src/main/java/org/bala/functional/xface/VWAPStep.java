package org.bala.functional.xface;

import java.util.List;

import org.bala.closure.VolumeWeigtedAveragePrice;
import org.bala.md.Trade;

@FunctionalInterface
public interface VWAPStep extends AlgorithmStep {

	@Override
	default double calculateAveragePrice(final List<Trade> trades) {
	    final VolumeWeigtedAveragePrice volumeWeigtedAveragePrice = new VolumeWeigtedAveragePrice(trades);
	    return volumeWeigtedAveragePrice.calculate().orElse(0.0d);
	}
}
