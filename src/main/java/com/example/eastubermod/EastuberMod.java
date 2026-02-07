package com.example.eastubermod;

import com.example.eastubermod.effect.ModEffect;
import com.example.eastubermod.effect.RageEffect;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EastuberMod implements ModInitializer {
	public static final String MOD_ID = "eastubermod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
//        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
//            if(entity instanceof PlayerEntity && entity.isInFluid()){
//                ModEffect.registerEffects();
//        });
//		// This code runs as soon as Minecraft is in a mod-load-ready state.
//		// However, some things (like resources) may still be uninitialized.
//		// Proceed with mild caution.
//        return ActionResult.PASS;
        ModEffect.registerEffects();
		LOGGER.info("Hello Fabric world!");
        }
    }
}