package upm.softwaredesign.finalproject.blockchain;

import java.util.UUID;
import java.io.Serializable;

import upm.softwaredesign.finalproject.order.Order;

/**
 * TODO make this class serializable (note the properities)
 * 			e.g. fina a way to wrap Order since is not serializable
 * TODO evaluate hash, and block ID. When to initialize them?
 *			How to use them?
 */
public class Block implements java.io.Serializable {

	private UUID blockId;
	private Order order;

	public UUID getBlockId() {
		return blockId;
	}

	public void setBlockId(UUID blockId) {
		this.blockId = blockId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
