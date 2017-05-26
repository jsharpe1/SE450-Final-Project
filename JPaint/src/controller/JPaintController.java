package controller;

import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private UIModule _uiModule;

    public JPaintController(UIModule uiModule){
        _uiModule = uiModule;
    }
}
