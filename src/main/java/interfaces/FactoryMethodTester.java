package interfaces;

import interfaces.cannons.CannonsCreator;
import interfaces.cannons.I_AbstractCannon;
import interfaces.cannons.type.E_CannonType;

public class FactoryMethodTester {

    public static void main(String[] args) {

        CannonsCreator cannonsCreator = CannonsCreator.getInstance();
        I_AbstractCannon laserCanon = cannonsCreator.create(E_CannonType.LASER_CANNON);
        I_AbstractCannon machineCanon = cannonsCreator.create(E_CannonType.MACHINE_CANNON);
        I_AbstractCannon plasmaCanon = cannonsCreator.create(E_CannonType.PLASMA_CANNON);

        System.out.println(laserCanon);
        System.out.println(machineCanon);
        System.out.println(plasmaCanon);
    }
}
