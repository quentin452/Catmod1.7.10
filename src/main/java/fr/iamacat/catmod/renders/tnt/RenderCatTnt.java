// tnt rendering
package fr.iamacat.catmod.renders.tnt;

import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.catmod.entities.tnt.EntityCatTnt;
import fr.iamacat.catmod.models.ModelCatTnt;

@SideOnly(Side.CLIENT)
public class RenderCatTnt extends RenderTNTPrimed {

    private static final ResourceLocation CAT_TNT_TEXTURE = new ResourceLocation("textures/entity/cat_tnt.png");

    @Override
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity instanceof EntityCatTnt) {
            EntityCatTnt entityCatTnt = (EntityCatTnt) entity;
            bindEntityTexture(entity);

            GL11.glPushMatrix();
            GL11.glTranslatef((float) x, (float) y, (float) z);
            GL11.glRotatef(
                entityCatTnt.prevRotationYaw + (entityCatTnt.rotationYaw - entityCatTnt.prevRotationYaw) * partialTicks
                    - 90.0F,
                0.0F,
                1.0F,
                0.0F);
            GL11.glTranslatef(0.0F, -1.0F, 0.0F);
            GL11.glRotatef(-entityCatTnt.rotationYaw, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-1.0F, -1.0F, 1.0F);

            // render the custom model here
            ModelCatTnt model = new ModelCatTnt();
            model.render(entityCatTnt, 0.0F, 0.0F, 0.0F, entityYaw, 0.0F, 0.0625F);

            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return CAT_TNT_TEXTURE;
    }
}
