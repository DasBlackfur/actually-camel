package me.blackfur.actuallycamel.mixin;

import net.minecraft.entity.passive.CamelEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CamelEntity.class)
public class CamelSeatPositionMixin {
    @ModifyArg(method = "getPassengerAttachmentPos",  at = @At(value = "INVOKE", target = "Lorg/joml/Vector3f;<init>(FFF)V"), index = 2)
    public float redirect_camelSeatPosition(float z) {
        if (z == 0.5F) {
            return 0.7F;
        } else if (z <= -0.6F) {
            return 0.0F;
        }
        return z;
    }
}
