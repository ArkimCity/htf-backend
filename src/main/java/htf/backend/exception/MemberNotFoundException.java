package htf.backend.exception;

public class MemberNotFoundException extends MemberException {

	public MemberNotFoundException() {}
	public MemberNotFoundException(String message) {
		super(message);
	}
}
