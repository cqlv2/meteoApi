package dev.controller;

import dev.dto.polluant.PolluantDtoQuery;
import dev.dto.polluant.PolluantDtoResponse;
import dev.entity.Polluant;
import dev.service.PolluantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Admin/polluant")
public class PolluantCtrl extends SuperController<Polluant, PolluantService, PolluantDtoQuery, PolluantDtoResponse>{

  
}
