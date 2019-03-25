package upm.softwaredesign.finalproject.blockchain;

public class ProductionChain {

	private BlockChain chain;

	/**
	 * @return returns a singleton instance of the blockchain
	 */
	public BlockChain getInstance(){
		if (this.chain == null) {
			this.chain = retrieveChain();
		}
		return this.chain;
	}

	/**
	 * @return retrives the blockchain from persistence layer
	 */
	private BlockChain retrieveChain(){
		//TODO: get chain from persistence layer
		// BlockChain chain = ...
		return chain;
	}
}
