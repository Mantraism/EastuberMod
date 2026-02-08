package com.example.eastubermod;

import com.example.eastubermod.effect.ModEffect;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EastuberMod implements ModInitializer {
	public static final String MOD_ID = "eastubermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final float HEALTH_THRESHOLD = 4.0F;
    private static final long COOLDOWN_MS = 60_000L * 5;
    private static final int EFFECT_DURATION_TICKS = 666;

    private static final Map<UUID, Long> LAST_TRIGGER = new HashMap<>();


    @Override
	public void onInitialize() {
//		// This code runs as soon as Minecraft is in a mod-load-ready state.
//		// However, some things (like resources) may still be uninitialized.
//		// Proceed with mild caution.
//        return ActionResult.PASS;
        ModEffect.registerEffects();
        activateRageEffect();

		LOGGER.info("EASTUBER CRAFT!");
        }


    static void activateRageEffect() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register(
                ((entity, source, baseDamageTaken, damageTaken, blocked) -> {

                    if (!(entity instanceof ServerPlayerEntity player)) {
                        return;
                    }

                    // Check current health after damage
                    if (player.getHealth() > HEALTH_THRESHOLD) {
                        return;
                    }

                    long now = System.currentTimeMillis();
                    UUID id = player.getUuid();
                    long last = LAST_TRIGGER.getOrDefault(id, 0L);

                    if (now - last < COOLDOWN_MS) {
                        return;
                    }

                    player.addStatusEffect(
                            new StatusEffectInstance(ModEffect.rage,
                                    EFFECT_DURATION_TICKS,      // duration in ticks (5 seconds)
                                    0,                          // amplifier (0 = level 1)
                                    true,                      // ambient
                                    true,                        // show particles
                                    true                        //show icon
                            )
                    );

                    LAST_TRIGGER.put(id, now);
                })
        );
    }

}