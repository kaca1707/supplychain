package upm.softwaredesign.finalproject.blockchain;

import java.util.ArrayList;

import upm.softwaredesign.finalproject.order.Order;
import upm.softwaredesign.finalproject.interfaces.Jsonable;
import upm.softwaredesign.finalproject.service.BlockchainService;

public class BlockChain implements Jsonable {

	private ArrayList<Block> blocks;
	private BlockchainService blockchainService;

	@Autowired
	public BlockChain(BlockchainService blockchainService) {
			this.blockchainService = blockchainService;
	}

	/**
	 * This method adds a new block to the blockchain
	 * by wrapping an order. Return value used to track
	 * successful addition of the order
	 *
	 * @param Order			order
	 * @return Boolean
	 */
	public Boolean addOrder(Order order){
		// wrap order in a Block
		Block block = new Block();
		block.setOrder(order);
		// append block to the chain of blocks
		this.appendBlock(block);
		// store blockchains changes
		this.saveChain();
		// TODO implement real Boolean response once
		// 			it will implmented in saveChain too.
		return true;
	}

	/**
	 * Retrieve an order from the blockchain,
	 * given its id
	 *
	 * @param String		id
	 * @return Order
	 */
	public Order orderInfo(String id){
		// filter blockchain by order id
		// TODO ...
		return order;
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
		for (String Block : block) {
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
		this.blockchainService.saveBlockchain(this);
		// TODO return value not implemented by BlockchainService
		return true;
	}

	/**
	 * Append new block to the chain
	 *
	 * @param Block			block
	 */
	private void appendBlock(Block block){
		this.blocks.add(block)
	}

	/**
   * Covert the blocks into a Json format string
   */
  public String toJson(){
		// TODO ...
		// return
	}

  /**
   * Populate class with data from Json format string
   * @param String in json format
   */
  public void fromJson(String jsonData){
		// TODO ...
	}

}
