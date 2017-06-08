package viewInterfaces;

public interface UIModule {
    void initialize();
    void addEvent(EventName eventName, ICommand command);
}
