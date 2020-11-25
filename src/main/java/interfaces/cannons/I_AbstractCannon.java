package interfaces.cannons;

import interfaces.cannons.type.E_CannonType;

public interface I_AbstractCannon {

    public abstract E_CannonType getCannonType();
    public abstract int getFireRate();
    public abstract int getArmor();
    public abstract int getShotPower();
    public abstract int getFireRange();
    public abstract float getPrice();
}
