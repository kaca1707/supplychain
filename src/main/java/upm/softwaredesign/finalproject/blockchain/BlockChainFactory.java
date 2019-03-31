package upm.softwaredesign.finalproject.blockchain;

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
		// TODO get chain from persistence layer
		// this.chain = ...
		return this.chain;
	}
}
