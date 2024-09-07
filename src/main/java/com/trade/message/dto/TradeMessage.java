package com.trade.message.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TradeMessage {
	
	
	public TradeMessage(String tradeId, String account, String securityId, String idSource, String isin, String sedol,
			String cusip, String ric, String ticker, Integer qty, Double price) {
		super();
		this.tradeId = tradeId;
		this.account = account;
		this.securityId = securityId;
		this.idSource = idSource;
		this.isin = isin;
		this.sedol = sedol;
		this.cusip = cusip;
		this.ric = ric;
		this.ticker = ticker;
		this.qty = qty;
		this.price = price;
	}
	enum IdSource { ISIN, CUSIP, SEDOL, RIC }
	String tradeId;
	String account;
	String securityId;
	//Security details
	String idSource;
	String isin;
	String sedol;
	String cusip;	
	String ric;
	String ticker;
	//Security details end 
	Integer qty;
	Double price;
	
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getIdSource() {
		return idSource;
	}
	public void setIdSource(String idSource) {
		this.idSource = idSource;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public String getSedol() {
		return sedol;
	}
	public void setSedol(String sedol) {
		this.sedol = sedol;
	}
	public String getCusip() {
		return cusip;
	}
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}
	public String getRic() {
		return ric;
	}
	public void setRic(String ric) {
		this.ric = ric;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
