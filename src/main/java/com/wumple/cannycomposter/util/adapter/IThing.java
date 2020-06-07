package com.wumple.cannycomposter.util.adapter;

import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public interface IThing extends ICapabilityProvider
{

    ICapabilityProvider capProvider();

    @Override
    @Nullable
    default <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing)
    {
        ICapabilityProvider provider = capProvider();
        return (provider != null) ? provider.getCapability(capability, facing) : null;
    }

    ArrayList<String> getNameKeys();
}