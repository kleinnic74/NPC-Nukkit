package com.GhostKilllaX.NPC.entitys;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;


public class NPC_SHorse extends NPC_Entity{

    public static final int NID = 26;
    
    public NPC_SHorse(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NID;
    }


}
