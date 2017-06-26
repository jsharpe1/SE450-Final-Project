package view;

import view.CmdUiModule.Cmd;
import view.GuiUiModule.Gui;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;

public class UIFactory {
    public static UIModule createUI(UIType uiType) throws InvalidUIException {
        UIModule ui;

        switch(uiType){
            case CMD:
                ui = new Cmd();
                break;
            case GUI:
                ui = new Gui();
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
