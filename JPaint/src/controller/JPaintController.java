package controller;

import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private UIModule _uiModule;

    public JPaintController(UIModule uiModule){
        _uiModule = uiModule;
    }

    @Override
    public void initialize() {
        // create canvas, menu, buttons, listeners, etc.
        _uiModule.initialize();
    }

    @Override
    public void display() {
        // main running method.
    }

    @Override
    public void destroy() {
        // destroy objects as you can.
    }
}
