package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Gui.EditFeesView;
import Model.Manager;

//Controller to change the fee and pay period by the managers
public class PaymentController extends ParentController {
	
	Manager manager; 
	EditFeesView feeView;
	DBConnect db = new DBConnect();
	
	public PaymentController (Manager m, EditFeesView e) {
		this.feeView = e;
		this.manager = m;
		
		feeView.renterLandlordPerformed(new renterLandlordList());
		feeView.ListingsPerformed(new editListing());
		feeView.SummaryReportPerformed(new summaryReport());
		feeView.EditFeesPerformed(new editFee());
		feeView.updateStatus(new updteStatus());
	}
	
//action listeners are navigation, SwitchView is called when another view is needed
// that belong to different controller
	public class renterLandlordList implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        	switchView("RenterLandlordList");
        }
    }
	
	public class editListing implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        	switchView("ManagerEditView");
        }
    }
	
	public class summaryReport implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        	switchView("SummaryReportView");
        }
    }
	
	public class editFee implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        	feeView.draw();
        }
    }
	
	public class updteStatus implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {


			System.out.println("Fee Submit Button Pressed");

			int fee = feeView.getFee();
			int feePeriod = feeView.getPer();

			//Add this data to database.
			try {
				db.addFee(fee, feePeriod);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

				}
	}


	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
}
