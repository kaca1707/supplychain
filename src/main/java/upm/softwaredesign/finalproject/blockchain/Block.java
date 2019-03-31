package upm.softwaredesign.finalproject.blockchain;

import java.util.UUID;

import upm.softwaredesign.finalproject.order.Order;

public class Block {

	private UUID blockId;
	private UUID transactionGroupId;
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

	public void setTransactionGroupId(UUID transactionGroupId) {
		this.transactionGroupId = transactionGroupId;
	}

	public void getTransactionGroupId() {
		return this.transactionGroupId;
	}

}
