package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class FeeTests {
    Ticket ticket;
    int fee;

    @BeforeEach
    public void setup() {
        ticket = mock(Ticket.class);
    }

    @ParameterizedTest
    @CsvSource({"2023-09-28 14:15, 2023-09-28 18:22, 10"})
    public void testLongTermParkingLotFee(String entryTime, String exitTime, int expectedFee) {
        ParkingLot uut = new LongTermParkingLot();
        ticket.setEntryTime(entryTime);
        ticket.setExitTime(exitTime);
        when(uut.calculateFee(ticket)).thenReturn(fee);
        assertEquals(expectedFee, fee);
    }
}
