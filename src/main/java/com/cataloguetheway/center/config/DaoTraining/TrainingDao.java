package com.cataloguetheway.center.config.DaoTraining;

import com.cataloguetheway.center.config.dto.TrainDescrDto;
import com.cataloguetheway.center.config.dto.TrainDto;
import com.cataloguetheway.center.config.model.Training;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingDao extends JpaRepository <Training,Integer>,JpaSpecificationExecutor<Training> {

    @Query("select f from Training f where f.categorie = :categ")
    List<Training> searchTraining(@Param("categ") String categorie);

    @Query("select f from Training f where f.idfrond = :idf")
    Training searchByIDFrond(@Param("idf") String idfrond);

    @Query("select f from Training f where f.theme = :themename")
    List<Training> searchBytheme(@Param("themename") String theme);

    @Query(value = "SELECT * FROM Training  where category = ?1 limit ?2",nativeQuery = true)
    List<Training> getByLotCategory(String categorie, Integer n);

    @Query(value = "SELECT * FROM Training LIMIT 3 OFFSET  ?1 ",nativeQuery = true)
    List<Training> getByLot(Integer e);

    // for tab admin
    @Query( "SELECT new com.cataloguetheway.center.config.dto.TrainDto(t.id,t.titre,t.theme,t.categorie,t.datelancement,t.duree,t.pays,t.idpays,t.region,t.imageName,t.image,t.status,t.creditpnt,t.price) from Training t")
    List<TrainDto> getforTable();

    @Query("SELECT new com.cataloguetheway.center.config.dto.TrainDescrDto(t.id,t.titre,t.theme,t.categorie,t.datelancement,t.duree,t.pays,t.region,t.imageName,t.image,t.status,t.creditpnt,t.price,t.description) from Training t")
    List<TrainDescrDto> getforfront(Pageable pageable);


}
