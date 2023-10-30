package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class FeeTests {
    Ticket ticket;

    @BeforeEach
    public void setup() {
        ticket = mock(Ticket.class);
    }

    @ParameterizedTest
    @CsvSource({"2023-09-28 14:15, 2023-09-28 18:22, 0, 4, 7, 10"})
    public void testLongTermParkingLotFee(String entryTime, String exitTime, int days, int hours, int minutes, int fee) {
        ParkingLot uut = new LongTermParkingLot();
        ticket.setEntryTime(entryTime);
        ticket.setExitTime(exitTime);

        when(ticket.getDays()).thenReturn(days);
        when(ticket.getHours()).thenReturn(hours);
        when(ticket.getMinutes()).thenReturn(minutes);

        assertEquals(fee, uut.calculateFee(ticket));
    }

    @ParameterizedTest
    @CsvSource({"2023-09-01 09:00, 2023-09-25 15:00, 24, 6, 0, 594"})
    public void testPremiumTermParkingLotFee(String entryTime, String exitTime, int days, int hours, int minutes, int fee) {
        ParkingLot uut = new PremiumLot();
        ticket.setEntryTime(entryTime);
        ticket.setExitTime(exitTime);

        when(ticket.getDays()).thenReturn(days);
        when(ticket.getHours()).thenReturn(hours);
        when(ticket.getMinutes()).thenReturn(minutes);

        assertEquals(fee, uut.calculateFee(ticket));
    }
}
