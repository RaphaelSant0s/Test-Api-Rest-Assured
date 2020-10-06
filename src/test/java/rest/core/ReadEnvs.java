package rest.core;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static rest.core.Hooks.scenarioTag;

public class ReadEnvs {

    private LinkedHashSet<Object> loadAsJavaObject() throws Exception {
        Yaml yaml = new Yaml();
        String tag = scenarioTag;
        InputStream inputStream = ReadEnvs.class
                .getClassLoader()
                .getResourceAsStream("env.yml");
        ArrayList<LinkedHashMap> obj = yaml.load(inputStream);
        return obj.stream().filter(m -> m.get("Tag").equals(tag))
                .collect((Collector<? super LinkedHashMap, Object, LinkedHashSet<Object>>) Collectors.toCollection( LinkedHashSet::new ));

    }



}
