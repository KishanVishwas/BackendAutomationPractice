package Lending.jar.Automation.dataModel_I;

import lombok.Data;

import java.util.List;


@Data
public class schemaRuleEngine
{

    private  List<DpdCheck> dpdCheck;
    private String age;
    private String score;
    private int totalAmountPastDue;
    private int totalCapsLast180Days;

}
