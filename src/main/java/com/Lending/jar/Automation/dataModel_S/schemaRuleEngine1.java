package Lending.jar.Automation.dataModel_S;

import Lending.jar.Automation.Constant.headerConstants;
import Lending.jar.Automation.dataModel_I.DpdCheck;
import Lending.jar.Automation.dataModel_I.schemaRuleEngine;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Map;

public class schemaRuleEngine1
{
    public static schemaRuleEngine payloadRuleEngine()
    {

        DpdCheck dpd1 = new DpdCheck("2024", "09", 23);
        DpdCheck dpd2 = new DpdCheck("2024", "10", 30);
        DpdCheck dpd3 = new DpdCheck("2024", "08", 0);
        DpdCheck dpd4 = new DpdCheck("2024", "07", 30);
        DpdCheck dpd5 = new DpdCheck("2024", "06", 0);
        schemaRuleEngine rule=new schemaRuleEngine();
        rule.setAge(headerConstants.age);
        rule.setScore(headerConstants.score);
        rule.setTotalAmountPastDue(headerConstants.totalAmountPastDue);
        rule.setTotalCapsLast180Days(headerConstants.totalCapsLast180Days);
        rule.setDpdCheck(Arrays.asList(dpd1,dpd2,dpd3,dpd4,dpd5));
       return rule;

    }

    public static Map<String, Object> objectMap() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map =mapper.convertValue(schemaRuleEngine1.payloadRuleEngine(), new TypeReference<Map<String, Object>>() {});
        return map;
    }


}
