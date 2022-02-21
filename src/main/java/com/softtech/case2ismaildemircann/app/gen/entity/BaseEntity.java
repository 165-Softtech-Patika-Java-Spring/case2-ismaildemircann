package com.softtech.case2ismaildemircann.app.gen.entity;

import lombok.Data;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Cloneable, Serializable {
}
