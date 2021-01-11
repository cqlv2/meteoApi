package dev.controller;

import dev.dto.polluant.PolluantDtoQuery;
import dev.entity.Polluant;
import dev.service.PolluantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/polluant")
public class PolluantCtrl extends SuperController<Polluant, PolluantService>{

    /**
     * add a new entry to the database
     *
     * @param dtoQuery an instance of a dto Object parsed with jackson
     * @return a response entity(ok) with 1 value formatted in DTO
     */
    @PostMapping
    public ResponseEntity<?> add(@RequestBody PolluantDtoQuery dtoQuery) {
        return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
    }

    /**
     * edit an entry to the database
     *
     * @param dtoQuery an instance of a dto Object parsed with jackson
     * @return a response entity(ok) with 1 value formatted in DTO
     */
    @PutMapping
    public ResponseEntity<?> edit(@RequestBody PolluantDtoQuery dtoQuery) {
        return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
    }
}
