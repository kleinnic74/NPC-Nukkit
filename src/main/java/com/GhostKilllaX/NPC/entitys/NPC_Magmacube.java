package com.GhostKilllaX.NPC.entitys;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;


public class NPC_Magmacube extends NPC_Entity{

    public static final int NID = 42;

    public NPC_Magmacube(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
    

    @Override
    public int getNetworkId() {
        return NID;
    }


}
