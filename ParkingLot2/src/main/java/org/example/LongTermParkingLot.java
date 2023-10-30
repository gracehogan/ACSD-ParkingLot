package org.example;

public class LongTermParkingLot implements ParkingLot{
// ToDo:  Use TDD to Implement this function
//  You will need to mock the Ticket interface
//  Business rules for this parking lot are as follows:
//        Basic fee is $2 per hour or fraction thereof
//        This means we always round up; ie, 4 hours 2 minutes is billed as 5 hours.
//        There is no pro-ration
//        Daily max is $15
//        On the first day, the first half hour is free

    @Override
    public int calculateFee(Ticket ticket) {
        int days = ticket.getDays();
        int hours = ticket.getHours();
        int minutes = ticket.getMinutes();

        int hourlyCharge = 2;
        int maxDailyCharge = 15;
        int minsFreeOfCharge = 30;
        int hourlyChargeCap = 7;

        int fee = 0;
        if (days == 0 && hours == 0 && minutes <= minsFreeOfCharge) {
            return fee;
        }
        else {
            fee+= days*maxDailyCharge;

            if (hours > hourlyChargeCap || (hours == hourlyChargeCap && minutes > 0)) {
                fee += maxDailyCharge;
            }

            else {
                fee += hours*hourlyCharge;

                if (minutes > 0) {
                    fee+=hourlyCharge;
                }
            }
        }

        return fee;
    }
}

