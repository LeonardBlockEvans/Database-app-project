package project4329;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;


public class LBEDBApp extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LBEDBApp frame = new LBEDBApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;

	/**
	 * Create the frame.
	 */
	public LBEDBApp() {

		setTitle("LBE Database App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Open connection
		try {
			conn = DriverManager.getConnection("Client", "USER",
					"PASS");
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Button that selects data from the database
		JButton btnSTATELOOKUP = new JButton("State Lookup");
		btnSTATELOOKUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM STATELOOKUP";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// scroll pane to display the table
		JScrollPane scrollPane = new JScrollPane();
		
		// Button that select data from the database
		JButton btnSUPPLIER = new JButton("Supplier");
		btnSUPPLIER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM SUPPLIER";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that selects data from the database
		JButton btnSTORE = new JButton("Store");
		btnSTORE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM STORE";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that selects data from the database
		JButton btnWAREHOUSE = new JButton("Warehouse");
		btnWAREHOUSE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM WAREHOUSE";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that selects data from the database
		JButton btnPRODUCT = new JButton("Product");
		btnPRODUCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM PRODUCT";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that selects data from the database
		JButton btnINVENTORY = new JButton("Inventory");
		btnINVENTORY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM INVENTORY";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that selects data from the database
		JButton btnSHIPMENT = new JButton("Shipment");
		btnSHIPMENT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM SHIPMENT";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that displays an SQL view 
		JButton btnINVENTORYREPORT = new JButton("Inventory Report");
		btnINVENTORYREPORT.setBackground(SystemColor.info);
		btnINVENTORYREPORT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM ALLINVENTORY";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that displays an SQL view 
		JButton btnSHIPMENTREPORT = new JButton("Shipment Report");
		btnSHIPMENTREPORT.setBackground(SystemColor.info);
		btnSHIPMENTREPORT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM SHIPMENTINFO";
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// Button that opens a new window to add new data to the database
		JButton btnaddSupplier = new JButton("Add Supplier");
		btnaddSupplier.setBackground(SystemColor.activeCaption);
		btnaddSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSupplierDialog dialog = new AddSupplierDialog();
				dialog.setVisible(true);
			}
		});
		// Button that opens a new window to add new data to the database
		JButton btnAddStore = new JButton("Add Store");
		btnAddStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStoreDialog dialog = new AddStoreDialog();
				dialog.setVisible(true);
			}
		});
		btnAddStore.setBackground(SystemColor.activeCaption);
		// Button that opens a new window to add new data to the database
		JButton btnAddWarehouse = new JButton("Add Warehouse");
		btnAddWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWarehouseDialog dialog = new AddWarehouseDialog();
				dialog.setVisible(true);
			}
		});
		btnAddWarehouse.setBackground(SystemColor.activeCaption);
		// Button that opens a new window to add new data to the database
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductDialog dialog = new AddProductDialog();
				dialog.setVisible(true);
			}
		});
		btnAddProduct.setBackground(SystemColor.activeCaption);
		// Button that opens a new window to add new data to the database
		JButton btnAddInventory = new JButton("Add Inventory");
		btnAddInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddInventoryDialog dialog = new AddInventoryDialog();
				dialog.setVisible(true);
			}
		});
		btnAddInventory.setBackground(SystemColor.activeCaption);
		// Button that opens a new window to add new data to the database
		JButton btnAddShipment = new JButton("Add Shipment");
		btnAddShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddShipmentDialog dialog = new AddShipmentDialog();
				dialog.setVisible(true);
			}
		});
		btnAddShipment.setBackground(SystemColor.activeCaption);
		// set the close button to close the connection and window
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
					setVisible(false);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSTATELOOKUP, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnINVENTORYREPORT)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSHIPMENTREPORT, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnINVENTORY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnWAREHOUSE, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnSUPPLIER, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnaddSupplier, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnSTORE, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnAddStore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnAddWarehouse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnPRODUCT, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnAddProduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnAddInventory, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnSHIPMENT, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addComponent(btnAddShipment, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSTATELOOKUP)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnINVENTORYREPORT)
							.addComponent(btnSHIPMENTREPORT)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSUPPLIER)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnaddSupplier)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSTORE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddStore)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnWAREHOUSE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddWarehouse)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPRODUCT)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddProduct)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnINVENTORY)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddInventory)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSHIPMENT)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddShipment))
						.addComponent(scrollPane, 0, 0, Short.MAX_VALUE))
					.addGap(26)
					.addComponent(btnNewButton)
					.addContainerGap())
		);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
