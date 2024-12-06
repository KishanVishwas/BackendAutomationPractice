package Lending.jar.Automation.dataModel_I;

import lombok.Data;

@Data
public class flowEnable
{
    private String userId;
    private boolean isRealTimeFlowEnabled;
    private boolean webFlowJourneyEnabled;
}
