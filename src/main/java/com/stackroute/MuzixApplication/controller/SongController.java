package com.stackroute.MuzixApplication.controller;

import com.stackroute.MuzixApplication.domain.Muzix;
import com.stackroute.MuzixApplication.exceptions.SongAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.SongNotFoundException;
import com.stackroute.MuzixApplication.service.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "an online application that helps users manage music\n" +
        "listed on Music Database\n" +
        "Using this app, a user should be able to search and\n" +
        "manage music.")
public class SongController
{
    public SongService songService;
    public ResponseEntity responseEntity;

    @Autowired
    public SongController(SongService songService)
    {
        this.songService = songService;
    }

    @ApiOperation(value = "saves music tracks")
    @PostMapping("muzix")
    public ResponseEntity<?>saveMuzix(@RequestBody Muzix muzix) throws SongAlreadyExistsException, SongNotFoundException
    {
        return new ResponseEntity<>(songService.saveMuzix(muzix),HttpStatus.OK);
    }

    @ApiOperation(value = "retrieves all music tracks")
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzix()
    {
        return new ResponseEntity<List<Muzix>>(songService.getAllMuzix(),HttpStatus.OK);
    }

    @ApiOperation(value = "updates selected music tracks")
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) throws SongNotFoundException
    {
        return new ResponseEntity<Muzix>(songService.updateMuzix(muzix),HttpStatus.OK);
    }

    @ApiOperation(value = "deleted selected music tracks")
    @DeleteMapping("muzix/{songid}")
    public ResponseEntity<?> delTrack(@PathVariable("songid") int songid) throws SongNotFoundException
    {
        return new ResponseEntity<>(songService.deleteMuzix(songid),HttpStatus.OK);
    }

    @ApiOperation(value = "finds track by the trackname")
    @GetMapping("muzix/{songname}")
    public ResponseEntity<?> getBySongName(@PathVariable("songname") String name) throws SongNotFoundException
    {
        songService.getByName(name);
        responseEntity= new ResponseEntity<Muzix>(songService.getByName(name),HttpStatus.FOUND);
        return responseEntity;
    }


}
