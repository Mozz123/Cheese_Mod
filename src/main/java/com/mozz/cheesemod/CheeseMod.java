package com.mozz.cheesemod;

import com.mojang.logging.LogUtils;
import com.mozz.cheesemod.registry.ModBlocks;
import com.mozz.cheesemod.registry.ModItems;
import com.mozz.cheesemod.setup.ClientEventHandler;
import com.mozz.cheesemod.setup.CommonEventHandler;
import com.tterrag.registrate.Registrate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@Mod("cheesemod")
public class CheeseMod {

    public static final String MODID = "cheesemod";
    public static final String MOD_NAME = "CheeseMod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static Registrate REGISTRATE;

    public CheeseMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(ClientEventHandler::init);
        modEventBus.addListener(CommonEventHandler::init);

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        REGISTRATE = Registrate.create(CheeseMod.MODID).creativeModeTab(CheeseTab::new, "Cheese Mod");
        ModItems.load();
        ModBlocks.load();

        forgeBus.register(this);
    }

    public void setup(final FMLCommonSetupEvent event) {
    }
}
