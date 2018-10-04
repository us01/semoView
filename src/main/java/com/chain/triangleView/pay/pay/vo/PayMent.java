package com.chain.triangleView.pay.pay.vo;

public class PayMent {
	private String imp_uid; //결제 상세 번호
	private int apply_num;  //카드승인번호
	private int amount; //결제금액
	private int payCode; //결제코드
	
	public PayMent(){}

	public PayMent(String imp_uid, int apply_num, int amount, int payCode) {
		super();
		this.imp_uid = imp_uid;
		this.apply_num = apply_num;
		this.amount = amount;
		this.payCode = payCode;
	}

	public String getImp_uid() {
		return imp_uid;
	}

	public int getApply_num() {
		return apply_num;
	}

	public int getAmount() {
		return amount;
	}

	public int getPayCode() {
		return payCode;
	}

	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}

	public void setApply_num(int apply_num) {
		this.apply_num = apply_num;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setPayCode(int payCode) {
		this.payCode = payCode;
	}

	@Override
	public String toString() {
		return "PayMent [imp_uid=" + imp_uid + ", apply_num=" + apply_num + ", amount=" + amount + ", payCode="
				+ payCode + "]";
	}


	

	
	
}
