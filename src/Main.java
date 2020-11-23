import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setSize(500,550);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(500,650);
        window.add(mainPanel);

        MarchingSquares marchingSquares = new MarchingSquares(500,500);

        mainPanel.add(marchingSquares, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setSize(500,50);

        controlPanel.setLayout(new FlowLayout());
        JLabel labelSlider = new JLabel("Selection le degree d'activation : ");

        JSlider degreeSlider = new JSlider();
        degreeSlider.setMaximum(100);
        degreeSlider.setMinimum(0);

        degreeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float degree = (float) degreeSlider.getValue() /100;
                marchingSquares.setDegree(degree);

                mainPanel.revalidate();
                marchingSquares.repaint();
            }
        });

        controlPanel.add(labelSlider);
        controlPanel.add(degreeSlider);

        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        window.setVisible(true);

    }
}
