package com.klef.fsad.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ship")
public class ShipmentController {

    @Autowired
    private ShipmentRepository repository;

    @PostMapping("/add")
    public String addShipment(@RequestBody Shipment shipment) {
        repository.save(shipment);
        return "Shipment added successfully!";
    }

    @PutMapping("/update")
    public String updateShipment(@RequestBody Shipment shipment) {
        if (repository.existsById(shipment.getId())) {
            repository.save(shipment);
            return "Shipment updated successfully!";
        }
        return "Shipment not found!";
    }
}

@Repository
interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}
