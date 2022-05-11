package serializationdeserialization;

import serialization.util.SerializationUtil;

import java.io.IOException;

public class Application {
    public static void main(String[] args)
    {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Rashad Nasirli");
        emp.setSalary(5000);

        //serialize to file
        try {
            SerializationUtil.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        System.out.println(empNew.getName()); //we got this name by deserializing the objecgt that we took
       // System.out.println("emp Object::"+emp);
       // System.out.println("empNew Object::"+empNew);
    }
}
