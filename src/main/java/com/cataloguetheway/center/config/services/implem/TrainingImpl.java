package com.cataloguetheway.center.config.services.implem;

import com.cataloguetheway.center.config.DaoTraining.EntitySpecification;
import com.cataloguetheway.center.config.DaoTraining.SearchCriteria;
import com.cataloguetheway.center.config.DaoTraining.SearchOperation;
import com.cataloguetheway.center.config.DaoTraining.TrainingDao;
import com.cataloguetheway.center.config.dto.TrainDescrDto;
import com.cataloguetheway.center.config.dto.TrainDto;
import com.cataloguetheway.center.config.model.Training;
import com.cataloguetheway.center.config.services.TrainingInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingImpl extends CrudAllEntity<TrainingDao,Training> implements TrainingInt {

    @Autowired
    private AlbumImpl albumService;

    public List<Training> getByLot(Integer n){
        return this.entityDao.getByLot(n); }

    public List<Training> searchBycategory(String categorie){
        return this.entityDao.searchTraining(categorie); }

    public List<Training> searchBytheme(String theme){
        return this.entityDao.searchBytheme(theme); }

    public Training searchByFrond(String idfrond){
        return this.entityDao.searchByIDFrond(idfrond); }

    public List<Training> getTrainingByLotCategory(String categorie, Integer n){
        return this.entityDao.getByLotCategory(categorie,n);}

    public List<TrainDto> getforTableTraining(){
        return this.entityDao.getforTable();
        }

    public void updateforTable (Training m){

        Training training = this.getOneEntity(m.getId());
        training.setTitre(m.getTitre());
        training.setTheme(m.getTheme());
        training.setCategorie(m.getCategorie());
        training.setDatelancement(m.getDatelancement());
        training.setDuree (m.getDuree());
        training.setPays (m.getPays());
        training.setIdpays (m.getIdpays());
        training.setRegion (m.getRegion());
        training.setImageName(m.getImageName());
        training.setImage (m.getImage());
        training.setStatus (m.getStatus());
        training.setCreditpnt(m.getCreditpnt());
        training.setPrice (m.getPrice());
        this.update(training);
    }

    public List<Training> findbycreditPoint(String crdpt) {

        Integer crdptn =Integer.parseInt(crdpt);
        EntitySpecification specif = new EntitySpecification();
        specif.add(new SearchCriteria("creditpnt", crdptn, SearchOperation.EQUAL));
        List<Training> Train = entityDao.findAll(specif);
        return Train;
    }

    public List<TrainDescrDto> compactTraining(Integer plus){
         Pageable pageable = PageRequest.of(plus, 2);
        return entityDao.getforfront(pageable);
    }

    public void deletefilsAlbum(Integer idTrain){
        albumService.deleteAlbumFromIdTraining(idTrain);

    }

    @Override
    public void delete(Integer id) {
        this.deletefilsAlbum(id);
        entityDao.deleteById(id);

    }
}
