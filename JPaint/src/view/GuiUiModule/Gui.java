package view.GuiUiModule;

import javax.swing.*;

import viewInterfaces.EventName;
import ControllerInterfaces.ICommand;
import viewInterfaces.IDialogChoice;
import viewInterfaces.UIModule;

public class Gui implements UIModule {

    private final GuiWindow gui = new GuiWindow();

    @Override
    public void initialize() {
        gui.setVisible(true);
    }
    
	@Override
	public void addEvent(EventName eventName, ICommand command) {
		JButton button = gui.getButton(eventName);
		button.addActionListener((ActionEvent) -> command.run());
	}

    @Override
    public <T> T getDialogResponse(IDialogChoice dialogSettings) {
        Object selectedValue = JOptionPane.showInputDialog(null,
                dialogSettings.getDialogText(), dialogSettings.getDialogTitle(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                dialogSettings.getDialogOptions(),
                dialogSettings.getDefaultChoice());
        return (T)selectedValue;
    }
}
