import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	private HandsOn8 myAgent;

	private JTextField xValueInput;

	public GUI(HandsOn8 a) {
            super(a.getLocalName());

            myAgent = a;

            JPanel p = new JPanel();
            p.setLayout(new GridLayout(2, 2));
            getContentPane().add(p, BorderLayout.CENTER);

            JButton addButton = new JButton("Predecir");
            addButton.addActionListener(new ActionListener() {
                    @Override
					public void actionPerformed(ActionEvent ev) {
                            try {
                                    myAgent.predict();
                            }
                            catch (Exception e) {
                                    JOptionPane.showMessageDialog(GUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }
            } );
            p = new JPanel();
            p.add(addButton);
            getContentPane().add(p, BorderLayout.SOUTH);

            // Make the agent terminate when the user closes
            // the GUI using the button on the upper right corner
            addWindowListener(new	WindowAdapter() {
                    @Override
					public void windowClosing(WindowEvent e) {
                            myAgent.doDelete();
                    }
            } );

            setResizable(true);
	}

	public void showGui() {
            pack();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX = (int)screenSize.getWidth() / 2;
            int centerY = (int)screenSize.getHeight() / 2;
            setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
            super.setVisible(true);
	}
}