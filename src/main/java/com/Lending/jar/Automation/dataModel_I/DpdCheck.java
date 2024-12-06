package Lending.jar.Automation.dataModel_I;

import lombok.Data;


    @Data
    public class DpdCheck
    {
        private String year;
        private String month;
        private int daysPastDue;

        public DpdCheck(String year, String month, int daysPastDue) {
            this.year = year;
            this.month = month;
            this.daysPastDue = daysPastDue;

        }
    }

