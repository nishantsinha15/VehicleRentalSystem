import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public class Booking {
    private Vehicle vehicle;
    private Slot bookedSlot;
    private Double price;
    private Branch branch;
}
