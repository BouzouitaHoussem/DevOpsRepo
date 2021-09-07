package com.cataloguetheway.center.config.controller;

import com.cataloguetheway.center.config.model.Category;
import com.cataloguetheway.center.config.services.implem.CategoryImpl;
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
public class CategoryController {

    @Autowired
    private CategoryImpl categoryServ;

    @GetMapping(value = "/categorie")
    public List<Category> allCategories() {
        List<Category> categories = categoryServ.all();
        return categories;
    }

    @PostMapping(value = "/add-categorie")
    public ResponseEntity<Void> ad_cat(@Validated @RequestBody Category categor) {

        LocalDate local_Date = LocalDate.now();
        categor.setAddDate(local_Date);

        Category categoriead = categoryServ.add(categor);

        if (categoriead  == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriead.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping(value="/category/{id}")
    public Optional<Category> getcategorieById(@PathVariable Integer id){
        Optional<Category> categorie  = Optional.ofNullable(categoryServ.getElementById(id));
        if (!categorie.isPresent())
            throw new TrainingNotFoundException("à créer l'exception de catégorie");

        return categorie ;
    }

    @GetMapping(value="/categoriesByTheme/{theme}")
    public List<Category> allCategorieByTheme (@PathVariable String theme){
        List<Category> categorieBythe = categoryServ.CategoryByTheme(theme);
        return categorieBythe;
    }

    @PutMapping(value = "/update-category")
    public void updateCategorie(@RequestBody Category categories) {
        categoryServ.update(categories);
    }

    @DeleteMapping(value = "/delete-category/{id}")
    public void deleteCategorie(@PathVariable Integer id) {
        categoryServ.delete(id);
    }


}
