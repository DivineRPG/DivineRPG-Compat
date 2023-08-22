package divinerpg.divinerpg_compatability.iron_jetpacks;

import com.google.gson.JsonObject;

import java.io.*;
import java.util.*;

public class IronJetpacksCompat {
    public static void init() {

        Map<String, String> jsonContentMap = new HashMap<>();
        jsonContentMap.put("arlemite_jetpack.json", generateJSON("arlemite_jetpack", 1, "36D615", 1.5, 10, "tag:forge/ingots/arlemite", 1.5, 480000000, 750, 1.03, 0.19, 0.21, 0.45, 0.39, 2.0, 1.8, 1.9));

        // Define the base directory for config files
        String configDir = "config/ironjetpacks/jetpacks/";

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
    private static String generateJSON(String name, double tier, String color, double armorPoints, double enchantability, String craftingMaterial, double toughness, double capacity, double usage, double verticalSpeed, double verticalAccel, double sidewaysSpeed, double hoverAscendSpeed, double hoverDescendSpeed, double hoverSpeed, double sprintSpeedMultiplier, double sprintFuelMultiplier) {
        JsonObject json = new JsonObject();
        json.addProperty("name", name);
        json.addProperty("disable", false);
        json.addProperty("tier", tier);
        json.addProperty("color", color);
        json.addProperty("armorPoints", armorPoints);
        json.addProperty("enchantability", enchantability);
        json.addProperty("craftingMaterial", craftingMaterial);
        json.addProperty("toughness", toughness);
        json.addProperty("capacity", capacity);
        json.addProperty("usage", usage);
        json.addProperty("speedVertical", verticalSpeed);
        json.addProperty("accelVertical", verticalAccel);
        json.addProperty("speedSideways", sidewaysSpeed);
        json.addProperty("speedHoverAscend", hoverAscendSpeed);
        json.addProperty("speedHoverDescend", hoverDescendSpeed);
        json.addProperty("speedHover", hoverSpeed);
        json.addProperty("sprintSpeedMulti", sprintSpeedMultiplier);
        json.addProperty("sprintFuelMulti", sprintFuelMultiplier);

        return json.toString();
    }
}
