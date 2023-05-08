package net.aspanc.bootcamp.springmvc.dtos;

import lombok.Data;

@Data
public class SteamGameNewsDto {

    private String title;

    private String url;

    private String author;

    private String contents;
}
