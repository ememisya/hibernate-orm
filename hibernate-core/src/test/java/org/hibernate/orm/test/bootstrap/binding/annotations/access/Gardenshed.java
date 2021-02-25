/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

//$Id$
package org.hibernate.orm.test.bootstrap.binding.annotations.access;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import javax.persistence.Access;

/**
 * This is the opposite of the Furniture test, as this tries to override the class Access(AccessType.PROPERTY) with
 * the property Access(AccessType.FIELD).
 *
 * @author Dennis Fleurbaaij
 * @since 2007-05-31
 */
@Entity
@Access(javax.persistence.AccessType.PROPERTY)
public class Gardenshed
		extends
		Woody {
	private Integer id;
	private String brand;
	public long floors;

	@Transient
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// These 2 functions should not return in Hibernate, but the value should come from the field "floors"
	@Access(AccessType.FIELD)
	public long getFloors() {
		return this.floors + 2;
	}

	public void setFloors(long floors) {
		this.floors = floors + 2;
	}
}
