package fr.kazhboop.taatp3.controller;

import fr.kazhboop.taatp3.dto.EntityMappers;
import fr.kazhboop.taatp3.dto.persons.OwnerDto;
import fr.kazhboop.taatp3.repository.OwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerDao ownerDao;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody String name) {
        String ownerId = "";
        try {
            fr.kazhboop.taatp3.domain.persons.Owner ownerEntity = new fr.kazhboop.taatp3.domain.persons.Owner();
            ownerEntity.setName(name);
            ownerDao.save(ownerEntity);
            ownerId = String.valueOf(ownerEntity.getId());
        } catch (Exception ex) {
            return "Error creating the owner: " + ex.toString();
        }
        return "Owner successfully created with id = " + ownerId;
    }

    @GetMapping("/get-by-name/{name}")
    @ResponseBody
    public OwnerDto getByName(@PathVariable String name) {
        OwnerDto ownerDto = null;
        try {
            ownerDto = EntityMappers.INSTANCE.ownerToOwnerDto(ownerDao.findByName(name));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).warning(ex.toString());
        }
        return ownerDto;
    }

    @GetMapping
    @ResponseBody
    public java.util.List<OwnerDto> getAll() {
        java.util.List<OwnerDto> ownerDtos = new java.util.ArrayList<>();
        try {
            ownerDtos = EntityMappers.INSTANCE.ownerToOwnerDto(ownerDao.findAll());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(this.getClass().getName()).warning(ex.toString());
        }
        return ownerDtos;
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody OwnerDto ownerDto) {
        try {
            fr.kazhboop.taatp3.domain.persons.Owner ownerEntity = ownerDao.findById(id).get();
            ownerEntity.setName(ownerDto.getName());
            ownerDao.save(ownerEntity);
        } catch (Exception ex) {
            return "Error updating the owner: " + ex.toString();
        }
        return "Owner successfully updated!";
    }

}
