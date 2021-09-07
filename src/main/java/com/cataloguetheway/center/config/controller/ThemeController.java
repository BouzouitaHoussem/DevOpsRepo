package com.cataloguetheway.center.config.controller;

import com.cataloguetheway.center.config.model.Themes;
import com.cataloguetheway.center.config.services.implem.ThemesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ThemeController {

    @Autowired
    private ThemesImpl themeService;

    @GetMapping(value = "/theme")
    public List<Themes> allThemes() {
        List<Themes> themes = themeService.all();
        return themes;
    }

    @PostMapping(value = "/add-theme")
    public ResponseEntity<Void> add_theme(@Validated @RequestBody Themes themeP) {

        LocalDate local_Date = LocalDate.now();
        themeP.setAddDate(local_Date);
        Themes theme = themeService.add(themeP);

        if (theme == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(theme.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value="/theme/{id}")
    public Optional<Themes> getThemeById(@PathVariable Integer id){
        Optional<Themes> theme  = Optional.ofNullable(themeService.getElementById(id));
        if (!theme.isPresent())
            // * TODO créer l'exception relatiof a categorie
            throw new TrainingNotFoundException ("à créer lexception de theme ");
        return theme ;
    }

    @PutMapping(value = "/update-theme")
    public void updateFormation(@RequestBody Themes theme) {
        themeService.update(theme);
    }

    @DeleteMapping(value = "/delete-theme/{id}")
    public void deleteTheme(@PathVariable Integer id) {
        themeService.delete(id);
    }

}
