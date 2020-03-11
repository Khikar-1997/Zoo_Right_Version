package com.example.zoo.service;

import com.example.zoo.persistence.model.Cage;
import com.example.zoo.persistence.repository.CageRepository;
import com.example.zoo.rest.model.cage.CageRequestModel;
import com.example.zoo.rest.model.cage.CageResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CageService.class);

    private final CageRepository cageRepository;

    public CageService(CageRepository cageRepository) {
        this.cageRepository = cageRepository;
    }

    public CageResponseModel create(CageRequestModel cageRequestModel){
        LOGGER.info("Requsest to created cage - {}",cageRequestModel);
        Cage cage = buildCageFrom(cageRequestModel);
        return buildCageResponseModelFrom(cageRepository.save(cage));
    }

    public List<CageResponseModel> selectAllCages(){
        LOGGER.info("Requsest to select all cages");
        List<Cage> cages = cageRepository.findAll();
        return cages.stream()
                .map(this::buildCageResponseModelFrom).collect(Collectors.toList());
    }

    public CageResponseModel findCageById(Long id){
        LOGGER.info("Geting cage by id - {}",id);
        Cage cage = cageRepository.findById(id).get();
        return buildCageResponseModelFrom(cage);
    }

    public CageResponseModel update(Long id,CageRequestModel cageRequestModel){
        LOGGER.info("Updating by id - {}",id);
        Cage findCageById = cageRepository.findById(id).get();
        findCageById.setCageNumber(cageRequestModel.getCageNumber());
        findCageById.setType(cageRequestModel.getType());
        return buildCageResponseModelFrom(findCageById);
    }

    public void delete(Long id){
        LOGGER.info("Deleting by id - {}",id);
        cageRepository.deleteById(id);
        LOGGER.info("Deleted by id - {}",id);
    }

    private Cage buildCageFrom(CageRequestModel cageRequestModel){
        Cage cage = new Cage();
        cage.setCageNumber(cageRequestModel.getCageNumber());
        cage.setType(cageRequestModel.getType());
        return cage;
    }

    private CageResponseModel buildCageResponseModelFrom(Cage cage){
        CageResponseModel cageResponseModel = new CageResponseModel();
        cageResponseModel.setId(cage.getId());
        cageResponseModel.setCreateAt(cage.getCreate_at());
        cageResponseModel.setCageNumber(cage.getCageNumber());
        cageResponseModel.setType(cage.getType());
        return cageResponseModel;
    }
}
