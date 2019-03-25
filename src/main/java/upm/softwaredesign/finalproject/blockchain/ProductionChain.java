package upm.softwaredesign.finalproject.blockchain;

public class ProductionChain {

	private static BlockChain chain;

	/**
	 * @return returns a singleton instance of the blockchain
	 */
	public static BlockChain getInstance(){
		if (chain == null) {
			chain = retrieveChain();
		}
		return chain;
	}

	/**
	 * @return retrives the blockchain from persistence layer
	 */
	private static BlockChain retrieveChain(){
		//TODO: get chain from persistence layer
		// BlockChain chain = ...
		return chain;
	}
}
