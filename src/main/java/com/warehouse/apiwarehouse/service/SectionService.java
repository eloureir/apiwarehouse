package com.warehouse.apiwarehouse.service;

import com.warehouse.apiwarehouse.dto.ProductCreateDTO;
import com.warehouse.apiwarehouse.dto.SectionCreateDTO;
import com.warehouse.apiwarehouse.entity.Product;
import com.warehouse.apiwarehouse.entity.Section;
import com.warehouse.apiwarehouse.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SectionService {
    @Autowired
    private SectionRepository repository;

    public SectionCreateDTO findById(UUID id) {
        Section section = repository.findById(id).orElseThrow();
        return convertToDto(section);
    }

    public List<SectionCreateDTO> findAll() {
        List<Section> sections = repository.findAll();
        List<SectionCreateDTO> sectionDTO = new ArrayList<>();
        for (Section section : sections) {
            sectionDTO.add(convertToDto(section));
        }
        return sectionDTO;

    }
    public SectionCreateDTO save(SectionCreateDTO sectionCreateDTO) {
        Section section = convertToEntity(sectionCreateDTO);
        section =  repository.save(section);
        return convertToDto(section);
    }

    public SectionCreateDTO update(UUID id, SectionCreateDTO sectionCreateDTO) {
        Section section = convertToEntity(sectionCreateDTO);
        section.setId(id);
        section = repository.save(section);
        return convertToDto(section);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public SectionCreateDTO convertToDto(Section section) {
        SectionCreateDTO sectionCreateDTO = new SectionCreateDTO();
        sectionCreateDTO.setCode(section.getCode());
        return sectionCreateDTO;
    }
    public Section convertToEntity(SectionCreateDTO sectionCreateDTO) {
        Section section = new Section();
        sectionCreateDTO.setCode(sectionCreateDTO.getCode());
        return section;
    }
}
