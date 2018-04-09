package com.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entity.Block;

/**
 * 根据上一个块的信息和 新块需要存储的信息  产生新的块
 * @author Administrator
 *
 */
public class BlockNew {
	public static Block gotNew(Block old,int vac){
		Block newBlock=new Block();
		//新块的序列号为上一个块+1
		newBlock.setIndex(old.getIndex()+1);
		//新块时间戳为当前时间
		newBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		//上一个块的hash值
		newBlock.setPrevHash(old.getHash());
		//自身需要存储的信息
		newBlock.setVac(vac);
		//该块的hash值
		newBlock.setHash(BlockUtil.blockHash(newBlock));
		
		return newBlock;
	}
}
