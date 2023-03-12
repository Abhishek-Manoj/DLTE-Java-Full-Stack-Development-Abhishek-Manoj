package student.details;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student implements Serializable {
    private Long regNo;
    private String name,email;
    private int age;
    private Map<String, String> address;

//    public Student(Long regNo, String name, String email, int age, Map<String, String> address) {
//        this.regNo = regNo;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.address = address;
//    }
}
