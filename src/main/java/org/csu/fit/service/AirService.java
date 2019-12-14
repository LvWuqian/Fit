package org.csu.fit.service;

import org.csu.fit.domain.AirQuality;

public interface AirService {

    public AirQuality getAirByCity(String city);
}
