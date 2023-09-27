package fr.kazhboop.taatp3.controller;

import fr.kazhboop.taatp3.domain.animals.Animal;
import fr.kazhboop.taatp3.domain.animals.EAnimalType;
import fr.kazhboop.taatp3.dto.animals.AnimalDto;
import fr.kazhboop.taatp3.repository.AnimalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalDao animalDao;

    //@RequestMapping(value = "/create", method = RequestMethod.POST  , consumes = MediaType.APPLICATION_JSON_VALUE)
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


    @RequestMapping(value = "get-by-name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getByName(@PathVariable String name) {
        String animalId = "";
        try {
            Animal animal = animalDao.findByName(name);
            animalId = String.valueOf(animal.getId());
        } catch (Exception ex) {
            return "Animal not found";
        }
        return "The animal id is: " + animalId;
    }

}
