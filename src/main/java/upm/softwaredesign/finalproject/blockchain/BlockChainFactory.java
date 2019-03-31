package upm.softwaredesign.finalproject.blockchain;

import upm.softwaredesign.finalproject.service.BlockchainService;

public class BlockChainFactory {

	private static BlockChain chain;
	private static BlockchainService blockchainService;

	@Autowired
	public BlockChainFactory(BlockchainService blockchainService) {
			this.blockchainService = blockchainService;
	}

	/**
	 * Singleton instance of the blockchain
	 *
	 * @return BlockChain
	 */
	public static BlockChain build(){
		if (this.chain == null) {
			this.chain = this.retrieveChain();
		}
		return this.chain;
	}

	/**
	 * Retrives the blockchain from persistence layer
	 *
	 * @return BlockChain
	 */
	private static BlockChain retrieveChain(){
		// store instance
		this.chain = this.blockchainService.retrieveBlockchain();
		return this.chain;
	}
}
