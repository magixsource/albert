package gl.linpeng.ai.commons.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * Albert Converter Manager
 */
public class AlbertConverterManager {

    private Map<Class<?>, AlbertConverter> converterMap = new HashMap<>();

    private static final AlbertConverterManager INSTANCE = new AlbertConverterManager();

    private AlbertConverterManager() {
    }

    public static AlbertConverterManager getInstance() {
        return INSTANCE;
    }

    public void registerConverter(Class<?> clazz, AlbertConverter converter) {
        converterMap.put(clazz, converter);
    }


}
