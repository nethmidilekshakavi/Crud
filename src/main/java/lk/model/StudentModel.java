package lk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentModel {
    private int sid;
    private String name;
    private  String address;
    private int phone;

}
