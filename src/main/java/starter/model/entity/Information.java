package starter.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "myInfo")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String info;

}
