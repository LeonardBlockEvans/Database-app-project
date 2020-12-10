package project4329;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddShipmentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField shipmentID;
	private JTextField storeID;
	private JTextField inventoryID;
	private JTextField shipmentDate;
	private JTextField shipmentPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddShipmentDialog dialog = new AddShipmentDialog();
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
	public AddShipmentDialog() {
		setTitle("Add Shipment");
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
			JLabel lblNewLabel = new JLabel("Shipment ID");
			contentPanel.add(lblNewLabel, "2, 2, right, default");
		}
		{
			shipmentID = new JTextField();
			contentPanel.add(shipmentID, "4, 2, fill, default");
			shipmentID.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Store ID");
			contentPanel.add(lblNewLabel_1, "2, 4, right, default");
		}
		{
			storeID = new JTextField();
			contentPanel.add(storeID, "4, 4, fill, default");
			storeID.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Inventory ID");
			contentPanel.add(lblNewLabel_2, "2, 6, right, default");
		}
		{
			inventoryID = new JTextField();
			contentPanel.add(inventoryID, "4, 6, fill, default");
			inventoryID.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Shipment Date");
			contentPanel.add(lblNewLabel_3, "2, 8, right, default");
		}
		{
			shipmentDate = new JTextField();
			contentPanel.add(shipmentDate, "4, 8, fill, default");
			shipmentDate.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Shipment Price");
			contentPanel.add(lblNewLabel_4, "2, 10, right, default");
		}
		{
			shipmentPrice = new JTextField();
			contentPanel.add(shipmentPrice, "4, 10, fill, default");
			shipmentPrice.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Submit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String shipmentIDS = shipmentID.getText();
						int shipmentID = Integer.parseInt(shipmentIDS);		
						String storeIDS = storeID.getText();
						int storeID = Integer.parseInt(storeIDS);	
						String inventoryIDS = inventoryID.getText();
						int inventoryID = Integer.parseInt(inventoryIDS);	
						String shipmentPriceS = shipmentPrice.getText();
						double shipmentPrice = Double.parseDouble(shipmentPriceS);
						try {
						PreparedStatement stmt = conn.prepareStatement("INSERT INTO Shipment values(?, ?, ?, ?, ?)");
						stmt.setInt(1, shipmentID);
						stmt.setInt(2, storeID);
						stmt.setInt(3, inventoryID);
						stmt.setString(4, shipmentDate.getText());
						stmt.setDouble(5, shipmentPrice);
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
