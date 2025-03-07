package Lending.jar.Automation.dataModel_S;

import Lending.jar.Automation.Constant.headerConstants;
import Lending.jar.Automation.dataModel_I.creditCardMisStatus;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class creditCardMisStatus_I
{
    public static creditCardMisStatus bKycFlow()
    {
        creditCardMisStatus set=new creditCardMisStatus();
        set.setApplicationReferenceNumber(headerConstants.applicationReferenceNumber);
        set.setLc2Code(headerConstants.lc2Code);
        set.setMisStatus(headerConstants.bKyc);
        return set;
    }
    public static Map<String, Object> objectMapBkyc() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(creditCardMisStatus_I.bKycFlow(), new TypeReference<Map<String, Object>>() {});

    }

    public static creditCardMisStatus Underwriter()
    {
        creditCardMisStatus set=new creditCardMisStatus();
        set.setApplicationReferenceNumber(headerConstants.applicationReferenceNumber);
        set.setLc2Code(headerConstants.lc2Code);
        set.setMisStatus(headerConstants.underWriter);
        return set;
    }
    public static Map<String, Object> objectMapUnderwriter() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(creditCardMisStatus_I.Underwriter(), new TypeReference<Map<String, Object>>() {});

    }

    public static creditCardMisStatus inProcessFlow()
    {
        creditCardMisStatus set=new creditCardMisStatus();
        set.setApplicationReferenceNumber(headerConstants.applicationReferenceNumber);
        set.setLc2Code(headerConstants.lc2Code);
        set.setMisStatus(headerConstants.InProcess);
        return set;
    }
    public static Map<String, Object> objectMapinProcessFlow() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(creditCardMisStatus_I.inProcessFlow(), new TypeReference<Map<String, Object>>() {});

    }

    public static creditCardMisStatus approvedFlow()
    {
        creditCardMisStatus set=new creditCardMisStatus();
        set.setApplicationReferenceNumber(headerConstants.applicationReferenceNumber);
        set.setLc2Code(headerConstants.lc2Code);
        set.setMisStatus(headerConstants.approved);
        return set;
    }
    public static Map<String, Object> objectMapinapprovedFlow() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(creditCardMisStatus_I.approvedFlow(), new TypeReference<Map<String, Object>>() {});

    }
}
