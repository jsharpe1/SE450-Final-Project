package view.GuiUiModule;

import javax.swing.JButton;

import viewInterfaces.EventName;
import viewInterfaces.ICommand;
import viewInterfaces.UIModule;

public class Gui implements UIModule {
    GuiWindow gui = new GuiWindow();

    @Override
    public void initialize() {
        gui.setVisible(true);
    }
    
	@Override
	public void addEvent(EventName eventName, ICommand command) {
		JButton button = gui.getButton(eventName);
		button.addActionListener((ActionEvent) -> command.run());
	}
}
