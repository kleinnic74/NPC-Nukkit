package com.GhostKilllaX.NPC.entitys;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;


public class NPC_Creeper extends NPC_Entity{

    public static final int NID = 33;

    public NPC_Creeper(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
    

    @Override
    public int getNetworkId() {
        return NID;
    }


}
