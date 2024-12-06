package Lending.jar.Automation.dataModel_S;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Lending.jar.Automation.Constant.headerConstants.*;

public class practicePost1
{
    public static Map<String, Object> postRequest()
    {


       Map<String,Object> geo=new HashMap<>();
       geo.put("lat","40.7128");
       geo.put("lng","-70.0050");

        Map<String, Object> address=new HashMap<>();
        address.put("Street",Street);
        address.put("city",city);
        address.put("zipcode",zipcode);
        address.put("geo",geo);

        Map<String, Object> homePhone = new HashMap<>();
        homePhone.put("type","home");
        homePhone.put("number","123-456-7890");

        Map<String, Object> mobilePhone=new HashMap<>();
        mobilePhone.put("type","mobile");
        mobilePhone.put("number","09876543211");

        List<Map<String, Object>> phoneNumbers= List.of(homePhone,mobilePhone);

        Map<String, Object> company=new HashMap<>();
        company.put("name","Tech Solutions");
        company.put("industry","Software Solutions");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name","ChangeJar");
        requestBody.put("email","jar1@changejar.in");
        requestBody.put("address",address);
        requestBody.put("phoneNumbers",phoneNumbers);
        requestBody.put("company",company);

        return requestBody;
    }
}
