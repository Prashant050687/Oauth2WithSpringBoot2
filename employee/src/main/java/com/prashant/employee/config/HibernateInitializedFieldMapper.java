package com.prashant.employee.config;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.collection.internal.AbstractPersistentCollection;

/**
 * Hibernate custom field mapper for lazy initialized collections.
 * @author prashant
 *
 */
public class HibernateInitializedFieldMapper implements CustomFieldMapper {

  @Override
  public boolean mapField(Object source, Object destination, Object sourceFieldValue,
    ClassMap classMap, FieldMap fieldMapping) {
    return sourceFieldValue instanceof AbstractPersistentCollection &&
      !((AbstractPersistentCollection) sourceFieldValue).wasInitialized();
  }

}
