package dev.service;

import dev.dto.polluant.PolluantDtoQuery;
import dev.dto.polluant.PolluantDtoResponse;
import dev.entity.Polluant;
import dev.repository.PolluantRepository;
import org.springframework.stereotype.Service;

@Service
public class PolluantService extends SuperService<Polluant, PolluantRepository, PolluantDtoQuery, PolluantDtoResponse>{

}
