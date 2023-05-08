package net.aspanc.bootcamp.springmvc.converters;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamNewsItem;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameNewsDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SteamNewsToSteamGameNewsDtoConverter implements Converter<SteamNewsItem, SteamGameNewsDto> {

    @Override
    public SteamGameNewsDto convert(SteamNewsItem model) {
        Assert.notNull(model, "SteamNewsItem can't be null");

        SteamGameNewsDto dto = new SteamGameNewsDto();
        dto.setTitle(model.getTitle());
        dto.setUrl(model.getUrl());
        dto.setContents(model.getContents());
        dto.setAuthor(model.getAuthor());

        return dto;
    }
}
