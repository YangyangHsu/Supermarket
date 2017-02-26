package actionBase;

import com.opensymphony.xwork2.ActionSupport;

import service.CustomerPayment;

public class CustomerBaseAction extends ActionSupport {
	protected CustomerPayment customerPayment;

	public void setCustomerPayment(CustomerPayment cusPay) {
		this.customerPayment = cusPay;
	}
}
