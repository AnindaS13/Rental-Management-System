package Gui;

//This interface is implemented by the other views
//The views all use this frame to add to the GUI
import javax.swing.*;

interface Component {
    public JFrame frame = new JFrame();

    public void draw();  //This method is for the views to implement adding the gui elements to the frame
}
