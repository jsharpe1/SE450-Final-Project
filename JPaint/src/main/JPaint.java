package main;

import controller.IPaintController;

public class JPaint {
    private IPaintController _controller;

    public JPaint(IPaintController controller) {
        _controller = controller;
    }

    public void run() {
        _controller.initialize();
        _controller.display();
        _controller.destroy();
    }
}
