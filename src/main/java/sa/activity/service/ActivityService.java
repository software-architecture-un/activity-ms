package sa.activity.service;

import sa.activity.model.Activity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.*;

@Stateless
public class ActivityService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Activity> getAllActivitys(int first, int maxResult) {
        return entityManager.createNamedQuery(Activity.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Activity getActivityByCode(long code){
        return entityManager.find(Activity.class, code);
    }

    public Activity createActivity(Activity activity) {
        entityManager.persist(activity);
        entityManager.flush();
        return activity;
    }

    public Activity updateActivity(long id, Activity activity) {
        Activity activityToUpdate = entityManager.find(Activity.class, id);
        activityToUpdate.setName(activity.getName());
        activityToUpdate.setUser(activity.getUser());
        activityToUpdate.setPlace(activity.getPlace());
        activityToUpdate.setDescription(activity.getDescription());
        entityManager.merge(activityToUpdate);
        return entityManager.find(Activity.class, id);
    }

    public long deleteActivity(long id) {
        Activity activity = entityManager.find(Activity.class, id);
        entityManager.remove(activity);
        return id;
    }
}
