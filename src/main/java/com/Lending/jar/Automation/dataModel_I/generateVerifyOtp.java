package Lending.jar.Automation.dataModel_I;

import lombok.Data;

@Data
public class generateVerifyOtp {

    private String countryCode;
    private String phoneNumber;
    private String reqId;
    private String otp;
}
