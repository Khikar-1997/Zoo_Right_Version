package com.example.zoo.service;

import com.example.zoo.persistence.model.Animal;
import com.example.zoo.persistence.model.Cage;
import com.example.zoo.persistence.repository.AnimalRepository;
import com.example.zoo.persistence.repository.CageRepository;
import com.example.zoo.rest.model.animal.AnimalRequestModel;
import com.example.zoo.rest.model.animal.AnimalResponseModel;
import com.example.zoo.rest.model.cage.CageResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final CageRepository cageRepository;

    public AnimalService(AnimalRepository animalRepository, CageRepository cageRepository) {
        this.animalRepository = animalRepository;
        this.cageRepository = cageRepository;
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(AnimalService.class);

    public AnimalResponseModel create(AnimalRequestModel animalRequestModel){
        LOGGER.info("Request to created animal - {}",animalRequestModel);
        Animal animal = buildAnimalFrom(animalRequestModel);
        Cage cage = cageRepository.findById(animalRequestModel.getCageId()).get();
        animal.setCage(cage);
        return buildAnimalResponseModelFrom(animalRepository.save(animal));
    }

    //region Private methods
    private Animal buildAnimalFrom(AnimalRequestModel animalRequestModel){
        Animal animal = new Animal();
        animal.setName(animalRequestModel.getName());
        animal.setType(animalRequestModel.getType());
        return animal;
    }

    private AnimalResponseModel buildAnimalResponseModelFrom(Animal animal){
        AnimalResponseModel animalResponseModel = new AnimalResponseModel();
        CageResponseModel cageResponseModel = new CageResponseModel();
        animalResponseModel.setId(animal.getId());
        animalResponseModel.setName(animal.getName());
        animalResponseModel.setType(animal.getType());
        cageResponseModel.setId(animal.getCage().getId());
        cageResponseModel.setType(animal.getCage().getType());
        cageResponseModel.setCageNumber(animal.getCage().getCageNumber());
        cageResponseModel.setCreateAt(animal.getCage().getCreate_at());
        animalResponseModel.setCage(cageResponseModel);
        return animalResponseModel;
    }
    //endregion
}
