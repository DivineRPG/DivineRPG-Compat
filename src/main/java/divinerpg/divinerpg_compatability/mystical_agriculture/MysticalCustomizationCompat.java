package divinerpg.divinerpg_compatability.mystical_agriculture;

import java.io.*;

public class MysticalCustomizationCompat {
    public static void init() throws IOException {
        Writer output = null;

        String apalachiaFragments = "{\n" +
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

        // The Files For All Configs
        File apalachiaFragmentsFile = new File("run/config/mysticalcustomization/crops/apalachia_fragments.json");
//        File arlemiteFile = new File("run/config/mysticalcustomization/crops/arlemite.json");
//        File bloodgemFile = new File("run/config/mysticalcustomization/crops/bloodgem.json");
//        File edenFragmentsFile = new File("run/config/mysticalcustomization/crops/eden_fragments.json");
//        File mortumFragmentsFile = new File("run/config/mysticalcustomization/crops/mortum_fragments.json");
//        File realmiteFile = new File("run/config/mysticalcustomization/crops/realmite.json");
//        File rupeeFile = new File("run/config/mysticalcustomization/crops/rupee.json");
//        File skythernFragmentsFile = new File("run/config/mysticalcustomization/crops/skythern_fragments.json");
//        File torriditeFile = new File("run/config/mysticalcustomization/crops/torridite.json");
//        File wildwoodFragmentsFile = new File("run/config/mysticalcustomization/crops/wildwood_fragments.json");

        // Outputting the Files
        output = new BufferedWriter(new FileWriter(apalachiaFragmentsFile));
        output.write(apalachiaFragments);

//        output = new BufferedWriter(new FileWriter(arlemiteFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(bloodgemFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(edenFragmentsFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(mortumFragmentsFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(realmiteFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(rupeeFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(skythernFragmentsFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(torriditeFile));
//        output.write(apalachiaFragments);
//
//        output = new BufferedWriter(new FileWriter(wildwoodFragmentsFile));
//        output.write(apalachiaFragments);

        output.close();
    }
}
