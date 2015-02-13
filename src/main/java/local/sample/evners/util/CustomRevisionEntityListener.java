package local.sample.evners.util;

import local.sample.evners.entity.CustomRevisionEntity;

import org.hibernate.envers.RevisionListener;

public class CustomRevisionEntityListener implements RevisionListener {

    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity customEntity = (CustomRevisionEntity) revisionEntity;
        customEntity.setUsername("murthy");
    }

}
