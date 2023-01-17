package divinerpg.divinerpg_compatability;

import divinerpg.divinerpg_compatability.mystical_agriculture.MysticalCustomizationCompat;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.io.IOException;

public class ModCompat {
    public static void initCommon(FMLCommonSetupEvent e) throws IOException {
        if (ModList.get().isLoaded("mysticalcustomization")) {
            MysticalCustomizationCompat.init();
        }
    }
}