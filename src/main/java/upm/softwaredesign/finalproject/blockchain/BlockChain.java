package upm.softwaredesign.finalproject.blockchain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import upm.softwaredesign.finalproject.order.Order;
import upm.softwaredesign.finalproject.service.BlockchainService;

public class BlockChain implements Jsonable {

	private static BlockChain chain;
	public ArrayList<Block> blocks;
	private BlockchainService blockchainService;

	@Autowired
	public BlockChain(BlockchainService blockchainService) {
			this.blockchainService = blockchainService;
			if (chain == null) {
				chain = retrieveChain();
			}
	}

//	/**
//	 * Singleton instance of the blockchain
//	 *
//	 * @return BlockChain
//	 */
//	public BlockChain build(){
//		if (chain == null) {
//			chain = retrieveChain();
//		}
//		return chain;
//	}
//
	/**
	 * Retrives the blockchain from persistence layer
	 *
	 * @return BlockChain
	 */
	private BlockChain retrieveChain(){
		// store instance
		return this.blockchainService.retrieveBlockchain();
	}

	/**
	 * This method adds a new block to the blockchain
	 * by wrapping an order. Return value used to track
	 * successful addition of the order
	 *
	 * @param order
	 * @return Boolean
	 */
	public Boolean addOrder(Order order){
		// wrap order in a Block
		Block block = new Block();
		block.setOrder(order);
		// append block to the chain of blocks
		this.appendBlock(block);
		// store blockchains changes
		return this.saveChain();
	}

	/**
	 * Retrieve an order from the blockchain,
	 * given its id
	 *
	 * @param id
	 * @return Order | null
	 */
	public Order orderInfo(UUID id){
		// filter blocks by order id
		for (Block block : this.chain.blocks) {
		  if (block.getOrder().getId() == id) {
			return block.getOrder();
		  }
		}
		return null;
	}

	/**
	 * Retrive all the existing orders in the blockchain
	 *
	 * @return ArrayList<Order>
	 */
	public ArrayList<Order> listOrders(){
		// make an ArrayList of Orders
		ArrayList<Order> orders = new ArrayList<Order>();
		// fill the list with orders extracted from blocks
		for (Block block : this.chain.blocks) {
	      orders.add(block.getOrder());
	    }
		return orders;
	}

	/**
	 * Saves the current instance of the blockchain
	 * in the persistence layer. Returning true once
	 * has been successfully stored
	 *
	 * @return Boolean
	 */
	private Boolean saveChain(){
		try {
			this.blockchainService.saveBlockchain(this);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO return value not implemented by BlockchainService
		return false;
	}

	/**
	 * Append new block to the chain
	 *
	 * @param block
	 */
	private void appendBlock(Block block){
		this.chain.blocks.add(block);
	}

	/**
   * Covert the blocks into a Json format string
	 * NOTE https://www.baeldung.com/jackson-object-mapper-tutorial
	 *
	 * @return String
	 */
  public String toJSON(){
		ObjectMapper objectMapper = new ObjectMapper();
		// TODO test ...
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(this.blocks);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}

  /**
   * Populate class with data from Json format string
	 * NOTE https://www.baeldung.com/jackson-object-mapper-tutorial
	 *
   * @param jsonData in json format
   */
  public void fromJSON(String jsonData){
		ObjectMapper objectMapper = new ObjectMapper();
		// TODO test ...
		try {
			this.blocks = objectMapper.readValue(
				jsonData,
				new TypeReference<ArrayList<Order>>(){}
			);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
