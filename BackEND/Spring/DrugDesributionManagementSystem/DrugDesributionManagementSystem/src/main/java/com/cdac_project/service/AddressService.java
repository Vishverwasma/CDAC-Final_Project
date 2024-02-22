package com.cdac_project.service;

import java.util.List;

import com.cdac_project.exception.AddressNotFoundException;
import com.cdac_project.model.Address;

public interface AddressService {
    Address addAddress(Address address);

    Address getAddressById(int addressId) throws AddressNotFoundException;

    List<Address> getAddressesByPharmacistid(int pharmacistId);

    Address updateAddress(int addressId, Address address) throws AddressNotFoundException;

    void deleteAddress(int addressId) throws AddressNotFoundException;
}
