package one.digitalinnovation.cloudparking.service;

import one.digitalinnovation.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

/*    static {
        var id = getUUID();
        var id1 = getUUID();
        var id2 = getUUID();
        var id3 = getUUID();
        Parking parking = new Parking(id, "PGK-8876", "PE", "FIAT PALIO", "PRATA");
        Parking parking1 = new Parking(id1, "PCF-2955", "PE", "HYUNDAI HB20", "BRANCO");
        Parking parking2 = new Parking(id2, "PGK-3447", "PE", "HONDA CIVIC", "CINZA");
        Parking parking3 = new Parking(id3, "PGK-8776", "PE", "PEUGEOT 207 SEDAN", "VERDE");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);
        parkingMap.put(id3, parking3);
    }*/

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }

    public Parking exit(String id) {
        //recuperar o estacionado
        //atualizar data de saida
        //calcular valor
        //retornar data de saida e valor a pagar
        return null;
    }
}
