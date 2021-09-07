package com.cataloguetheway.center.config.services;

import com.cataloguetheway.center.config.dto.TrainDescrDto;
import com.cataloguetheway.center.config.dto.TrainDto;
import com.cataloguetheway.center.config.model.Training;

import java.util.List;

public interface TrainingInt {

    public List<Training> getByLot(Integer n);
    public List<Training> searchBycategory(String categorie);
    public List<Training> searchBytheme(String theme);
    public Training searchByFrond(String idfrond);
    public List<Training> getTrainingByLotCategory(String categorie, Integer n);
    public List<TrainDto> getforTableTraining();
    public void updateforTable (Training menu);
    public List<Training> findbycreditPoint(String crdpt);
    public List<TrainDescrDto> compactTraining(Integer plus);
    public void deletefilsAlbum(Integer idAlbum);

}
