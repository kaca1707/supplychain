package upm.softwaredesign.finalproject.enums;

public enum TransactionStatus {
    RETAILER_REQUEST(1),
    FACTORY_REQUEST(2),
    PRODUCER_DELIVERY(3),
    FACTORY_DELIVERY(4);
    
	// Sequence Index is required to compare TransactionStatus with each other
	// To get the latest order which is the highest sequenceIndex
	private int sequenceIndex;
	
    TransactionStatus(int order){
    	this.sequenceIndex = order;
    }

	public int getSequenceIndex() {
		return sequenceIndex;
	}
    
}
