package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TESTE 1: Department findById ====");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("\n=== TESTE 2: Department findAll ====");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 3: Department insert ====");
        Department newDepartment = new Department(null, "Series");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id = " + newDepartment.getId());

        System.out.println("\n=== TESTE 4: Department update ====");
        dep = departmentDao.findById(8);
        dep.setName("Ebooks");
        departmentDao.update(dep);
        System.out.println("Update completed!");

        System.out.println("\n=== TESTE 5: Department delete ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");


        sc.close();
    }
}
