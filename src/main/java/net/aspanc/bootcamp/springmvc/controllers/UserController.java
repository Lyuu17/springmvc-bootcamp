package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.dtos.UserDto;
import net.aspanc.bootcamp.springmvc.facades.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("admin/rest/")
public class UserController {

    @Resource
    private UserFacade userFacade;

    @GetMapping("/users")
    private List<UserDto> users(@RequestParam("username") Optional<String> username) {
        return username.isEmpty() ? userFacade.findAll() : userFacade.findByUsername(username.get());
    }

    @PostMapping("/user")
    private ResponseEntity<?> user(@Validated @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.toList()));
        }

        try {
            userFacade.save(userDto);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<UserDto> userById(@PathVariable("id") Long id) {
        return ResponseEntity.of(userFacade.findById(id));
    }

    @PutMapping("/user/{id}")
    private ResponseEntity<?> updateUserById(@PathVariable("id") Long id, @Validated @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.toList()));
        }

        try {
            return userFacade.findById(id).isPresent() ? ResponseEntity.ok(userFacade.save(userDto)) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/user/{id}")
    private ResponseEntity<UserDto> deleteUserById(@PathVariable("id") Long id) {
        Optional<UserDto> userDto = userFacade.findById(id);

        if (userDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userFacade.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
