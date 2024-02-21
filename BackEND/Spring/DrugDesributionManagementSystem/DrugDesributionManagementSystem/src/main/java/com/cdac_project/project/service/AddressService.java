package com.cdac_project.project.service;

import com.cdac_project.project.exception.AddressNotFoundException;
import com.cdac_project.project.model.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(Address address);

    Address getAddressById(int addressId) throws AddressNotFoundException;

    List<Address> getAddressesByPharmacistid(int pharmacistId);

    Address updateAddress(int addressId, Address address) throws AddressNotFoundException;

    void deleteAddress(int addressId) throws AddressNotFoundException;
}
