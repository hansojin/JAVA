package ystd;

class UnsupportedFuctionException extends RuntimeException {
	private final int ERR_CODE;
	UnsupportedFuctionException(String msg, int errCode) { 
		super(msg);
		ERR_CODE = errCode;
	}
	UnsupportedFuctionException(String msg) { 
		this(msg, 100); 
	}
	public int getErrCode() {
		return ERR_CODE; 
	}
	public String getMessage() { 
		return super.getMessage();
	}
}
class Exercise8_9 {
	public static void main(String[] args) throws Exception
	{
		throw new UnsupportedFuctionException("Unsupported funtion.",100);
	}
}
