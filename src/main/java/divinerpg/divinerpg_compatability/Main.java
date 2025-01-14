package divinerpg.divinerpg_compatability;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "divinerpg_compat";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Main(IEventBus bus, ModContainer container) {
        bus.addListener(this::commonSetup);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModCompat.initCommon(event);
    }

}
