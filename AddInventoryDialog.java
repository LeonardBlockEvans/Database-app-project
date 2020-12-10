package project4329;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddInventoryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField inventoryID;
	private JTextField warehouseID;
	private JTextField productID;
	private JTextField quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddInventoryDialog dialog = new AddInventoryDialog();
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
	public AddInventoryDialog() {
		setTitle("Add Inventory");
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Inventory ID");
			contentPanel.add(lblNewLabel, "2, 2");
		}
		{
			inventoryID = new JTextField();
			contentPanel.add(inventoryID, "4, 2, fill, default");
			inventoryID.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Warehouse ID");
			contentPanel.add(lblNewLabel_1, "2, 4");
		}
		{
			warehouseID = new JTextField();
			contentPanel.add(warehouseID, "4, 4, fill, default");
			warehouseID.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Product ID");
			contentPanel.add(lblNewLabel_2, "2, 6");
		}
		{
			productID = new JTextField();
			contentPanel.add(productID, "4, 6, fill, default");
			productID.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Quantity");
			contentPanel.add(lblNewLabel_3, "2, 8");
		}
		{
			quantity = new JTextField();
			contentPanel.add(quantity, "4, 8, fill, default");
			quantity.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Submit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String productIDS = productID.getText();
						int productID = Integer.parseInt(productIDS);		
						String inventoryIDS = inventoryID.getText();
						int inventoryID = Integer.parseInt(inventoryIDS);	
						String warehouseIDS = warehouseID.getText();
						int warehouseID = Integer.parseInt(warehouseIDS);	
						String quantityS = quantity.getText();
						int quantity = Integer.parseInt(quantityS);	
						try {
						PreparedStatement stmt = conn.prepareStatement("INSERT INTO Inventory values(?, ?, ?, ?)");
						stmt.setInt(1, inventoryID);
						stmt.setInt(2, warehouseID);
						stmt.setInt(3, productID);
						stmt.setInt(4, quantity);
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
