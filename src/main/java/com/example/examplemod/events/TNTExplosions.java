package com.example.examplemod.events;

import com.example.examplemod.ExampleMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.event.world.BlockEvent.BreakEvent; 
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;

// import net.minecraft.block.BlockOre; // minecraft 1.8

import net.minecraft.block.OreBlock; // mincraft 1.15.2

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
//import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.Entity;


@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TNTExplosions{

    // 威力使用10格
    private static float power = 10;
    
    //comments out for not explode everything
    //@SubscribeEvent
    public static void explodeHead(EntityJoinWorldEvent event) {
        // 只處理加入到世界的實體是TNT : 這裡即是指TNT方塊被啟動後閃爍的TNT"實體"
        if (event.getEntity() instanceof TNTEntity) {
             Entity entity = event.getEntity();
             BlockPos pos = event.getEntity().getPosition();
             // 建立我們想要的爆炸威力
             event.getEntity().getEntityWorld().createExplosion(
                     entity,
                     pos.getX(), 
                     pos.getY(),
                     pos.getZ(),
                     power,
                     Explosion.Mode.BREAK);
        };
     };
}



/* 

        //ExampleMod.LOGGER.info("Block Break");

            // 透過事件取得被破壞的方塊，若方塊不為礦石方塊(BlockOre)，則不做任何事情(return)
    // 這裡需要import net.minecraft.block.BlockOre
    //if (!(event.getState().getBlock() instanceof OreBlock)) return;

        PlayerEntity player = event.getPlayer(); //玩家. 舊版EntityPlayer, 新版要用PlayerEntity, ......
        float power = 100;  //爆破的威力 (5代表五個方塊長的爆炸範圍)
        //boolean destroyBlocks = true;  //爆炸是否要損毀方塊, 新API 使用 Explosion.Mode.BREAK
        World world = player.getEntityWorld();
        BlockPos pos = event.getPos(); //方塊打破的位置
        // 建立爆破
        world.createExplosion(
             // 爆炸來源為玩家
             player,
             // 藉由打破方塊事件的位置來建立爆破
             pos.getX(), 
             pos.getY(),
             pos.getZ(),
             power,
             Explosion.Mode.BREAK
        );

    }
*/