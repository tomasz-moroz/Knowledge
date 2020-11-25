package interfaces.cannons;

import interfaces.cannons.type.E_CannonType;

public class MachineCannon extends AbstractCannon {
    MachineCannon(){
        this.cannonType = E_CannonType.MACHINE_CANNON;
        this.fireRate=120;
        this.fireRange = 40;
        this.shotPower = 50;
        this.armor = 50;
    }
    void setPrice(float price){
        this.price = price;
    }
}
