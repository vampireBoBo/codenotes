package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.entity.Block;

/**
 * 根据块得到当前块的散列值
 * @author Administrator
 *
 */
public class BlockUtil {
	/**
	 * 根据块信息得到该块的唯一标识hash值
	 * @param block
	 * @return
	 */
	public static String blockHash(Block block){
		BlockUtil bu=new BlockUtil();
		String hashCode=block.getIndex()+block.getTimestamp()+block.getVac()+block.getPrevHash();
		try {
			//MessageDigest 为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
			//MD2 MD5 SHA-1 SHA-256 SHA-384 SHA-512等算法  该类是一个抽象类 需要使用getInstance获取指定算法的抽象类 
			MessageDigest  digest=MessageDigest.getInstance("SHA-256");
			//通过update方法处理指定数据
			digest.update(hashCode.getBytes());
			//对于给定数量的更新数据，digest 方法只能被调用一次。在调用 digest 之后，MessageDigest 对象被重新设置成其初始状态。 
			byte[] hashCodes=digest.digest();
			//将加密处理后的字节转换成字符串
			hashCode=bu.byte2hex(hashCodes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashCode;
	}
	/**
	 * 将字节数组转换成字符串
	 */
	public String byte2hex(byte[] b){
	     String hs="";
	     String stmp="";
	     for (int n=0;n<b.length;n++){
		       stmp=(java.lang.Integer.toHexString(b[n] & 0XFF));
		       if (stmp.length()==1) hs=hs+"0"+stmp;
		       else hs=hs+stmp;
		       if (n<b.length-1)  hs=hs+":";
	      }
	     return hs.toUpperCase();
    }
	/**
	 * 判断某一个块是否被篡改
	 * true:未被篡改
	 * false:被篡改
	 */
	public static boolean isChangeBlock(Block newBlock,Block oldBlock){
		//判断该块为递增关系
		if(oldBlock.getIndex()+1!=newBlock.getIndex()){
			return false;
		}
		//新块中的旧块的hash值与旧块本身不一致
		if(oldBlock.getHash()!=newBlock.getPrevHash()){
			return false;
		}
		//新块中hash值与重新计算的不一致
		if(newBlock.getHash()!=blockHash(newBlock)){
			return false;
		}
		//默认未被篡改
		return true;
	}
}
