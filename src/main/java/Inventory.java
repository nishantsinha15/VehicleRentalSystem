import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Inventory {
    private Vehicle vehicle;
    private Set<Slot> bookedSlotSet;

    public Inventory(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.bookedSlotSet = new HashSet<>();
    }
}
