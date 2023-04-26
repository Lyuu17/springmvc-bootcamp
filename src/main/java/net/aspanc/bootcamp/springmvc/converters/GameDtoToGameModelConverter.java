package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class GameDtoToGameModelConverter implements Converter<GameDto, GameModel> {

    @Override
    public GameModel convert(GameDto dto) {
        Assert.notNull(dto, "GameDto can't be null");

        GameModel model = new GameModel();

        model.setId(dto.getId());
        model.setTitle(dto.getTitle());
        model.setDescription(dto.getDescription());
        model.setSteamId(dto.getSteamId());

        return model;
    }
}
