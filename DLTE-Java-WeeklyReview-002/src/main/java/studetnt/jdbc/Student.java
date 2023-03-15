package studetnt.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long regNo,contact;
    private String name,email,street,city,state;
    private int age,zip;
}
