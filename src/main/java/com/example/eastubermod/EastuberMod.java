package com.example.eastubermod;

import com.example.eastubermod.effect.ModEffect;
import com.example.eastubermod.effect.RageEffect;
import com.example.eastubermod.effect.RageEffectCallback;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
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
//		// This code runs as soon as Minecraft is in a mod-load-ready state.
//		// However, some things (like resources) may still be uninitialized.
//		// Proceed with mild caution.
//        return ActionResult.PASS;
        ModEffect.registerEffects();



        RageEffectCallback.EVENT.register((player) -> {
            if(player.horizontalCollision) {
                player.addStatusEffect(new StatusEffectInstance(ModEffect.rage,666,0,true,true,true));
            }
            return ActionResult.FAIL;
        });


		LOGGER.info("EASTUBER CRAFT!");
        }

//    @Override
//    public void activateRageEffect(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
//        if(player.horizontalCollision){
//            player.addStatusEffect(new StatusEffectInstance(ModEffect.rage,666,0,true,true,true));
//        }
//    }
//
//
//

}