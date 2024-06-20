package bean;

public class OrderItem {
	
	private String userid;//購入したユーザーのID
	
	private String order_no;//購入された商品の番号
	
	private String product_id;//購入された商品のID
	
	private String sold_date;//購入日付
	
	private String dealing;//取引状況ステータス
	
	private String deposit_status;//入金状況
	
	private String shipment_status;//配送状況
	//コンストラクタ
	
	public OrderItem() {
		this.userid = null;
		this.order_no = null;
		this.product_id =null;
		this.sold_date = null;
		this.dealing = null;
		this.deposit_status = null;
		this.shipment_status = null;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getorder_no() {
		return order_no;
	}
	public void setorder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getsold_date() {
		return sold_date;
	}
	public void setsold_date(String sold_date) {
		this.sold_date = sold_date;
	}

	public String getdeposit_status() {
		return deposit_status;
	}
	public void setdeposit_status(String deposit_status) {
		this.deposit_status = deposit_status;
	}
	
	public String getproduct_id() {
		return product_id;
	}
	public void setproduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public String getdealing() {
		return dealing;
	}
	public void setdealing(String dealing) {
		this.dealing = dealing;
	}
	
	public String getshipment_status() {
		return shipment_status;
	}
	public void setshipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}

}