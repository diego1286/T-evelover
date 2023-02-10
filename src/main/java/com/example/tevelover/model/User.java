package com.example.tevelover.model;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    //private  static  final long serialVersionUID=1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    @Column(name ="name", length = 255, nullable = false)
    private String name;

    @Column(name = "last_name",length = 255, nullable = false)
    private String lastName;

    @Column(name = "created_at")
    private LocalDateTime datetime;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "gender", length = 255, nullable = false)
    private String gender;

    @Column(name = "age")
    private Integer age;

    @PostPersist
    public void prePersits(){
        if(datetime== null){
            datetime= LocalDateTime.now();
        }
    }




}

