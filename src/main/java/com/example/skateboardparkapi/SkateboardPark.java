package com.example.skateboardparkapi;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skateboard_park")
public class SkateboardPark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The generated skateboard park id", hidden = true)
    private long id;

    @ApiModelProperty(notes = "The name of the skateboard park", required = true)
    private String name;

    @ApiModelProperty(notes = "The location of the skateboard park", required = true)
    private String location;

    public SkateboardPark() {
    }

    public SkateboardPark(String name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("SkateboardPark[id=%d, name='%s', location='%s']",
                id, name, location);
    }
}

