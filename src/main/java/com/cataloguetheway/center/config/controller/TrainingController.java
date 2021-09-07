package com.cataloguetheway.center.config.controller;

import com.cataloguetheway.center.config.dto.TrainDescrDto;
import com.cataloguetheway.center.config.dto.TrainDto;
import com.cataloguetheway.center.config.model.Training;
import com.cataloguetheway.center.config.services.implem.TrainingImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
/*@RequestMapping("/trainings")*/
public class TrainingController {

    @Autowired
    private TrainingImpl trainingImpl ;

    @GetMapping(value="/trainingList/{plus}")
    public List<Training> allFormation (@PathVariable Integer plus){
        List<Training> trainings = trainingImpl.getByLot(plus*3);
        return trainings ;
    }

    @GetMapping(value="/TrainingByLotCategoty/{categorie}/{plus}")
    public List<Training> lotTrainingByCategorie (@PathVariable String categorie, @PathVariable Integer plus){
        List<Training> trainings = trainingImpl.getTrainingByLotCategory(categorie,4*plus);
        return trainings ;
    }

    @GetMapping(value="/training")
    public List<Training> allFormation (){
        List<Training> trainings = trainingImpl.all();
        return trainings ;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value="/tab-training")
    public List<TrainDto> tabTraining (){
        List<TrainDto> trainings = trainingImpl.getforTableTraining();
        return trainings ;
    }

    @PutMapping(value="/updateTabtraining",consumes={ MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })

    public void updateTabTrainingTab (@RequestPart(value = "image",required = false) MultipartFile file,@RequestPart("training") String training) throws Exception {
        Training forma = new ObjectMapper().readValue(training, Training.class);
        forma.setImage(file.getBytes());
        trainingImpl.updateforTable(forma);
    }

    @GetMapping(value="/training/{id}")
    public Optional<Training> gettrainingById(@PathVariable Integer id){
        Optional<Training> training  = Optional.ofNullable(trainingImpl.getElementById(id));

        if (!training.isPresent())
            throw new TrainingNotFoundException("La training correspondent à l'id " + id + " n'existe pas");
        return training ;
    }

    @GetMapping(value="/trainingelem/{idf}")
    public Training getByIdFrond(@PathVariable String idf){
        Training training  = trainingImpl.searchByFrond(idf);
        return training;
    }

    @PostMapping(value = "/add-training",consumes={ MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    //@Validated @RequestBody Formation training)
    public ResponseEntity<Void> addTraining(@RequestPart(value = "image",required = false) MultipartFile file,@RequestPart(value = "progPJ",required = false) MultipartFile progPJ,
                                             @RequestPart("training") String training) throws Exception

    {

        Training train = new ObjectMapper().readValue(training, Training.class);
        train.setImage(file.getBytes());
          if(progPJ != null)train.setProgPJ(progPJ.getBytes());
        Training trainingAdded = trainingImpl.add(train);

        if (trainingAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(trainingAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/update-training",consumes={ MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
      public void updateTrainig (@RequestPart(value = "image",required = false) MultipartFile file,
                                  @RequestPart("training") String training) throws Exception
    {

        Training forma = new ObjectMapper().readValue(training, Training.class);
        forma.setImage(file.getBytes());
        trainingImpl.update(forma);
    }

    @GetMapping(value="/trainingByCategoty/{categorie}")
    public List<Training> allFormationElem (@PathVariable String categorie) {
      List<Training> trainingByCat = trainingImpl.searchBycategory(categorie);
      return trainingByCat;
  }

    @DeleteMapping(value = "/delete-training/{id}")
    public void deleteTraining(@PathVariable Integer id) {
        trainingImpl.delete(id);
    }


    @GetMapping(value = "/training-crdpt/{crdpt}")
    public List<Training> allbylabel(@PathVariable String crdpt) {
        List<Training> categories = trainingImpl.findbycreditPoint(crdpt);
        return categories;
    }

    @GetMapping(value = "/training-front")
    public List<TrainDescrDto> trainingcompact(@RequestParam("plus") Integer plus) throws Exception {
        return trainingImpl.compactTraining(plus);
    }



}
