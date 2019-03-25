package upm.softwaredesign.finalproject.blockchain;

import java.util.ArrayList;
import java.util.UUID;

import upm.softwaredesign.finalproject.enums.TransactionStatus;

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

	/**
	 * Returns the status of the collection group of orders
	 * For eg. If order is waiting for delivery from production house
	 *         after factory requested it in the chain of events then it would be FACTORY_REQUEST
	 */
	public TransactionStatus getTransactionGroupStatus(UUID transactionGroupId){
		
		return null;
	}
}
