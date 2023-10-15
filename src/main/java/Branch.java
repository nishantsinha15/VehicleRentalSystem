import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Branch {
    Map<VehicleTypeEnum, List<Inventory>> inventoryMap; // WHYYY
    Map<VehicleTypeEnum, Double> price;
    // how to handle that vehicle already has the property of vehicle type.
    // But it also needs to be maintained seprately in Branch

    public Branch() {
        inventoryMap = new HashMap<>();
        price = new HashMap<>();
    }
}
