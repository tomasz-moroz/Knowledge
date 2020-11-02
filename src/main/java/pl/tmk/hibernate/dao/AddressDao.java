package pl.tmk.hibernate.dao;

import pl.tmk.hibernate.dto.AddressDto;
import pl.tmk.hibernate.model.Address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    public AddressDto save(AddressDto addressDto){
        Address address = AddressDto.DtoToAddress.apply(addressDto);
        entityManager.persist(address);
        return AddressDto.addressToDto.apply(address);
    }

    public AddressDto findById (Integer id) {
        Address address = entityManager.find(Address.class, id);
        return AddressDto.addressToDto.apply(address);
    }

    public List<Address> findByCity (String city) {
        Query query = entityManager.createQuery("SELECT address FROM Address address WHERE address.city=:city");
        query.setParameter("city", city);

        List<Address> result = query.getResultList();
        return result;
    }

    public Address edit(Integer id, Address address) {
        Address toEdit = entityManager.find(Address.class, id);
        if(toEdit!=null){
            toEdit.setCity(address.getCity());
            toEdit.setZip(address.getZip());
            toEdit.setStreet(address.getStreet());
            toEdit.setHouseNumber(address.getHouseNumber());
            toEdit.setApartmentNumber(address.getApartmentNumber());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }
    public boolean remove (Integer id) {
        Address toRemove = entityManager.find(Address.class, id);
        if(toRemove!=null){
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }
}
