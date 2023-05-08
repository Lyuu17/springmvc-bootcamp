package net.aspanc.bootcamp.springmvc.converters;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Random;

@Component
public class StoreAppDetailsToSteamGameDtoConverter implements Converter<StoreAppDetails, SteamGameDto> {

    @Override
    public SteamGameDto convert(StoreAppDetails model) {
        Assert.notNull(model, "StoreAppDetails can't be null");

        SteamGameDto dto = new SteamGameDto();

        Random rand = new Random();

        dto.setScreenshotUrl(model.getScreenshots().get(rand.nextInt(model.getScreenshots().size())).getFullPath());

        return dto;
    }
}
