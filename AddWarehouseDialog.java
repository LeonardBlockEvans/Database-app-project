package project4329;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWarehouseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField warehouseID;
	private JTextField stateID;
	private JTextField city;
	private JTextField streetAddress;
	private JTextField zip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddWarehouseDialog dialog = new AddWarehouseDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Connection conn = null;
	/**
	 * Create the dialog.
	 */
	public AddWarehouseDialog() {
		setTitle("Add Warehouse");
		try {
			conn = DriverManager.getConnection("Client", "USER",
					"PASS");
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Warehouse ID");
			contentPanel.add(lblNewLabel, "2, 2");
		}
		{
			warehouseID = new JTextField();
			contentPanel.add(warehouseID, "4, 2, fill, default");
			warehouseID.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("State ID");
			contentPanel.add(lblNewLabel_1, "2, 4");
		}
		{
			stateID = new JTextField();
			contentPanel.add(stateID, "4, 4, fill, default");
			stateID.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("City");
			contentPanel.add(lblNewLabel_2, "2, 6");
		}
		{
			city = new JTextField();
			contentPanel.add(city, "4, 6, fill, default");
			city.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Address");
			contentPanel.add(lblNewLabel_3, "2, 8");
		}
		{
			streetAddress = new JTextField();
			contentPanel.add(streetAddress, "4, 8, fill, default");
			streetAddress.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Zip");
			contentPanel.add(lblNewLabel_4, "2, 10");
		}
		{
			zip = new JTextField();
			contentPanel.add(zip, "4, 10, fill, default");
			zip.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Submit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String warehouseIDS = warehouseID.getText();
						int warehouseID = Integer.parseInt(warehouseIDS);		
						String stateIDS = stateID.getText();
						int stateID = Integer.parseInt(stateIDS);		
						String zipS = zip.getText();
						int zip = Integer.parseInt(zipS);		
						try {
						PreparedStatement stmt = conn.prepareStatement("INSERT INTO Warehouse values(?, ?, ?, ?, ?)");
						stmt.setInt(1, warehouseID);
						stmt.setInt(2, stateID);
						stmt.setString(3, city.getText());
						stmt.setString(4, streetAddress.getText());
						stmt.setInt(5, zip);
						stmt.execute();
						setVisible(false);
						dispose();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
