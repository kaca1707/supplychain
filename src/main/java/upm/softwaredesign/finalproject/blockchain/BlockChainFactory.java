package upm.softwaredesign.finalproject.blockchain;

import org.springframework.beans.factory.annotation.Autowired;

import upm.softwaredesign.finalproject.service.BlockchainService;

public class BlockChainFactory {

	private static BlockChain chain;
	private static BlockchainService blockchainService;

	@Autowired
	public BlockChainFactory(BlockchainService bService) {
			blockchainService = bService;
	}

	/**
	 * Singleton instance of the blockchain
	 *
	 * @return BlockChain
	 */
	public static BlockChain build(){
		if (chain == null) {
			chain = retrieveChain();
		}
		return chain;
	}

	/**
	 * Retrives the blockchain from persistence layer
	 *
	 * @return BlockChain
	 */
	private static BlockChain retrieveChain(){
		// store instance
		chain = blockchainService.retrieveBlockchain();
		return chain;
	}
}
