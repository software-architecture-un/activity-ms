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
    private String description;
    private long qualification;
    private long visits;
    private Date dead; // fecha que muere la actividad

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

    public Long getQualification() {
        return qualification;
    }
    public void setQualification(Long qualification) {
        this.qualification = qualification;
    }

    public Long getVisits() {
        return visits;
    }
    public void setVisits(Long visits) {
        this.visits = visits;
    }

    

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDead() {
        return dead;
    }
      public void setDead(Date dead)   {
          this.dead = dead;

        }
}
