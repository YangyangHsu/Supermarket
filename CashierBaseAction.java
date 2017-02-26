package actionBase;

import com.opensymphony.xwork2.ActionSupport;

import service.CashierPayment;

public class CashierBaseAction extends ActionSupport{
	protected CashierPayment cashPay;
	
	public void setCashierPayment(CashierPayment cashPay){
		this.cashPay = cashPay;
	}
}
