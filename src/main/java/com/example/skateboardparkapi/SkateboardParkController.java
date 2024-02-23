package com.example.skateboardparkapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skateboard-park")
@Api(value = "skateboard-park-home", description = "Operations to manage skateboard parks")
public class SkateboardParkController {

    private final static Logger LOGGER = Logger.getLogger(SkateboardParkController.class.getName());

    @Autowired
    SkateboardParkRepository skateboardParkRepository;

    //-------------------Retrieve all skateboard parks--------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "View a list of skateboard parks", response = Iterable.class)
    public List<SkateboardPark> getSkateboardParks() {
        LOGGER.log(Level.INFO, "Getting all skateboard parks");
        List<SkateboardPark> result = new ArrayList<>();
        Iterable<SkateboardPark> skateboardParkList = skateboardParkRepository.findAll();
        skateboardParkList.forEach(result::add);
        return result;
    }

    //-------------------Retrieve a skateboard park by id---------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get a skateboard park by id", response = SkateboardPark.class)
    public ResponseEntity<SkateboardPark> getSkateboardPark(@PathVariable long id) {
        LOGGER.log(Level.INFO, "Getting skateboard park with id " + id);
        SkateboardPark skateboardPark = skateboardParkRepository.findById(id);
        if (skateboardPark != null) {
            return new ResponseEntity<>(skateboardPark, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //-------------------Add a skateboard park----------------------------------------------------------------
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Add a new skateboard park")
    public ResponseEntity<SkateboardPark> saveSkateboardPark(@RequestBody SkateboardPark input) {
        LOGGER.log(Level.INFO, "Saving skateboard park " + input.getName());
        SkateboardPark savedPark = skateboardParkRepository.save(input);
        return new ResponseEntity<>(savedPark, HttpStatus.CREATED);
    }

    //-------------------Delete a skateboard park by id--------------------------------------------------------
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/text")
    @ApiOperation(value = "Delete a skateboard park by id")
    public ResponseEntity deleteSkateboardPark(@PathVariable long id) {
        LOGGER.log(Level.INFO, "Deleting skateboard park with id " + id);
        skateboardParkRepository.delete(id);
        return new ResponseEntity<>("Skateboard park deleted successfully", HttpStatus.OK);
    }
}

