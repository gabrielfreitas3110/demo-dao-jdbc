package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.findbyId(3);
		System.out.println(seller);
		

		System.out.println("\n==== TEST 2: seller findByIdDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Maria", "Maria@gmail.com", new Date(), 9800.99, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller update ====");
		seller = sellerDao.findbyId(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 6: seller delete ====");
		System.out.println("Enter seller id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");

		
		System.out.println("==== TEST 7: department findById ====");
		Department dep = departmentDao.findbyId(2);
		System.out.println(dep);
		
		
		System.out.println("\n==== TEST 8: department findAll ====");
		List<Department> listDep = departmentDao.findAll();
		for (Department obj : listDep) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 9: department insert ====");
		Department newDepartment = new Department(null, "E-Books");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 10: department update ====");
		department = departmentDao.findbyId(1);
		department.setName("New Computers");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 11: department delete ====");
		System.out.println("Enter department id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		sc.close();
	}
}