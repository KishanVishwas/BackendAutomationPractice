package Lending.jar.Automation.dataModel_S;

import Lending.jar.Automation.Constant.headerConstants;
import Lending.jar.Automation.dataModel_I.LoanOtpLimitReset;
import Lending.jar.Automation.dataModel_I.OtpLimitReset;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class OtpLimit
{
    public static OtpLimitReset reset()
    {
        OtpLimitReset set =new OtpLimitReset();
        set.setMobileNumber(headerConstants.mobileNumber);
        return set;
    }
    public static Map<String, Object> objectMap() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map =mapper.convertValue(OtpLimit.reset(), new TypeReference<Map<String, Object>>() {});
        return map;
    }

    public static LoanOtpLimitReset loanReset()
    {
        LoanOtpLimitReset set =new LoanOtpLimitReset();
        set.setMobileNumber(headerConstants.mobileNumber);
        return set;
    }
    public static Map<String, Object> objectMap1() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map =mapper.convertValue(OtpLimit.loanReset(), new TypeReference<Map<String, Object>>() {});
        return map;
    }
}
