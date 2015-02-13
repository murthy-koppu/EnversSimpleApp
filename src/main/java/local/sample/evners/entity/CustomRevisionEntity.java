package local.sample.evners.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import local.sample.evners.util.CustomRevisionEntityListener;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@Table
@RevisionEntity(CustomRevisionEntityListener.class)
public class CustomRevisionEntity extends DefaultRevisionEntity {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
