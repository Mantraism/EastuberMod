package com.example.eastubermod.effect;

import com.example.eastubermod.EastuberMod;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffect {
    public static final RegistryEntry<StatusEffect> rage = registerStatusEffect("rage",
            new RageEffect(StatusEffectCategory.BENEFICIAL, 0xffcc00)
                    .addAttributeModifier(EntityAttributes.JUMP_STRENGTH, Identifier.of(EastuberMod.MOD_ID, "rage"), 0.35f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.ATTACK_SPEED, Identifier.of(EastuberMod.MOD_ID, "rage"), 0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(EastuberMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        EastuberMod.LOGGER.info("Registering Mod effect for " +EastuberMod.MOD_ID);
    }
}
