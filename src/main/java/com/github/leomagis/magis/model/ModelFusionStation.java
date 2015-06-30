package com.github.leomagis.magis.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFusionStation extends ModelBase {

    private static final double DEG_TO_RAD_FACTOR = 0.017453293;

    ModelRenderer Base;

    ModelRenderer Plate1;
    ModelRenderer Plate2;
    ModelRenderer Plate3;
    ModelRenderer Plate4;

    ModelRenderer Frame1;
    ModelRenderer Frame2;
    ModelRenderer Frame3;
    ModelRenderer Frame4;

    ModelRenderer InFrame1;
    ModelRenderer InFrame2;
    ModelRenderer InFrame3;
    ModelRenderer InFrame4;
    ModelRenderer InFrame5;
    ModelRenderer InFrame6;
    ModelRenderer InFrame7;
    ModelRenderer InFrame8;
    ModelRenderer InFrame9;
    ModelRenderer InFrame10;
    ModelRenderer InFrame11;
    ModelRenderer InFrame12;
    ModelRenderer InFrame13;
    ModelRenderer InFrame14;
    ModelRenderer InFrame15;
    ModelRenderer InFrame16;
    ModelRenderer InFrame17;
    ModelRenderer InFrame18;
    ModelRenderer InFrame19;
    ModelRenderer InFrame20;

    public ModelFusionStation() {
        textureWidth = 128;
        textureHeight = 128;

        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(-14F, 0F, -8F, 32, 1, 32);
        Base.setRotationPoint(-2F, 23F, -8F);
        Base.setTextureSize(128, 128);
        Base.mirror = true;

        Plate1 = new ModelRenderer(this, 34, 8);
        Plate1.addBox(0F, 0F, 0F, 6, 1, 6);
        Plate1.setRotationPoint(2F, 22F, 2F);
        Plate1.setTextureSize(128, 128);
        Plate1.mirror = true;

        Plate2 = new ModelRenderer(this, 34, 8);
        Plate2.addBox(0F, 0F, 0F, 6, 1, 6);
        Plate2.setRotationPoint(8F, 22F, -2F);
        Plate2.setTextureSize(128, 128);
        Plate2.mirror = true;
        setRotation(Plate2, 0.0, 180.0, 0.0);

        Plate3 = new ModelRenderer(this, 34, 8);
        Plate3.addBox(0F, 0F, 0F, 6, 1, 6);
        Plate3.setRotationPoint(-2F, 22F, -2F);
        Plate3.setTextureSize(128, 128);
        Plate3.mirror = true;
        setRotation(Plate3, 0.0, 180.0, 0.0);

        Plate4 = new ModelRenderer(this, 34, 8);
        Plate4.addBox(0F, 0F, 0F, 6, 1, 6);
        Plate4.setRotationPoint(-8F, 22F, 2F);
        Plate4.setTextureSize(128, 128);
        Plate4.mirror = true;

        Frame1 = new ModelRenderer(this, 0, 31);
        Frame1.addBox(-16F, 0F, 0F, 32, 1, 1);
        Frame1.setRotationPoint(0F, 22F, 15F);
        Frame1.setTextureSize(128, 128);
        Frame1.mirror = true;

        Frame2 = new ModelRenderer(this, 0, 31);
        Frame2.addBox(-16F, 0F, 0F, 32, 1, 1);
        Frame2.setRotationPoint(0F, 22F, -16F);
        Frame2.setTextureSize(128, 128);
        Frame2.mirror = true;

        Frame3 = new ModelRenderer(this, 0, 31);
        Frame3.addBox(-14F, 0F, 0F, 30, 1, 1);
        Frame3.setRotationPoint(15F, 22F, 1F);
        Frame3.setTextureSize(128, 128);
        Frame3.mirror = true;
        setRotation(Frame3, 0.0, 90.0, 0.0);

        Frame4 = new ModelRenderer(this, 0, 31);
        Frame4.addBox(-14F, 0F, 0F, 30, 1, 1);
        Frame4.setRotationPoint(-16F, 22F, 1F);
        Frame4.setTextureSize(128, 128);
        Frame4.mirror = true;
        setRotation(Frame4, 0.0, 90.0, 0.0);

        InFrame1 = new ModelRenderer(this, 0, 31);
        InFrame1.addBox(0F, 0F, 0F, 11, 1, 2);
        InFrame1.setRotationPoint(-12F, 22F, -1F);
        InFrame1.setTextureSize(128, 128);
        InFrame1.mirror = true;
        setRotation(InFrame1, 0.0, 90.0, 0.0);

        InFrame2 = new ModelRenderer(this, 0, 31);
        InFrame2.addBox(0F, 0F, 0F, 11, 1, 2);
        InFrame2.setRotationPoint(-12F, 22F, 12F);
        InFrame2.setTextureSize(128, 128);
        InFrame2.mirror = true;
        setRotation(InFrame2, 0.0, 90.0, 0.0);

        InFrame3 = new ModelRenderer(this, 0, 31);
        InFrame3.addBox(0F, 0F, 0F, 11, 1, 2);
        InFrame3.setRotationPoint(10F, 22F, -1F);
        InFrame3.setTextureSize(128, 128);
        InFrame3.mirror = true;
        setRotation(InFrame3, 0.0, 90.0, 0.0);

        InFrame4 = new ModelRenderer(this, 0, 31);
        InFrame4.addBox(0F, 0F, 0F, 11, 1, 2);
        InFrame4.setRotationPoint(10F, 22F, 12F);
        InFrame4.setTextureSize(128, 128);
        InFrame4.mirror = true;
        setRotation(InFrame4, 0.0, 90.0, 0.0);

        InFrame5 = new ModelRenderer(this, 0, 31);
        InFrame5.addBox(0F, 0F, 0F, 9, 1, 2);
        InFrame5.setRotationPoint(1F, 22F, 10F);
        InFrame5.setTextureSize(128, 128);
        InFrame5.mirror = true;

        InFrame6 = new ModelRenderer(this, 0, 31);
        InFrame6.addBox(0F, 0F, 0F, 9, 1, 2);
        InFrame6.setRotationPoint(-10F, 22F, 10F);
        InFrame6.setTextureSize(128, 128);
        InFrame6.mirror = true;

        InFrame7 = new ModelRenderer(this, 0, 31);
        InFrame7.addBox(0F, 0F, 0F, 9, 1, 2);
        InFrame7.setRotationPoint(1F, 22F, -12F);
        InFrame7.setTextureSize(128, 128);
        InFrame7.mirror = true;

        InFrame8 = new ModelRenderer(this, 0, 31);
        InFrame8.addBox(0F, 0F, 0F, 9, 1, 2);
        InFrame8.setRotationPoint(-10F, 22F, -12F);
        InFrame8.setTextureSize(128, 128);
        InFrame8.mirror = true;

        InFrame9 = new ModelRenderer(this, 0, 31);
        InFrame9.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame9.setRotationPoint(-15F, 22F, -3F);
        InFrame9.setTextureSize(128, 128);
        InFrame9.mirror = true;

        InFrame10 = new ModelRenderer(this, 0, 31);
        InFrame10.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame10.setRotationPoint(-15F, 22F, 1F);
        InFrame10.setTextureSize(128, 128);
        InFrame10.mirror = true;

        InFrame11 = new ModelRenderer(this, 0, 31);
        InFrame11.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame11.setRotationPoint(12F, 22F, 1F);
        InFrame11.setTextureSize(128, 128);
        InFrame11.mirror = true;

        InFrame12 = new ModelRenderer(this, 0, 31);
        InFrame12.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame12.setRotationPoint(12F, 22F, -3F);
        InFrame12.setTextureSize(128, 128);
        InFrame12.mirror = true;

        InFrame13 = new ModelRenderer(this, 0, 31);
        InFrame13.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame13.setRotationPoint(1F, 22F, -12F);
        InFrame13.setTextureSize(128, 128);
        InFrame13.mirror = true;
        setRotation(InFrame13, 0.0, 90.0, 0.0);

        InFrame14 = new ModelRenderer(this, 0, 31);
        InFrame14.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame14.setRotationPoint(-3F, 22F, -12F);
        InFrame14.setTextureSize(128, 128);
        InFrame14.mirror = true;
        setRotation(InFrame14, 0.0, 90.0, 0.0);

        InFrame15 = new ModelRenderer(this, 0, 31);
        InFrame15.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame15.setRotationPoint(1F, 22F, 15F);
        InFrame15.setTextureSize(128, 128);
        InFrame15.mirror = true;
        setRotation(InFrame15, 0.0, 90.0, 0.0);

        InFrame16 = new ModelRenderer(this, 0, 31);
        InFrame16.addBox(0F, 0F, 0F, 3, 1, 2);
        InFrame16.setRotationPoint(-3F, 22F, 15F);
        InFrame16.setTextureSize(128, 128);
        InFrame16.mirror = true;
        setRotation(InFrame16, 0.0, 90.0, 0.0);

        InFrame17 = new ModelRenderer(this, 0, 31);
        InFrame17.addBox(0F, 0F, 0F, 2, 1, 2);
        InFrame17.setRotationPoint(-15F, 22F, 1F);
        InFrame17.setTextureSize(128, 128);
        InFrame17.mirror = true;
        setRotation(InFrame17, 0.0, 90.0, 0.0);

        InFrame18 = new ModelRenderer(this, 0, 31);
        InFrame18.addBox(0F, 0F, 0F, 2, 1, 2);
        InFrame18.setRotationPoint(-1F, 22F, -13F);
        InFrame18.setTextureSize(128, 128);
        InFrame18.mirror = true;
        setRotation(InFrame18, 0.0, 90.0, 0.0);

        InFrame19 = new ModelRenderer(this, 0, 31);
        InFrame19.addBox(0F, 0F, 0F, 2, 1, 2);
        InFrame19.setRotationPoint(-1F, 22F, 15F);
        InFrame19.setTextureSize(128, 128);
        InFrame19.mirror = true;
        setRotation(InFrame19, 0.0, 90.0, 0.0);

        InFrame20 = new ModelRenderer(this, 0, 31);
        InFrame20.addBox(0F, 0F, 0F, 2, 1, 2);
        InFrame20.setRotationPoint(13F, 22F, 1F);
        InFrame20.setTextureSize(128, 128);
        InFrame20.mirror = true;
        setRotation(InFrame20, 0.0, 90.0, 0.0);
    }

    public void render(Entity entity, float param2, float param3, float param4, float param5, float param6, float scale) {
        Base.render(scale);
        Plate1.render(scale);
        Plate2.render(scale);
        Plate3.render(scale);
        Plate4.render(scale);
        Frame1.render(scale);
        Frame2.render(scale);
        Frame3.render(scale);
        Frame4.render(scale);
        InFrame1.render(scale);
        InFrame2.render(scale);
        InFrame3.render(scale);
        InFrame4.render(scale);
        InFrame5.render(scale);
        InFrame6.render(scale);
        InFrame7.render(scale);
        InFrame8.render(scale);
        InFrame9.render(scale);
        InFrame10.render(scale);
        InFrame11.render(scale);
        InFrame12.render(scale);
        InFrame13.render(scale);
        InFrame14.render(scale);
        InFrame15.render(scale);
        InFrame16.render(scale);
        InFrame17.render(scale);
        InFrame18.render(scale);
        InFrame19.render(scale);
        InFrame20.render(scale);
    }

    private void setRotation(ModelRenderer model, double x, double y, double z) {
        model.rotateAngleX = (float) (x * DEG_TO_RAD_FACTOR);
        model.rotateAngleY = (float) (y * DEG_TO_RAD_FACTOR);
        model.rotateAngleZ = (float) (z * DEG_TO_RAD_FACTOR);
    }

}
