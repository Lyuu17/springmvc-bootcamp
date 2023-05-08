package net.aspanc.bootcamp.springmvc.configurations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class SteamAPIProperties {

    @Value("${steamapi.news.content.max}")
    private Integer newsMaxContentLength;

    @Value("${steamapi.news.items.max}")
    private Integer newsMaxItems;
}
