package Start;

import Presentation.*;

public class Start {

	public static void main(String[] args) {
		MainView v = new MainView();
		v.setVisible(true);
		Controller c = new Controller(v);
	}
}
