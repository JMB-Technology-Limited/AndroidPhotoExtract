package uk.co.jmbtechnology.androidphotoextract;

public class PhotoExtractError extends Exception {

	Throwable originalThrowable;

	String rawDebugInformation;

	public PhotoExtractError(Throwable throwable, String rawDebugInformation) {
		super(throwable);
		this.originalThrowable = throwable;
		this.rawDebugInformation = rawDebugInformation;
	}

	public Throwable getOriginalThrowable() {
		return originalThrowable;
	}

	public String getRawDebugInformation() {
		return rawDebugInformation;
	}

}
