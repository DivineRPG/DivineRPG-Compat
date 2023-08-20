package divinerpg.divinerpg_compatability.mystical_agriculture;

import divinerpg.DivineRPG;

import java.io.*;
import java.util.*;

public class MysticalCustomizationCompat {
    public static void init() {

        Map<String, String> jsonContentMap = new HashMap<>();
        jsonContentMap.put("apalachia_fragments.json", generateApalachiaFragmentsJSON());

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
    private static String generateApalachiaFragmentsJSON() {
        return "{\n" +
                "    \"name\": \"Apalachia Fragments\",\n" +
                "    \"type\": \"mysticalagriculture:resource\",\n" +
                "    \"tier\": \"mysticalagriculture:6\",\n" +
                "    \"ingredient\": {\n" +
                "        \"item\": \"divinerpg:apalachia_fragments\"\n" +
                "    },\n" +
                "    \"color\": \"a200b7\",\n" +
                "    \"textures\": {\n" +
                "        \"flower\": \"mysticalagriculture:block/flower_gem\",\n" +
                "        \"essence\": \"mysticalagriculture:item/essence_gem\",\n" +
                "        \"seeds\": \"mysticalagriculture:item/mystical_seeds\"\n" +
                "    },\n" +
                "    \"baseSecondaryChance\": 0.4,\n" +
                "    \"crux\": \"divinerpg:apalachia_block\"\n" +
                "}";
    }
}
