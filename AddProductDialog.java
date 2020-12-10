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
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddProductDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField productID;
	private JTextField supplierID;
	private JTextField productName;
	private JTextField productType;
	private JTextField productPrice;
	private JTextField productDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProductDialog dialog = new AddProductDialog();
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
	public AddProductDialog() {
		setTitle("Add Product");
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Product ID");
			contentPanel.add(lblNewLabel, "2, 2");
		}
		{
			productID = new JTextField();
			productID.setToolTipText("");
			contentPanel.add(productID, "4, 2, fill, default");
			productID.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Supplier ID");
			contentPanel.add(lblNewLabel_1, "2, 4");
		}
		{
			supplierID = new JTextField();
			contentPanel.add(supplierID, "4, 4, fill, default");
			supplierID.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Product Name");
			contentPanel.add(lblNewLabel_2, "2, 6");
		}
		{
			productName = new JTextField();
			contentPanel.add(productName, "4, 6, fill, default");
			productName.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Product Type");
			contentPanel.add(lblNewLabel_3, "2, 8");
		}
		{
			productType = new JTextField();
			contentPanel.add(productType, "4, 8, fill, default");
			productType.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Product Price");
			contentPanel.add(lblNewLabel_4, "2, 10");
		}
		{
			productPrice = new JTextField();
			contentPanel.add(productPrice, "4, 10, fill, default");
			productPrice.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Product Description");
			contentPanel.add(lblNewLabel_5, "2, 12");
		}
		{
			productDesc = new JTextField();
			contentPanel.add(productDesc, "4, 12, fill, default");
			productDesc.setColumns(10);
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
						String supplierIDS = supplierID.getText();
						int supplierID = Integer.parseInt(supplierIDS);	
						String productPriceS = productPrice.getText();
						double productPrice = Double.parseDouble(productPriceS);	
						try {
						PreparedStatement stmt = conn.prepareStatement("INSERT INTO product values(?, ?, ?, ?, ?, ?)");
						stmt.setInt(1, productID);
						stmt.setInt(2, supplierID);
						stmt.setString(3, productName.getText());
						stmt.setString(4, productType.getText());
						stmt.setDouble(5, productPrice);
						stmt.setString(6, productDesc.getText());
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
