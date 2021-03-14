package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:search.properties"
})
public interface SearchConfig extends Config {

    @Config.Key("text")
    String text();
}