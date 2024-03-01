package rocks.zipcode;

/**
 * rocks.zipcode.PayDay
 *
 * input: "Kris", 21.5, 10.0, 0.05
 * output: "Kris 215.00 10.75 204.25”
 */
public class PayDay {
    public static void main(String[] args) {
        PayDay payday = new PayDay();



        StringBuilder outputReport = new StringBuilder();
        outputReport.append("PayDayReport for this week\n\n");

        // create an array of TimeCards that have this weeks data in it.
        // each timeCard object contains the data for one person.
        TimeCard[] cards = payday.createRunData();

        for (TimeCard card : cards) {
            String name = card.getName();
            double hoursWorked = card.getHoursWorked();
            // ... etc for the other 2 fields
            double hourlyRate = card.getHourlyRate();
            double deduction = card.getDeductionRate();


            // you need to change the parameters on the method to take the input!
            String result = payday.pay(name, hourlyRate, hoursWorked,deduction);


            outputReport.append(result);
            outputReport.append("\n");
        }

        System.out.println(outputReport.toString());
    }


    /**
     * Takes four parameters:
     *   "Kris", 21.5, 10.0, 0.05
     *
     *   Notice the data type of each of the four.
     * @return a string of the form "Kris 215.00 10.75 204.25”
     */
    public String pay(String name, double hourlyRate, double hoursWorked, double deduction)
    {
        String result;
         double grossPay = hourlyRate * hoursWorked;
         double deduct = grossPay * deduction;
         double netPay = grossPay - deduct;
         result= String.format("%s %.2f %.2f %.2f",name,grossPay,deduct,netPay);




        return result ;
    }


    /**
     * for the example of how the *pay* method might be used to create a text report
     *
     */
    private class TimeCard {
        private String name;
        private double hoursWorked;
        private double hourlyRate;
        private double deductionRate;

        public TimeCard(String name, double hoursWorked, double hourlyRate, double deductionRate) {
            this.name = name;
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
            this.deductionRate = deductionRate;
        }


        public String getName() {
            return name;
        }

        public double getHoursWorked() {
            return hoursWorked;
        }

        public double getHourlyRate() {
            return hourlyRate;
        }

        public double getDeductionRate() {
            return deductionRate;
        }
    }

    public TimeCard[] createRunData() {
        TimeCard[] cards = {
                new TimeCard("Kris", 21.5, 10.0, 0.05),
                new TimeCard("Dolio", 23.0, 12.0, 0.05),
                new TimeCard("Karen", 22.0, 12.0, 0.05),
        };
        return cards;
    }
}
