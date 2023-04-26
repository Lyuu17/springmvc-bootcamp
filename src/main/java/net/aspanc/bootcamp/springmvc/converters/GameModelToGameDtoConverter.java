package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class GameModelToGameDtoConverter implements Converter<GameModel, GameDto> {

    @Override
    public GameDto convert(GameModel model) {
        Assert.notNull(model, "GameModel can't be null");

        GameDto dto = new GameDto();

        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());
        dto.setSteamId(model.getSteamId());

        return dto;
    }
}
