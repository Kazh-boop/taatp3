package fr.kazhboop.taatp3.controller.animals;

import fr.kazhboop.taatp3.domain.animals.Animal;
import fr.kazhboop.taatp3.domain.animals.EAnimalType;
import fr.kazhboop.taatp3.dto.EntityMappers;
import fr.kazhboop.taatp3.dto.animals.AnimalDto;
import fr.kazhboop.taatp3.repository.animals.AnimalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalDao animalDao;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody AnimalDto animal) {
        String animalId = "";
        try {
            Animal animalEntity = new Animal();
            animalEntity.setName(animal.getName());
            animalEntity.setAge(animal.getAge());
            animalEntity.setAnimalType(EAnimalType.valueOf(animal.getAnimalType()));
            animalDao.save(animalEntity);
            animalId = String.valueOf(animalEntity.getId());
        } catch (Exception ex) {
            return "Error creating the animal: " + ex;
        }
        return "Animal successfully created with id = " + animalId;
    }

    @GetMapping("/get-by-name/{name}")
    @ResponseBody
    public AnimalDto getByName(@PathVariable String name) {
        AnimalDto animalDto = null;
        try {
            animalDto = EntityMappers.INSTANCE.animalToAnimalDto(animalDao.findByName(name));
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).warning(ex.toString());
        }
        return animalDto;
    }

    @GetMapping
    @ResponseBody
    public List<AnimalDto> getAll() {
        List<AnimalDto> animalDtos = new ArrayList<>();
        try {
            animalDtos = EntityMappers.INSTANCE.animalToAnimalDto(animalDao.findAll());
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).warning(ex.toString());
        }
        return animalDtos;
    }

    @GetMapping("/get-by-owner/{ownerName}")
    @ResponseBody
    public List<AnimalDto> getByOwner(@PathVariable String ownerName) {
        return EntityMappers.INSTANCE.animalToAnimalDto(animalDao.findByOwnerName(ownerName));
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id, @RequestBody AnimalDto animal) {
        try {
            Animal animalToUpdate = animalDao.findById(id).get();
            animalToUpdate.setName(animal.getName());
            animalToUpdate.setAge(animal.getAge());
            animalToUpdate.setAnimalType(EAnimalType.valueOf(animal.getAnimalType()));
            animalDao.save(animalToUpdate);
        } catch (Exception ex) {
            return "Error updating the animal: " + ex.toString();
        }
        return "Animal successfully updated!";
    }

}
