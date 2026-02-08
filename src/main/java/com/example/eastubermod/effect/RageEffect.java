package com.example.eastubermod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.util.math.Vec3d;


public class RageEffect extends StatusEffect {

    public RageEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity){
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2, 0, false, false,false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 0, false, false,false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2,0,false, false,false));
            return true;
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }



}
