package net.aspanc.bootcamp.springmvc.controllers;

import com.ibasco.agql.core.exceptions.BadRequestException;
import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("api/v1/games/")
public class GameController {

    @Resource
    private GameFacade gameFacade;

    @Resource
    private MessageSource messageSource;

    @GetMapping("/")
    private ResponseEntity<?> games(@RequestParam("id") Optional<Long> id, @RequestParam("title") Optional<String> title) {
        return id.isEmpty() ? title.isPresent() ? ResponseEntity.of(title.map(t -> gameFacade.findByTitle(t))) : ResponseEntity.ok(gameFacade.findAll()) : ResponseEntity.of(gameFacade.findById(id.get()));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        Optional<GameDto> gameDto = gameFacade.findById(id);

        if (gameDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        gameFacade.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    private ResponseEntity<?> add(@Validated @RequestBody GameDto gameDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.toList()));
        }

        try {
            return ResponseEntity.created(URI.create("game/" + gameFacade.save(gameDto).getId())).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody GameDto gameDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.toList()));
        }

        if (!gameDto.getId().equals(id))
            throw new BadRequestException("GameId mismatch");

        if (gameFacade.findById(id).isEmpty())
            throw new BadRequestException("Invalid GameId");

        try {
            return ResponseEntity.created(URI.create("game/" + gameFacade.save(gameDto).getId())).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/steam/news/{steamId}")
    private ResponseEntity<?> gameNews(@PathVariable("steamId") Integer steamId) {
        return ResponseEntity.of(Optional.ofNullable(gameFacade.getGameNews(steamId)));
    }

    @GetMapping("/steam/details/{steamId}")
    private ResponseEntity<?> gameDetails(@PathVariable("steamId") Integer steamId) {
        return ResponseEntity.of(Optional.ofNullable(gameFacade.getGameDetails(steamId)));
    }
}
