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

public class AddStoreDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField storeID;
	private JTextField storeName;
	private JTextField fName;
	private JTextField lName;
	private JTextField stateID;
	private JTextField city;
	private JTextField streetAddress;
	private JTextField zip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddStoreDialog dialog = new AddStoreDialog();
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
	public AddStoreDialog() {
		setTitle("Add Store ");
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Store ID");
			contentPanel.add(lblNewLabel, "2, 2");
		}
		{
			storeID = new JTextField();
			contentPanel.add(storeID, "4, 2, fill, default");
			storeID.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Store Name");
			contentPanel.add(lblNewLabel_1, "2, 4");
		}
		{
			storeName = new JTextField();
			contentPanel.add(storeName, "4, 4, fill, default");
			storeName.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("First Name");
			contentPanel.add(lblNewLabel_2, "2, 6");
		}
		{
			fName = new JTextField();
			contentPanel.add(fName, "4, 6, fill, default");
			fName.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Last Name");
			contentPanel.add(lblNewLabel_3, "2, 8");
		}
		{
			lName = new JTextField();
			contentPanel.add(lName, "4, 8, fill, default");
			lName.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("State ID");
			contentPanel.add(lblNewLabel_4, "2, 10");
		}
		{
			stateID = new JTextField();
			contentPanel.add(stateID, "4, 10, fill, default");
			stateID.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("City");
			contentPanel.add(lblNewLabel_5, "2, 12");
		}
		{
			city = new JTextField();
			contentPanel.add(city, "4, 12, fill, default");
			city.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Address");
			contentPanel.add(lblNewLabel_6, "2, 14");
		}
		{
			streetAddress = new JTextField();
			contentPanel.add(streetAddress, "4, 14, fill, default");
			streetAddress.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Zip");
			contentPanel.add(lblNewLabel_7, "2, 16");
		}
		{
			zip = new JTextField();
			contentPanel.add(zip, "4, 16, fill, default");
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
						String storeIDS = storeID.getText();
						int storeID = Integer.parseInt(storeIDS);		
						String stateIDS = stateID.getText();
						int stateID = Integer.parseInt(stateIDS);		
						String zipS = zip.getText();
						int zip = Integer.parseInt(zipS);		
						try {
						PreparedStatement stmt = conn.prepareStatement("INSERT INTO Store values(?, ?, ?, ?, ?, ?, ?, ?)");
						stmt.setInt(1, storeID);
						stmt.setString(2, storeName.getText());
						stmt.setString(3, fName.getText());
						stmt.setString(4, lName.getText());
						stmt.setInt(5, stateID);
						stmt.setString(6, city.getText());
						stmt.setString(7, streetAddress.getText());
						stmt.setInt(8, zip);
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
