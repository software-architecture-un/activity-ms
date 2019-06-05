package sa.activity.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "activities")
@NamedQueries({@NamedQuery(name = Activity.FIND_ALL, query = "SELECT u FROM Activity u")})
public class Activity {

    public static final String FIND_ALL = "Activity.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int user;// el usuario quien creo la tarea
    private int place;
    //private long userid;
    private String description;


      public Long getId() {
          return id;
      }
      public void setId(Long id) {
          this.id = id;
      }

      public String getName(){
        return name;
      }
      public void setName(String name){
        this.name = name;
      }

      public int getUser() {
          return user;
      }
      public void setUser(int user) {
          this.user= user;
      }

      public int getPlace() {
          return place;
      }

      public void setPlace(int place) {
          this.place = place;
      }

      public String getDescription() {
          return description;
      }
      public void setDescription(String description) {
          this.description = description;
      }

}
