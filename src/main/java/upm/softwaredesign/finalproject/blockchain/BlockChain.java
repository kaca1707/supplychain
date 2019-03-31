package upm.softwaredesign.finalproject.blockchain;

import java.util.ArrayList;
import java.util.UUID;

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
	 * @param UUID		id
	 * @return Order | null
	 */
	public Order orderInfo(UUID id){
		// filter blocks by order id
		for (Block block : this.blocks) {
      if (block.getOrder().getId() === id) {
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
		for (Block block : this.blocks) {
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
	 * NOTE https://www.baeldung.com/jackson-object-mapper-tutorial
	 *
	 * @return String
	 */
  public String toJson(){
		ObjectMapper objectMapper = new ObjectMapper();
		// TODO test ...
		String jsonString = objectMapper.writeValueAsString(this.blocks);
		return jsonString;
	}

  /**
   * Populate class with data from Json format string
	 * NOTE https://www.baeldung.com/jackson-object-mapper-tutorial
	 *
   * @param String in json format
   */
  public void fromJson(String jsonData){
		ObjectMapper objectMapper = new ObjectMapper();
		// TODO test ...
		this.blocks = objectMapper.readValue(
			jsonData,
			new TypeReference<ArrayList<Order>>(){}
		);
	}

}
