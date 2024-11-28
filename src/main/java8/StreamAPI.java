package main.java8;

import main.model.Address;
import main.model.Employee;
import main.util.EmployeeUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeUtil.getEmployeeList(10);


        employeeList.stream().forEach(emp -> System.out.println(emp));

        System.out.println("Sorted list");
        List<Employee> sortedList =  employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
        sortedList.stream().forEach(emp -> System.out.println(emp));


        Set<Employee> employeesSet = employeeList.stream().collect(Collectors.toSet());
        System.out.println("List to set");
        employeesSet.stream().forEach(employee -> System.out.println(employee));


        System.out.println("Grouping by first name");
        Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getFirstName));
        System.out.println(map);

        System.out.println("Grouping by first name - count");
        Map<String, Long> map2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getFirstName,Collectors.counting()));
        System.out.println(map2);


        System.out.println("Dist list");
        List<Employee> distList = employeeList.stream().distinct().toList();
        System.out.println(distList);


        Double avgAge = employeeList.stream().mapToInt(Employee::getAge).average().getAsDouble();
        System.out.println(avgAge);


        System.out.println("Addres list");
        List<Address> addressList = employeeList.stream().flatMap((Employee employee) -> employee.getAddressList().stream()).toList();
        addressList.forEach(address -> System.out.println(address));


        System.out.println("Addres list");


        Map<String, List<Address>> employeeMap=  employeeList.stream()
                .flatMap((Employee employee) -> employee.getAddressList().stream())
                .collect(Collectors.groupingBy(Address::getCity));


    }
}
