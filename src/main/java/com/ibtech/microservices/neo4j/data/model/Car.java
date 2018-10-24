/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package com.ibtech.microservices.neo4j.data.model;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Car {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private int year;

	@Relationship(type = "MANUFACTURES", direction = Relationship.INCOMING)
	private Brand brand;

	@Relationship(type = "HAS", direction = Relationship.INCOMING)
	private Person owner;


	public Car(String name, int year) {
		this();
		this.name = name;
		this.year = year;
	}

	public Car() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Person getOwners() {
		return owner;
	}

	public Brand getBrand(){ return  brand; }

	public void setBrand(Brand brand){ this.brand = brand; }

	public int getYear(){ return  year; }

	@Override
	public String toString() {
		return "Car{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", owner=" + owner +
				", owner=" + brand +
				'}';
	}

	public void updateFrom(Car car) {
		this.name = car.getName();
	}
}
