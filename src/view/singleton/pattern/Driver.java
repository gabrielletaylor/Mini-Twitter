package view.singleton.pattern;

public class Driver {

	// main method
	// follows Singleton design pattern
	// opens Admin Control Panel
	public static void main(String[] args) {
		AdminControlPanel.getInstance().displayPanel();
	}

}
