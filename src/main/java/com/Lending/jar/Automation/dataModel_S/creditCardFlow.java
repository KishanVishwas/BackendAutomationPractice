package Lending.jar.Automation.dataModel_S;

import Lending.jar.Automation.Constant.headerConstants;
import Lending.jar.Automation.dataModel_I.creditCardOffer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class creditCardFlow
{
    public static creditCardOffer vKycFlow()
    {
        creditCardOffer set=new creditCardOffer();
        set.setApplicationReferenceNumber(headerConstants.applicationReferenceNumber);
        set.setLc2Code(headerConstants.lc2Code);
        set.setWebViewUrl(headerConstants.webViewUrl);
        set.setMisStatus(headerConstants.vKyc);
        return set;
    }
    public static Map<String, Object> objectMapvkyc() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(creditCardFlow.vKycFlow(), new TypeReference<Map<String, Object>>() {});

    }


}
