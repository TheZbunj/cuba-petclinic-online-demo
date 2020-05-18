package com.haulmont.sample.petclinic.core.role;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.app.role.annotation.SpecificAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;
import com.haulmont.cuba.security.role.SpecificPermissionsContainer;
import com.haulmont.sample.petclinic.entity.owner.Owner;
import com.haulmont.sample.petclinic.entity.pet.Pet;
import com.haulmont.sample.petclinic.entity.pet.PetType;
import com.haulmont.sample.petclinic.entity.veterinarian.Specialty;
import com.haulmont.sample.petclinic.entity.veterinarian.Veterinarian;
import com.haulmont.sample.petclinic.entity.visit.Visit;

@Role(name = NurseReactRole.NAME, securityScope = "REST")
public class NurseReactRole extends AnnotatedRoleDefinition {

  public final static String NAME = "Nurse-React";

  @EntityAccess(entityClass = Visit.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
  @EntityAccess(entityClass = Pet.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
  @EntityAccess(entityClass = Owner.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
  @EntityAccess(entityClass = PetType.class, operations = {EntityOp.READ})
  @EntityAccess(entityClass = Specialty.class, operations = {EntityOp.READ})
  @EntityAccess(entityClass = Veterinarian.class, operations = {EntityOp.READ})
  @EntityAccess(entityClass = User.class, operations = {EntityOp.READ})
  @Override
  public EntityPermissionsContainer entityPermissions() {
    return super.entityPermissions();
  }


  @EntityAttributeAccess(entityClass = Owner.class, modify = "*")
  @EntityAttributeAccess(entityClass = Pet.class, modify = "*")
  @EntityAttributeAccess(entityClass = Visit.class, modify = "*")
  @EntityAttributeAccess(entityClass = PetType.class, view = "*")
  @EntityAttributeAccess(entityClass = Specialty.class, view = "*")
  @EntityAttributeAccess(entityClass = Veterinarian.class, view = "*")
  @EntityAttributeAccess(entityClass = User.class, view = "*")
  @EntityAttributeAccess(entityClass = Visit.class, modify = "pet") // TODO: remove when https://github.com/cuba-platform/cuba/issues/2869 is solved
  @Override
  public EntityAttributePermissionsContainer entityAttributePermissions() {
    return super.entityAttributePermissions();
  }

  @SpecificAccess(permissions = {
      "cuba.restApi.enabled"
  })
  @Override
  public SpecificPermissionsContainer specificPermissions() {
    return super.specificPermissions();
  }
}
