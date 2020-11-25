package interfaces.cannons;

import interfaces.cannons.type.E_CannonType;

public class LaserCannon extends AbstractCannon {
    LaserCannon(){
        this.cannonType = E_CannonType.LASER_CANNON;
        this.fireRate=100;
        this.fireRange = 60;
        this.shotPower = 60;
        this.armor = 30;
    }
    void setPrice(float price){
        this.price = price;
    }
}
