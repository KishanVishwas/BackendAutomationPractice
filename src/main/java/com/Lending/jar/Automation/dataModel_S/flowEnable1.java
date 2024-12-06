package Lending.jar.Automation.dataModel_S;

import Lending.jar.Automation.Constant.headerConstants;
import Lending.jar.Automation.dataModel_I.flowEnable;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class flowEnable1
{
    public static flowEnable addUser()
    {
        flowEnable set=new flowEnable();
        set.setUserId(headerConstants.userId);
        set.setRealTimeFlowEnabled(true);
        set.setWebFlowJourneyEnabled(false);
        return set;
    }
    public static Map<String, Object> objectMap() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(flowEnable1.addUser(), new TypeReference<Map<String, Object>>() {});

    }
}
