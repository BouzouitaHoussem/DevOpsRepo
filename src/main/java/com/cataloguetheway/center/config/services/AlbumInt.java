package com.cataloguetheway.center.config.services;

import org.springframework.web.multipart.MultipartFile;

public interface AlbumInt {

    public void crudAlbum(MultipartFile[] files, String tabId, Integer idTrain) throws Exception ;
   // public Album getAlbumByIdTrain(Integer id);

}
