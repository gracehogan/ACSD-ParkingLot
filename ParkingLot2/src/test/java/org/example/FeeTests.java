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
    @CsvSource({"2023-09-28 14:15, 2023-09-28 18:22, 10"})
    public void testLongTermParkingLotFee(String entryTime, String exitTime, int fee) {
        ParkingLot uut = new LongTermParkingLot();
        ticket.setEntryTime(entryTime);
        ticket.setExitTime(exitTime);

        when(ticket.getDays()).thenReturn(0);
        when(ticket.getHours()).thenReturn(4);
        when(ticket.getMinutes()).thenReturn(7);

        assertEquals(fee, uut.calculateFee(ticket));
    }
}
