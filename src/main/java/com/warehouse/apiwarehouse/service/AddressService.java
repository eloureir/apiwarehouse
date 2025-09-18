package com.warehouse.apiwarehouse.service;

import com.warehouse.apiwarehouse.dto.AddressCreateDTO;
import com.warehouse.apiwarehouse.entity.Address;
import com.warehouse.apiwarehouse.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    //procurar pelo id
    public AddressCreateDTO findById(UUID id) {
        Address address = repository.findById(id).orElseThrow();
        return convertToDto(address);
    }
    //salvar
    public AddressCreateDTO save(AddressCreateDTO addressCreateDTO){
        Address address = convertToEntity(addressCreateDTO);
        address = repository.save(address);
        return convertToDto(address);
    }
    //atualizar
    public AddressCreateDTO update(UUID id, AddressCreateDTO addressCreateDTO) {
        Address address = convertToEntity(addressCreateDTO);
        address.setId(id);
        address = repository.save(address);
        return convertToDto(address);
    }
    //deletar
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    //listar todos
    public List<AddressCreateDTO> findAll() {
        List<Address> addresses = repository.findAll();
        List<AddressCreateDTO> addressDTO = new ArrayList<>();
        for (Address address : addresses) {
            addressDTO.add(convertToDto(address));
        }
        return addressDTO;
    }
    public AddressCreateDTO convertToDto(Address address) {
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setStreet(address.getStreet());
        addressCreateDTO.setCity(address.getCity());
        return addressCreateDTO;
    }
    public Address convertToEntity(AddressCreateDTO addressCreateDTO) {
        Address address = new Address();
        address.setStreet(addressCreateDTO.getStreet());
        address.setCity(addressCreateDTO.getCity());
        return address;
    }
}
