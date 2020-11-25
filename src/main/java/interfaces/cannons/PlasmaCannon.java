package interfaces.cannons;

import interfaces.cannons.type.E_CannonType;

public class PlasmaCannon extends AbstractCannon {
    PlasmaCannon(){
        this.cannonType = E_CannonType.MACHINE_CANNON;
        this.fireRate=75;
        this.fireRange = 60;
        this.shotPower = 60;
        this.armor = 80;
    }
    void setPrice(float price){
        this.price=price;
    }
}
