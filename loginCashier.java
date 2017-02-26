package actionCashier;



import static service.CashierPayment.LOGIN_SUCC;

import com.opensymphony.xwork2.ActionContext;

import actionBase.CashierBaseAction;
import actionBase.WebConstant;
import domain.Cashier;


public class loginCashier extends CashierBaseAction{
	private Cashier cashier;
	private String tip;
	
	public Cashier getCashier(){
		return cashier;
	}
	public void setCashier(Cashier cashier){
		this.cashier = cashier;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		int result = cashPay.validLogin(getCashier());
		if(result == LOGIN_SUCC)
		{
			ctx.getSession().put(WebConstant.USER,cashier.getCashierName());
			setTip("Login Successfully.");
			return "SUCCESS";
		}
		else
		{
			setTip("Wrong username or password.");
			return "LOGIN";
		}
	}
}
