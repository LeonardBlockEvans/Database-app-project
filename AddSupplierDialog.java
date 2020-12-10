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

public class AddSupplierDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField supplierSupplierID;
	private JTextField supplierSupplierName;
	private JTextField supplierContactFirstName;
	private JTextField supplierContactLastName;
	private JTextField supplierStateID;
	private JTextField supplierCity;
	private JTextField supplierStreetAddress;
	private JTextField supplierZip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddSupplierDialog dialog = new AddSupplierDialog();
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
	public AddSupplierDialog() {
		setTitle("Add Supplier");
		try {
			conn = DriverManager.getConnection("Client", "USER",
					"PASS");
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 450, 300);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("2dlu"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lbSupplierSupplierID = new JLabel("Supplier ID");
			contentPanel.add(lbSupplierSupplierID, "2, 2");
		}
		{
			supplierSupplierID = new JTextField();
			contentPanel.add(supplierSupplierID, "4, 2, fill, default");
			supplierSupplierID.setColumns(10);
		}
		{
			JLabel lbSupplierSupplierFName = new JLabel("Supplier Name");
			contentPanel.add(lbSupplierSupplierFName, "2, 4, right, default");
		}
		{
			supplierSupplierName = new JTextField();
			contentPanel.add(supplierSupplierName, "4, 4, fill, default");
			supplierSupplierName.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("First Name");
			contentPanel.add(lblNewLabel, "2, 6, left, default");
		}
		{
			supplierContactFirstName = new JTextField();
			contentPanel.add(supplierContactFirstName, "4, 6, fill, default");
			supplierContactFirstName.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Last Name");
			contentPanel.add(lblNewLabel_2, "2, 8");
		}
		{
			supplierContactLastName = new JTextField();
			contentPanel.add(supplierContactLastName, "4, 8, fill, default");
			supplierContactLastName.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("StateID");
			contentPanel.add(lblNewLabel_3, "2, 10");
		}
		{
			supplierStateID = new JTextField();
			contentPanel.add(supplierStateID, "4, 10, fill, default");
			supplierStateID.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("City");
			contentPanel.add(lblNewLabel_4, "2, 12, left, default");
		}
		{
			supplierCity = new JTextField();
			contentPanel.add(supplierCity, "4, 12, fill, default");
			supplierCity.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Address");
			contentPanel.add(lblNewLabel_5, "2, 14, left, default");
		}
		{
			supplierStreetAddress = new JTextField();
			contentPanel.add(supplierStreetAddress, "4, 14, fill, default");
			supplierStreetAddress.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Zip");
			contentPanel.add(lblNewLabel_6, "2, 16, left, default");
		}
		{
			supplierZip = new JTextField();
			contentPanel.add(supplierZip, "4, 16, fill, default");
			supplierZip.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Submit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String supplierIDS = supplierSupplierID.getText();
							int supplierID = Integer.parseInt(supplierIDS);		
							String supplierStateIDS = supplierStateID.getText();
							int supplierStateID = Integer.parseInt(supplierStateIDS);		
							String supplierZipS = supplierZip.getText();
							int supplierZip = Integer.parseInt(supplierZipS);		
							try {
							PreparedStatement stmt = conn.prepareStatement("INSERT INTO Supplier values(?, ?, ?, ?, ?, ?, ?, ?)");

							stmt.setInt(1, supplierID);
							stmt.setString(2, supplierSupplierName.getText());
							stmt.setString(3, supplierContactFirstName.getText());
							stmt.setString(4, supplierContactLastName.getText());
							stmt.setInt(5, supplierStateID);
							stmt.setString(6, supplierCity.getText());
							stmt.setString(7, supplierStreetAddress.getText());
							stmt.setInt(8, supplierZip);
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
