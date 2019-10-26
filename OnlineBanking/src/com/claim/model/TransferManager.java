package com.claim.model;

public class TransferManager
{
	  public ITransferSource Source; 
	  
	    public ITransferDestination Destination; 
	 
	    public long Value;
	 
	    public void Transfer()
	    {
	        Source.RemoveFunds(Value);
	        Destination.AddFunds(Value);
	    }
}
