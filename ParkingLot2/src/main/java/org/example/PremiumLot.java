package org.example;

public class PremiumLot implements ParkingLot {

    @Override
    public int calculateFee(Ticket ticket) {
// ToDo:  Use TDD to Implement this function
//  You will need to mock the Ticket interface
//  Business rules for this parking lot are as follows:
//        Basic fee is $4 per hour or fraction thereof
//        This means we always round up; ie, 4 hours 2 minutes is billed as 5 hours.
//        There is no pro-ration
//        Daily max is $27
//        Every 7th day or fraction thereof is free.  (ie, a stay of 13 days and 4 hours will be billed for 12 days
        double days = ticket.getDays();
        int hours = ticket.getHours();
        int minutes = ticket.getMinutes();

        int hourlyCharge = 4;
        int maxDailyCharge = 27;
        int hourlyChargeCap = 6;
        int freeDayInterval = 7;

        int fee = 0;
            if (days % freeDayInterval == 0) {
                days -= days / freeDayInterval;
            }
            fee += days * maxDailyCharge;

            if (hours > hourlyChargeCap || (hours == hourlyChargeCap && minutes > 0)) {
                fee += maxDailyCharge;
            } else {
                fee += hours * hourlyCharge;

                if (minutes > 0) {
                    fee += hourlyCharge;
                }
            }

        return fee;
    }
}
