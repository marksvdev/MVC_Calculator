import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class CalcController {

	private CalcModel model;
	private CalcView view;

	public CalcController(CalcModel model, CalcView view) {
		this.model = model;
		this.view = view;

		view.addOperationListener(new OperationListener());
		view.addClearListener(new ClearListener());
	}

	/*
	 * Button Listener Implementation
	 */

	class OperationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String btnText = "";
			String userInput = "";
			String userInput2 = "";

			if (e.getSource() instanceof JButton)
				btnText = ((JButton) e.getSource()).getText();

			try {
				userInput = view.getUserInput();
				userInput2 = view.getUserInput2();

				switch (btnText) {
				case "Add":
					model.add(Float.parseFloat(userInput),
							Float.parseFloat(userInput2));
					break;
				case "Subtract":
					model.subtract(Float.parseFloat(userInput),
							Float.parseFloat(userInput2));
					break;
				case "Multiply":
					model.multiply(Float.parseFloat(userInput),
							Float.parseFloat(userInput2));
					break;
				case "Divide":
					model.divide(Float.parseFloat(userInput),
							Float.parseFloat(userInput2));
					break;
				default:
					break;
				}

				view.setTotal(String.valueOf(model.getValue()));
			} catch (NumberFormatException ex) {
				view.showError("Bad inputs: '" + userInput + " " + userInput2
						+ "'");
			}
		}
	}

	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.reset();
		}

	}

}
