package basic220531;

public interface WashInter {

	public void startButton();

	public void stopButton();

	public void pauseButton();

	public void changeButton(int spd);

	//
	default void dry() {}
	
}
