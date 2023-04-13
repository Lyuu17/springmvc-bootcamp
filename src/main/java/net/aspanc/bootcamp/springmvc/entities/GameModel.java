package net.aspanc.bootcamp.springmvc.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "games")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "steam_id")
    private Integer steamId;
}
