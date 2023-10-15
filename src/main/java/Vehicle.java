import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    private String vehicleId;
    private VehicleTypeEnum vehicleTypeEnum;
}
