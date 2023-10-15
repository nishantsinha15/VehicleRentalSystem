import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class Booking {
    private Vehicle vehicle;
    private Slot bookedSlot;
    private Double price;
}
