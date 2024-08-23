package lk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherModel {

    private int tid;
    private String name;
    private String address;
    private int phone;

}
