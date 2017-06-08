package view.GuiUiModule;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.swing.*;
import javax.swing.border.*;

import view.IGuiWindow;
import viewInterfaces.EventName;

import java.awt.*;

public class GuiWindow extends JFrame implements IGuiWindow {
    private final int defaultWidth = 1200;
    private final int defaultHeight = 800;
    private final String defaultTitle = "JPaint";
    private final Insets defaultButtonDimensions 
    	= new Insets(5, 15, 5, 15);
    private final Map<EventName, JButton> eventButtons = new HashMap<>();

    public GuiWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(defaultTitle);
        setSize(defaultWidth, defaultHeight);
        JPanel window = createWindow();

        window.add(new PaintCanvas(), BorderLayout.CENTER);
		validate();
    }

	public JButton getButton(EventName eventName) {
		if(!eventButtons.containsKey(eventName))
			throw new NoSuchElementException("No button exists for action " + eventName.toString());
		
		return eventButtons.get(eventName);
	}

	private JPanel createWindow() {
		JPanel contentPane = createBackgroundPanel();
        JPanel buttonPanel = createMenu();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        return contentPane;
	}

    private JPanel createMenu() {
        JPanel buttonPanel = createButtonPanel();

        addButtonToPanel(EventName.POINT, buttonPanel);
        addButtonToPanel(EventName.LINE, buttonPanel);
        addButtonToPanel(EventName.ELIPSE, buttonPanel);
        addButtonToPanel(EventName.RECTANGLE, buttonPanel);
        addButtonToPanel(EventName.TRIANGLE, buttonPanel);
        addButtonToPanel(EventName.FILL_COLOR, buttonPanel);
        addButtonToPanel(EventName.CHOOSE_PRIMARY_COLOR, buttonPanel);
        addButtonToPanel(EventName.CHOOSE_SECONDARY_COLOR, buttonPanel);
        addButtonToPanel(EventName.MOVE, buttonPanel);
        addButtonToPanel(EventName.DELETE, buttonPanel);
        
        return buttonPanel;
    }

	private void addButtonToPanel(EventName eventName, JPanel panel) {
		JButton newButton = createButton(eventName);
        eventButtons.put(eventName, newButton);
        panel.add(newButton);
	}

	private JButton createButton(EventName eventName) {
		JButton newButton = new JButton(eventName.toString());
		newButton.setForeground(Color.BLACK);
		newButton.setBackground(Color.WHITE);
        newButton.setBorder(createButtonBorder());
		return newButton;
	}

	private Border createButtonBorder() {
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(defaultButtonDimensions);
    	return new CompoundBorder(line, margin);
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.setBackground(Color.lightGray);
		return panel;
	}

    private JPanel createBackgroundPanel() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        return contentPane;
    }
}