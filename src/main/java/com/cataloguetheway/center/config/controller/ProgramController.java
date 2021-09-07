package com.cataloguetheway.center.config.controller;

import com.cataloguetheway.center.config.DaoTraining.PartDao;
import com.cataloguetheway.center.config.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProgramController {

    @Autowired
    private PartDao programmeDao;

    @GetMapping(value = "/program")
    public List<Part> allPart() {
        List<Part> programme = programmeDao.findAll();
        return programme;
    }

    @PostMapping(value = "/add-Part")
    public ResponseEntity<Void> addPart(@Validated @RequestBody Part Part) {

        Part programmeAdded = programmeDao.save(Part);

        if (programmeAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(programmeAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

  /*  @PutMapping(value = "/update-programme")
    public void updateProgramme(@RequestBody Part[] programme) {
        programmeDao.save(programme);
    }

    @DeleteMapping(value = "/delete-programme/{id}")
    public void deleteCategorie(@PathVariable Integer id) {
        programmeDao.delete(id);
    }
*/




}
