package in.kiruba.impl;


import java.sql.SQLException;
import in.kiruba.model.SpecialOffer;

public interface SpecialOfferImp {
	
	public  SpecialOffer getOfferDetail(int plan) throws SQLException, ClassNotFoundException;

}
