package com.wumple.cannycomposter.util.config;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.toml.TomlFormat;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigUtil
{
    public static <V> void handlePairConfig(Config config, Map<String, V> map)
    {
        config.entrySet().forEach((e) -> {
            map.put(e.getKey(), e.getValue());
        });
    }

    /// shortcut to build a config value for a key/value set
    public static ForgeConfigSpec.ConfigValue<Config> buildSet(ForgeConfigSpec.Builder builder, String name, String comment)
    {
        // Example from https://github.com/gigaherz/Survivalist/blob/1.14/src/main/java/gigaherz/survivalist/ConfigManager.java#L131
        ForgeConfigSpec.ConfigValue<Config> value = builder
                .comment(comment)
                .define(Arrays.asList(name),
                        () -> Config.of(TomlFormat.instance()),
                        x -> true,
                        Config.class);

        return value;
    }

    /// make r process config set c, clear the mirrored map, and read c into the mirrored map
    public static void handleConfigSet(Config c, Consumer<Config> r, Map<String,?> map)
    {
        r.accept(c);
        map.clear();
        com.wumple.cannycomposter.util.config.ConfigUtil.handlePairConfig(c, map);
    }
}
