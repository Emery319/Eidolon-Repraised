package elucent.eidolon.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import elucent.eidolon.common.entity.AngelArrowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AngelArrowRenderer extends EntityRenderer<AngelArrowEntity> {
    public AngelArrowRenderer(Context erm) {
        super(erm);
    }

    @Override
    public void render(AngelArrowEntity entityIn, float entityYaw, float partialTicks, @NotNull PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int packedLightIn) {
        if (entityIn.internal != null)
            entityRenderDispatcher.getRenderer(entityIn.internal).render(entityIn.internal, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(AngelArrowEntity entity) {
        return entity.internal == null ? new ResourceLocation("unknown") : entityRenderDispatcher.getRenderer(entity.internal).getTextureLocation(entity.internal);
    }
}
