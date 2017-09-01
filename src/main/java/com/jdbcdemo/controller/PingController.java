package com.jdbcdemo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ping Test Controller.
 */
@RestController
@RequestMapping("/ping")
public class PingController {
    /**
     * GET operation.
     *
     * @return status
     */
    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public final ResponseEntity<?> get() {
        return new ResponseEntity<>("pong", new HttpHeaders(), HttpStatus.OK);
    }
}
