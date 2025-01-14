package divinerpg.divinerpg_compatability;

import divinerpg.divinerpg_compatability.iron_jetpacks.IronJetpacksCompat;
import divinerpg.divinerpg_compatability.mystical_agriculture.MysticalCustomizationCompat;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModCompat {
    public static void initCommon(FMLCommonSetupEvent e) {
        if (ModList.get().isLoaded("mysticalcustomization")) {
            MysticalCustomizationCompat.init();
        }
        if (ModList.get().isLoaded("ironjetpacks")) {
            IronJetpacksCompat.init();
        }
    }
}