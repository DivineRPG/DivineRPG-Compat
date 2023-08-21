package divinerpg.divinerpg_compatability.mystical_agriculture;

import com.google.gson.JsonObject;

import java.io.*;
import java.util.*;

public class MysticalCustomizationCompat {
    public static void init() {

        Map<String, String> jsonContentMap = new HashMap<>();
        jsonContentMap.put("eden_fragments.json", generateJSON("Eden Fragments", 1, "divinerpg:eden_fragments", "FBFF06", "mysticalagriculture:block/flower_gem", "mysticalagriculture:item/essence_gem", "mysticalagriculture:item/mystical_seeds", 0.4, "divinerpg:eden_block"));
        jsonContentMap.put("wildwood_fragments.json", generateJSON("Wildwood Fragments", 2, "divinerpg:wildwood_fragments", "#064AFF", "mysticalagriculture:block/flower_gem", "mysticalagriculture:item/essence_gem", "mysticalagriculture:item/mystical_seeds", 0.4, "divinerpg:wildwood_block"));
        jsonContentMap.put("apalachia_fragments.json", generateJSON("Apalachia Fragments", 3, "divinerpg:apalachia_fragments", "a200b7", "mysticalagriculture:block/flower_gem", "mysticalagriculture:item/essence_gem", "mysticalagriculture:item/mystical_seeds", 0.4, "divinerpg:apalachia_block"));
        jsonContentMap.put("skythern_fragments.json", generateJSON("Skythern Fragments", 4, "divinerpg:skythern_fragments", "D6D6D1", "mysticalagriculture:block/flower_gem", "mysticalagriculture:item/essence_gem", "mysticalagriculture:item/mystical_seeds", 0.4, "divinerpg:skythern_block"));
        jsonContentMap.put("mortum_fragments.json", generateJSON("Mortum Fragments", 5, "divinerpg:mortum_fragments", "251E1E", "mysticalagriculture:block/flower_gem", "mysticalagriculture:item/essence_gem", "mysticalagriculture:item/mystical_seeds", 0.4, "divinerpg:mortum_block"));

        // Define the base directory for config files
        String configDir = "config/mysticalcustomization/crops/";

        // Loop through the filenames and write the JSON content to each file
        for (String fileName : jsonContentMap.keySet()) {
            File configFile = new File(configDir + fileName);

            // Ensure parent directories exist
            File parentDir = configFile.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            if (!configFile.exists()) {
                String jsonContent = jsonContentMap.get(fileName);
                try (Writer output = new BufferedWriter(new FileWriter(configFile))) {
                    output.write(jsonContent);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // Define a method to generate JSON content
    private static String generateJSON(String name, int tier, String item, String color, String flowerTexture, String essenceTexture, String seedsTexture, double baseSecondaryChance, String crux) {
        JsonObject json = new JsonObject();
        json.addProperty("name", name);
        json.addProperty("type", "mysticalagriculture:resource");
        json.addProperty("tier", "mysticalagriculture:" + tier);

        JsonObject ingredient = new JsonObject();
        ingredient.addProperty("item", item);
        json.add("ingredient", ingredient);

        json.addProperty("color", color);

        JsonObject textures = new JsonObject();
        textures.addProperty("flower", flowerTexture);
        textures.addProperty("essence", essenceTexture);
        textures.addProperty("seeds", seedsTexture);
        json.add("textures", textures);

        json.addProperty("baseSecondaryChance", baseSecondaryChance);
        json.addProperty("crux", crux);

        return json.toString();
    }
}
