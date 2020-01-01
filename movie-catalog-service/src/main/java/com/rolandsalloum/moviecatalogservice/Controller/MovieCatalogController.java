package com.rolandsalloum.moviecatalogservice.Controller;


import com.rolandsalloum.moviecatalogservice.model.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {


    /** get all rated movie Ids
        For each movie Id, call movie info service and get details
        put them in a list **/

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId){

        return Collections.emptyList();
    }




}
