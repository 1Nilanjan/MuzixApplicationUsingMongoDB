package com.stackroute.MuzixApplication.globalexception;

import com.stackroute.MuzixApplication.exceptions.SongAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.SongNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException
{
    @ResponseStatus(value = HttpStatus.CONFLICT, reason="Song already exists")
    @ExceptionHandler(SongAlreadyExistsException.class)
    public void handleSongAlreadyExistsException(SongAlreadyExistsException exc1)
    {
        //log.error("Song already exists");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason="User does not exist")
    @ExceptionHandler(SongNotFoundException.class)
    public void handleSongNotFoundException(SongNotFoundException exc2)
    {
        //log.error("User does not exist");
    }
}
