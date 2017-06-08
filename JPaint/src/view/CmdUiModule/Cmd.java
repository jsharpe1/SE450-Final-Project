package view.CmdUiModule;

import viewInterfaces.EventName;
import viewInterfaces.ICommand;
import viewInterfaces.UIModule;

public class Cmd implements UIModule {
    @Override
    public void initialize() {
        // do nothing.
    }

	@Override
	public void addEvent(EventName eventName, ICommand command) {
		// throw new Exception("Not Implemented");
	}
}
