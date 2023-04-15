package com.carpeadventum.bedrockshards.block;

import com.carpeadventum.bedrockshards.Init;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {

    private static final float hardness = 50.0f;
    private static final float resistance = 2000.0f;

    public static void registerBlocks() {
        final Block PURE_OBSIDIAN = new Block(FabricBlockSettings.copy(net.minecraft.block.Blocks.BLACK_STAINED_GLASS).allowsSpawning((state, world, pos, type) -> false).strength(hardness, resistance).nonOpaque().blockVision((state, reader, pos)-> false).requiresTool());
        registerBlock("pure_obsidian", PURE_OBSIDIAN);

        final Block PURE_BEDROCK = new Block(FabricBlockSettings.copy(net.minecraft.block.Blocks.OBSIDIAN).strength(hardness*2, resistance).allowsSpawning((state, world, pos, type) -> false).requiresTool());
        registerBlock("pure_bedrock", PURE_BEDROCK);
    }

    private static void registerBlock(String Id, Block block) {
        Identifier identifier = new Identifier(Init.MOD_ID, Id.toLowerCase());
        Registry.register(Registry.BLOCK, identifier, block);
        Registry.register(Registry.ITEM, identifier, new BlockItem(block, new FabricItemSettings().group(Init.OID)));
    }
}