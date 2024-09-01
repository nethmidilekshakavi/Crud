package lk.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class custom {

    /*Student*/
    private int sid;
    private String name;
    private  String address;
    private int phone;

    /*Teacher*/
    private int tid;
    /*private String name;
    private String address;
    private int phone;*/

}
