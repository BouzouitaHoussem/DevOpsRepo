package com.cataloguetheway.center.config.controller;

import com.cataloguetheway.center.config.dto.imageDto;
import com.cataloguetheway.center.config.services.implem.AlbumImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AlbumController {

    @Autowired
    private AlbumImpl albumService;

    @GetMapping(value="album/{idTrain}")
    public List<imageDto> getonealbum(@PathVariable Integer idTrain){
       return albumService.getAlbumByIdTrain(idTrain);
    }

    @RequestMapping(value="/crud-Album/{idTrain}",consumes={MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public void crudAlbum(@RequestPart(value = "images",required = false) MultipartFile[] files, @RequestPart(value = "tabIdDelete",required = false) String tabId, @PathVariable Integer idTrain) throws Exception {

        albumService.crudAlbum(files,tabId,idTrain);

    }

   /* @PostMapping(value="/add-Album/{idTrain}",consumes={ MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    public void addAlbum(@RequestPart(value = "images") MultipartFile[] files,@PathVariable Integer idTrain) throws Exception {

        albumService.addAlbum(files,idTrain);
    }*/

    @DeleteMapping(value = "/delete-album/{id}")
    public void deleteoneAlbum(@PathVariable Integer id){
        albumService.deleteAlbumFromIdTraining(id);
    }

    @RequestMapping(value = "/delete-oneimage/{folder}")
    public void deleteone(@PathVariable Integer folder,@RequestParam("name") String nameImage){
        albumService.deleteByname(folder,nameImage);
    }


}
