package fr.kazhboop.taatp3.dto;

import fr.kazhboop.taatp3.domain.animals.Animal;
import fr.kazhboop.taatp3.domain.persons.Owner;
import fr.kazhboop.taatp3.dto.animals.AnimalDto;
import fr.kazhboop.taatp3.dto.persons.OwnerDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface EntityMappers {

    EntityMappers INSTANCE = Mappers.getMapper(EntityMappers.class);

    AnimalDto animalToAnimalDto(Animal animal);

    List<AnimalDto> animalToAnimalDto(List<Animal> animals);

    Animal animalDtoToAnimal(AnimalDto animalDto);

    List<Animal> animalDtoToAnimal(List<AnimalDto> animalDtos);

    OwnerDto ownerToOwnerDto(Owner owner);

    List<OwnerDto> ownerToOwnerDto(List<Owner> owners);

    Owner ownerDtoToOwner(OwnerDto ownerDto);

    List<Owner> ownerDtoToOwner(List<OwnerDto> ownerDtos);

    @Named("appointmentDate")
    public static String appointmentDate(Timestamp timestamp) {
        return timestamp.toString();
    }

    @Named("appointmentDate")
    public static Timestamp appointmentDate(String timestamp) {
        return Timestamp.valueOf(timestamp);
    }
}

