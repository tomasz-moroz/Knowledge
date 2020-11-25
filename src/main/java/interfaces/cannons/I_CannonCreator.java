package interfaces.cannons;

import interfaces.cannons.type.E_CannonType;

public interface I_CannonCreator {

    public abstract I_AbstractCannon create (E_CannonType cannonType);

}
