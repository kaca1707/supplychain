package upm.softwaredesign.finalproject.blockchain;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * TODO when to add blocks data? constructor?
 */
public class BlockChain implements java.io.Serializable {

	private ArrayList<Block> blocks;

	/**
	 * This method adds a new block to the blockchain
	 * and assigns a blockId after it's saved
	 * @param block
	 */
	public Block addBlock(Block block){
		return null;
	}

	/**
	 * TODO: not sure about it's function
	 * @param id
	 */
	public void orderInfo(String id){

	}

	/**
	 * Retrive all the existing blocks in the blockchain
	 */
	public ArrayList<Block> getBlocks(){
		return blocks;
	}

	/**
	 * Saves the current instance of the blockchain
	 */
	public void saveChain(){
		// TODO save this instance in the persistence layer
		
	}

}
