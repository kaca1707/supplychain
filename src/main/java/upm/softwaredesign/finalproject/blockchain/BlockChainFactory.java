package upm.softwaredesign.finalproject.blockchain;

import upm.softwaredesign.finalproject.service.BlockchainService;

public class BlockChainFactory {

	private static BlockChain chain;

	/**
	 * @return returns a singleton instance of the blockchain
	 */
	public static BlockChain build(){
		if (this.chain == null) {
			this.chain = retrieveChain();
		}
		return this.chain;
	}

	/**
	 * @return retrives the blockchain from persistence layer
	 */
	private static BlockChain retrieveChain(){
		// TODO double check instanciation
		BlockchainService service = new BlockchainService();
		// store instance
		this.chain = service.retrieveBlockchain();
		return this.chain;
	}
}
