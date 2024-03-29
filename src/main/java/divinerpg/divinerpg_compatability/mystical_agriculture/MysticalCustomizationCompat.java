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

        jsonContentMap.put("arlemite_ingot.json", generateJSON("Arlemite Ingot", 5, "divinerpg:arlemite_ingot", "9DD75A", "mysticalagriculture:block/flower_ingot", "mysticalagriculture:item/essence_ingot", "mysticalagriculture:item/mystical_seeds", 0.4));
        jsonContentMap.put("bloodgem.json", generateJSON("Bloodgem", 4, "divinerpg:bloodgem", "E76587", "mysticalagriculture:block/flower_gem", "mysticalagriculture:item/essence_gem", "mysticalagriculture:item/mystical_seeds", 0.4));
        jsonContentMap.put("realmite_ingot.json", generateJSON("Realmite Ingot", 3, "divinerpg:realmite_ingot", "E48E2A", "mysticalagriculture:block/flower_ingot", "mysticalagriculture:item/essence_ingot", "mysticalagriculture:item/mystical_seeds", 0.4));
        jsonContentMap.put("rupee_ingot.json", generateJSON("Rupee Ingot", 5, "divinerpg:rupee_ingot", "3BC6E4", "mysticalagriculture:block/flower_ingot", "mysticalagriculture:item/essence_ingot", "mysticalagriculture:item/mystical_seeds", 0.4));
        jsonContentMap.put("torridite_ingot.json", generateJSON("Torridite Ingot", 5, "divinerpg:torridite_ingot", "F45321", "mysticalagriculture:block/flower_ingot", "mysticalagriculture:item/essence_ingot", "mysticalagriculture:item/mystical_seeds", 0.4));

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

    /**
     * Defines a method to generate JSON content (with a crux)
     *
     * @param name The name of the material
     * @param tier The tier of the material
     * @param item The item that represents the material
     * @param color The color of the material
     * @param flowerTexture The texture of the flower for the material
     * @param essenceTexture The texture of the essence for the material
     * @param seedsTexture The texture of the seeds for the material
     * @param baseSecondaryChance The chance for a secondary drop for the material
     * @param crux The crux for the material
     * @return A String representation of the JSON file
     */
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

    /**
     * Defines a method to generate JSON content (without a crux)
     *
     * @param name The name of the material
     * @param tier The tier of the material
     * @param item The item that represents the material
     * @param color The color of the material
     * @param flowerTexture The texture of the flower for the material
     * @param essenceTexture The texture of the essence for the material
     * @param seedsTexture The texture of the seeds for the material
     * @param baseSecondaryChance The chance for a secondary drop for the material
     * @return A String representation of the JSON file
     */
    private static String generateJSON(String name, int tier, String item, String color, String flowerTexture, String essenceTexture, String seedsTexture, double baseSecondaryChance) {
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

        return json.toString();
    }
}
