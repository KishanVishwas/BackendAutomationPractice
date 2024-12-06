package Lending.jar.Automation.dataModel_S;

import Lending.jar.Automation.Constant.headerConstants;
import Lending.jar.Automation.dataModel_I.deviceDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class deviceDetails_I {

    public static deviceDetails fetchDetails()
    {
        deviceDetails set=new deviceDetails();
        set.setDeviceId(headerConstants.deviceId);
        set.setAdvertisingId(headerConstants.advertisingId);
        set.setAppsFlyerId(headerConstants.appsFlyerId);
        set.setUserId(headerConstants.userId);
        return set;
    }
    public static Map<String,Object> objectMap() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.convertValue(deviceDetails_I.fetchDetails(), new TypeReference<Map<String, Object>>() {});
    }

}
