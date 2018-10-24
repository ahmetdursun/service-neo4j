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
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Relationship(type = "HAS")
	private Set<Car> cars;


	public Person() {
		this.cars = new HashSet<>();
	}

	public Person(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public Set<Car> getCours() {
		return cars;
	}


	@Override
	public String toString() {
		return "Student{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", cars=" + cars.size() +
				'}';
	}

	public void updateFrom(Person person) {
		this.name = person.name;
	}
}
