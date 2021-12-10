package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.EditFeesView;
import Model.Manager;

public class PaymentController extends ParentController {
	
	Manager manager; 
	EditFeesView feeView;
	
	public PaymentController (Manager m, EditFeesView e) {
		this.feeView = e;
		this.manager = m;
		
		feeView.renterLandlordPerformed(new renterLandlordList());
		feeView.ListingsPerformed(new editListing());
		feeView.SummaryReportPerformed(new summaryReport());
		feeView.EditFeesPerformed(new editFee());
		feeView.updateStatus(new updteStatus());
	}
	
	
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
        	switchView("ManagerEditView");
        }
    }
	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
}
