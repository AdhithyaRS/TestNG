package customException;

public class InvalidValueException extends Exception {
	private static final long serialVersionUID = 1L;
	private int errCode;

//    public InvalidValueException() {
//        super("Invalid value encountered.");
//    }

    public InvalidValueException(int errCode, String message) {
        super(message);
        this.errCode = errCode;
    }

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
    
}
