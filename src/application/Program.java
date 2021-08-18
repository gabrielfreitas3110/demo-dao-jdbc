package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerdao = DaoFactory.createSellerDao();
		Seller seller = sellerdao.findbyId(3);
		System.out.println(seller);
	}
}