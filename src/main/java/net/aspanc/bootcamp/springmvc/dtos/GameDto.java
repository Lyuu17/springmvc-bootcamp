package net.aspanc.bootcamp.springmvc.dtos;

import lombok.Data;

@Data
public class GameDto {

    private Long id;

    private String title;

    private String description;

    private Integer steamId;
}
