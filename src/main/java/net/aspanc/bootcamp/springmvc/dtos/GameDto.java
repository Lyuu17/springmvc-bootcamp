package net.aspanc.bootcamp.springmvc.dtos;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class GameDto {

    private Long id;

    @NotEmpty
    private String title;

    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 9, fraction = 0)
    private Integer steamId;
}
