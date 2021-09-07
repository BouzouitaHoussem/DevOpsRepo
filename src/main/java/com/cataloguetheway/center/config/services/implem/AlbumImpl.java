package com.cataloguetheway.center.config.services.implem;

import com.cataloguetheway.center.config.dto.imageDto;
import com.cataloguetheway.center.config.services.AlbumInt;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


@Service
public class AlbumImpl implements AlbumInt {

    public void crudAlbum(MultipartFile[] files,String tabId, Integer idTrain) throws Exception {

        File dossier = new File("/Albums/" + idTrain);

        if (!dossier.exists() || !dossier.isDirectory()) {
            Path pathAlbum = Paths.get("/Albums/" + idTrain + "/");
            Files.createDirectory(pathAlbum);
        }
        else {

            if(tabId != null) {
                List<String> listName = new ArrayList<String>(Arrays.asList(tabId.split(",")));
                for (String idname : listName)
                {System.out.println(idname);
                    deleteByname(idTrain, idname);}
            }
        }

        String Folder = "/Albums/" + idTrain + "/";
        if(files != null) {

            for (final MultipartFile file : files) {
                Random rand = new Random();
                int randomNum = rand.nextInt(1000000 - 990000) + 990000;
                long time = System.currentTimeMillis();
                String uniqueValue = idTrain + "_" + randomNum + "" + time;
                byte[] image = file.getBytes();
                Path path = Paths.get(Folder + uniqueValue + ".jpg");
                Files.write(path, image);
            }
        }
    }

    public void deleteAlbumFromIdTraining(Integer idTrain) {

        File dossier = new File("/Albums/" + idTrain);

        if (dossier.exists() && dossier.isDirectory()) {

            try {
                FileUtils.deleteDirectory(dossier);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<imageDto> getAlbumByIdTrain(Integer idTrain) {

        File dossier = new File("/Albums/" + idTrain);

        if (dossier.exists() && dossier.isDirectory()) {


            List<imageDto> album = new ArrayList<imageDto>();

            Stream.of(new File("/Albums/" + idTrain + "/").listFiles())
                    .filter(file -> !file.isDirectory())
                    .forEach(file -> {
                        try {
                            imageDto img = new imageDto(file.getName(), Files.readAllBytes(Paths.get(file.getPath())));
                            album.add(img);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            return album;
        } else
            return null;
    }

    public void deleteByname(Integer folder, String nameImg) {

        String pathStr = "/Albums/" + folder+"/";
        nameImg = nameImg.replaceAll("^\"|\"$", "");
        pathStr = pathStr + nameImg;

        File image = new File(pathStr);

        if (image.exists()) { image.delete(); }
    }

}
