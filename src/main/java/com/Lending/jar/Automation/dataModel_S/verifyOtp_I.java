package Lending.jar.Automation.dataModel_S;

import Lending.jar.Automation.Constant.configConstant;
import Lending.jar.Automation.Constant.headerConstants;
import Lending.jar.Automation.dataModel_I.generateVerifyOtp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class verifyOtp_I
{
    public static generateVerifyOtp generateAuth(String otp)
    {
        generateVerifyOtp set=new generateVerifyOtp();
        set.setCountryCode(configConstant.countryCode1);
        set.setPhoneNumber(headerConstants.phoneNumber);
        set.setReqId(configConstant.reqId);
        set.setOtp(otp);



        return set;
    }
    public static Map<String,Object> objectMap(String otp) throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> map=mapper.convertValue(verifyOtp_I.generateAuth(otp), new TypeReference<Map<String, Object>>() {});
        return map;
    }
}
