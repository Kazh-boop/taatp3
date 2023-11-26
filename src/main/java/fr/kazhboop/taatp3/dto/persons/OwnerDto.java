package fr.kazhboop.taatp3.dto.persons;

import fr.kazhboop.taatp3.dto.animals.AnimalDto;

import java.util.List;

public class OwnerDto {

    private String name;

    private List<AnimalDto> animals;

    public OwnerDto() {
    }

    public OwnerDto(String name, List<AnimalDto> animals) {
        this.name = name;
        this.animals = animals;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnimalDto> getAnimals() {
        return animals;
    }

    public void setAnimals(List<AnimalDto> animals) {
        this.animals = animals;
    }
}
