package upm.softwaredesign.finalproject.blockchain;

import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;

import upm.softwaredesign.finalproject.enums.TransactionStatus;
import upm.softwaredesign.finalproject.order.Order;

public class BlockChain implements Serializable {

	private ArrayList<Block> blocks;

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
		// TODO ...
		// append block to the chain of blocks
		Boolean appended = appendBlock(block);
		// store blockchains changes
		// TODO ...
		return false;
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
		// TODO ...
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
		// send the current instance 'this' to the persistence layer
		// TODO ...
		return false;
	}

	/**
	 * Append new block to the chain
	 *
	 * @param Block			block
	 * @return Boolean
	 */
	private Boolean appendBlock(Block block){
		// append block to the chain
		// TODO ...
		return false;
	}

}
