package main.util;

import main.model.Address;
import main.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmployeeUtil {

    public static List<Employee> getEmployeeList (int n){
        List<Employee> employeeList = new ArrayList<>();
        int minValue = 23;
        int maxValue = 60;
        Random rn = new Random();

        List<String> gnList = Arrays.asList("M", "F");
        List<String> cityList = Arrays.asList("Calcuta", "Bangalore", "Mumbai");

        List<String> stateList = Arrays.asList("Haryana", "Delhi", "Goa");


        for(int i=1;i<=n;i++){
            Employee employee = new Employee(i,"F"+rn.nextInt(0,n),"L"+rn.nextInt(0,n),
                    minValue + rn.nextInt(maxValue - minValue + 1),
                    rn.nextDouble(10000,100000),gnList.get(rn.nextInt(gnList.size()))
            );

            int addCount = rn.nextInt(0,2);
            List<Address> addressList = new ArrayList<>();
            for(int j=1;j<=addCount;j++){
                addressList.add(new Address(j,"line " + rn.nextInt(), "ad " + rn.nextInt(),
                        cityList.get(rn.nextInt(gnList.size())), stateList.get(rn.nextInt(gnList.size())),
                        employee));
            }
            employee.setAddressList(addressList);
            employeeList.add(employee);


        }
        return employeeList;
    }
}
