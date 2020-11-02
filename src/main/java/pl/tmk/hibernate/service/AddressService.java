package pl.tmk.hibernate.service;

import pl.tmk.hibernate.dao.AddressDao;
import pl.tmk.hibernate.dto.AddressDto;
import pl.tmk.hibernate.model.Address;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AddressService {

    @Inject
    private AddressDao addressDao;

    public AddressDto saveAddress(AddressDto addressDto) {
    return addressDao.save(addressDto);
    }

    public AddressDto findById (Integer id){
        return addressDao.findById(id);
    }

    public Address edit (Integer id, Address address){
        return addressDao.edit(id, address);
    }
    public boolean remove (Integer id) {
        return addressDao.remove(id);
    }
    public List<Address> findByCity (String city) {
        return addressDao.findByCity(city);
    }
}
