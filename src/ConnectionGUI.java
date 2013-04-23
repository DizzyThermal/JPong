import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class ConnectionGUI extends JFrame implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	
	JPanel mainPanel = new JPanel();
	JLabel titleLabel = new JLabel("Connection Information");
	JLabel addressLabel = new JLabel("Registrar IP: ");
	JLabel portLabel = new JLabel("Registrar Port: ");
	JLabel nameLabel = new JLabel("Username: ");
	
	JButton okButton = new JButton("OK");

	JTextField name = new JTextField();
	JTextField address = new JTextField();
	JSpinner port = new JSpinner(new SpinnerNumberModel(8010, 0, 65535, 1));
	JTextField download = new JTextField();
	
	ConnectionGUI()
	{
		super("JPong Connection Panel");
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		setLayout(fl);
		
		createPanel();
		add(mainPanel);
	}
	
	public void createPanel()
	{
		mainPanel.setPreferredSize(new Dimension(300, 350));
		titleLabel.setPreferredSize(new Dimension(300, 20));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		mainPanel.add(titleLabel);
		
		addressLabel.setPreferredSize(new Dimension(250, 20));
		mainPanel.add(addressLabel);
		address.setPreferredSize(new Dimension(250, 20));
		address.setText(Resource.IP);
		address.addKeyListener(this);
		mainPanel.add(address);
		
		portLabel.setPreferredSize(new Dimension(250, 20));
		mainPanel.add(portLabel);
		port.setPreferredSize(new Dimension(250, 20));
		port.addKeyListener(this);
		mainPanel.add(port);
		
		nameLabel.setPreferredSize(new Dimension(250, 20));
		mainPanel.add(nameLabel);
		name.setPreferredSize(new Dimension(250, 20));
		name.setText(Resource.USERNAME);
		name.addKeyListener(this);
		mainPanel.add(name);
		
		mainPanel.add(okButton);
		mainPanel.addKeyListener(this);
		okButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == okButton)
		{
			Resource.USERNAME = name.getText().replace("/", "");
			Resource.IP = address.getText();
			Resource.PORT = String.valueOf(port.getValue());
			Resource.FILE_SAVE_DIR = download.getText();
			this.setVisible(false);
			GUI.connectionGUIStatus = true;
		}
	}


	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			Resource.USERNAME = name.getText().replace("/", "");
			Resource.IP = address.getText();
			Resource.PORT = String.valueOf(port.getValue());
			Resource.FILE_SAVE_DIR = download.getText();
			this.setVisible(false);
			GUI.connectionGUIStatus = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}