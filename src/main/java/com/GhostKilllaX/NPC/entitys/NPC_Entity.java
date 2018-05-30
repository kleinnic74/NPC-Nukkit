
package com.GhostKilllaX.NPC.entitys;

import cn.nukkit.entity.Entity;
import cn.nukkit.Player;
import cn.nukkit.entity.data.FloatEntityData;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.AddEntityPacket;
import java.util.HashMap;
import java.util.Map;



public abstract class NPC_Entity extends Entity{
    
    Map<Integer, Float> map = new HashMap<>();
    
    public final void mapp(){
        map.put(10, (float)0.4); map.put(11, (float)1.0); map.put(12, (float)0.6); map.put(13, (float)0.8);
        map.put(14, (float)0.4); map.put(15, (float)1.4); map.put(16, (float)0.8); map.put(17, (float)0.6);
        map.put(18, (float)0.4); map.put(19, (float)0.4); map.put(20, (float)2.4); map.put(21, (float)1.2);
        map.put(22, (float)0.4); map.put(23, (float)1.2); map.put(24, (float)0.9); map.put(25, (float)1.2);
        map.put(26, (float)1.2); map.put(27, (float)1.2);
        map.put(32, (float)1.4); map.put(33, (float)1.2); map.put(34, (float)1.4); map.put(35, (float)0.5);
        map.put(36, (float)1.4); map.put(37, (float)1.0); map.put(38, (float)2.4); map.put(39, (float)0.4);
        map.put(40, (float)0.2); map.put(41, (float)4.5); map.put(42, (float)1.0); map.put(43, (float)1.4);
        map.put(44, (float)1.4); map.put(45, (float)1.6); map.put(46, (float)1.4); map.put(47, (float)1.4);
        map.put(48, (float)2.1); map.put(65, (float)1.0); map.put(66, (float)0.5); map.put(84, (float)0.7);
        map.put(90, (float)0.6); map.put(104,(float)1.6); map.put(57, (float)1.6); map.put(105,(float)0.4);
    }
    
    
    public NPC_Entity(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.mapp();
        this.setDataProperty(new FloatEntityData(Entity.DATA_BOUNDING_BOX_HEIGHT, map.getOrDefault(this.getNetworkId(), (float) 1)), true);
        this.setDataProperty(new FloatEntityData(DATA_SCALE, this.namedTag.getFloat("scale")));
      
    }
    
    @Override
    public void spawnTo(Player player){
    AddEntityPacket pk = new AddEntityPacket();
    pk.entityRuntimeId = this.getId();
    pk.entityUniqueId = this.getId();
    pk.type = this.getNetworkId();
    pk.x = (float) this.x;
    pk.y = (float) this.y;
    pk.z = (float) this.z;
    pk.speedX = pk.speedY = pk.speedZ = 0;
    pk.yaw = (float) this.yaw;
    pk.pitch = (float) this.pitch;
    pk.metadata = this.dataProperties; 
    player.dataPacket(pk);
    super.spawnTo(player);
}

        

}
	