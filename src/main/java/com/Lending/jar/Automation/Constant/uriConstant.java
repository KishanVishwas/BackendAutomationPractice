package Lending.jar.Automation.Constant;


public class uriConstant {

//    pracice uri for Post
    public static String postUser="users";

//    need help chat bot
    public static String getAnswers="v2/api/loan/needHelp";

// resetOtp to reset the limit 1
    public static String resetOtp="v1/api/internal/auth/resetOtp";

//resetOtpVerifyLimit to reset the limit 2
    public static String resetOtpVerifyLimit="v1/api/internal/auth/resetOtpVerifyLimit";

//    Loan Otp reset
    public static String loanOtpreset="v1/api/internal/lending/resetOtp";

//    userDeviceDetails
    public static String userDeviceDetails="v2/api/user/device";

//    login Otp

    public static String loginOtp="v2/api/auth/requestOTP";

//    verify otp
    public static String verify_otp="v2/api/auth/verifyOTP";

//    Json Schema basic uri example
    public static String exampleUri="/users/1";

//    Json schema validation for rule engine Api
    public static String ruleEngine="rule-engine/v2/api/lending/ruleEngine/master/gating/checkEligibilityWebFlow";

//    add user to lendingUsers
    public static String addUsers="lendingTestController/add/lendingusers";

//    Nested and Array practice Uri
    public static String practiceUri="users";

    // Credit card offer
    public static String addingOffer="v1/api/creditCard/internal/addOffer";

    // MIS STATUS Credit Card
    public static String misStatus="v1/api/creditCard/internal/process/misStatus";


}
