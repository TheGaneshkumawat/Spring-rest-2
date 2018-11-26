package com.demo.ganesh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="protected",consumes="application/json")
public class ProtectedController {

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("{\"success\":true}");
    }

}
