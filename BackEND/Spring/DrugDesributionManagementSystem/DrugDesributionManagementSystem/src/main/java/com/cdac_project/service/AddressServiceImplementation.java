package com.cdac_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac_project.exception.AddressNotFoundException;
import com.cdac_project.model.Address;
import com.cdac_project.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImplementation implements AddressService {

	@Autowired
    private AddressRepository addressRepository;

	
	
//    public AddressServiceImplementation(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(int addressId) throws AddressNotFoundException {
//        Optional<Address> optionalAddress = addressRepository.findById(addressId);
//            return optionalAddress.get();
    	
    	Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        } else {
            throw new AddressNotFoundException("Address not found with ID: " + addressId);
        }
    }

    @Override
    public List<Address> getAddressesByPharmacistid(int pharmacistId) {
        return addressRepository.findByPharmacistid(pharmacistId);
    }

    @Override
    public Address updateAddress(int addressId, Address address) throws AddressNotFoundException {
//        Optional<Address> optionalAddress = addressRepository.findById(addressId);
//            address.setAddressid(addressId);
//            return addressRepository.save(address);
    	
    	Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setFullAddress(address.getFullAddress()); // Update Full_Address field
            return addressRepository.save(existingAddress);
        } else {
            throw new AddressNotFoundException("Address not found with ID: " + addressId);
        }
    }

    @Override
    public void deleteAddress(int addressId) throws AddressNotFoundException {
        if (addressRepository.existsById(addressId)) {
            addressRepository.deleteById(addressId);
        } else {
            throw new AddressNotFoundException("Address not found with ID: " + addressId);
        }
    }
}
