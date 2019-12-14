package org.csu.fit.service.Impl;

import com.alibaba.fastjson.JSONObject;
import org.csu.fit.domain.AirQuality;
import org.csu.fit.service.AirService;
import org.csu.fit.utils.AirAPI.Query;
import org.springframework.stereotype.Service;

@Service
public class AirServiceImpl implements AirService {
    @Override
    public AirQuality getAirByCity(String city) {
        try {
            JSONObject result = Query.Get(city);
            AirQuality airQuality = new AirQuality();
            airQuality.setCity(city);
            airQuality.setPm(result.getString("ipm2_5"));
            airQuality.setQuality(result.getString("quality"));
            return airQuality;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
