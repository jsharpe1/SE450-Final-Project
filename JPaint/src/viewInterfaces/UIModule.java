package viewInterfaces;

import ControllerInterfaces.ICommand;

public interface UIModule {
    void initialize();
    void addEvent(EventName eventName, ICommand command);
    <T> T getDialogResponse(IDialogChoice dialogSettings);
}
