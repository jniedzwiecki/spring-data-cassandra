/*
 * Copyright 2013-2014 the original author or authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.cassandra.mapping;

import java.util.List;
import java.util.Map;

import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.cassandra.core.keyspace.TableOption;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.model.MutablePersistentEntity;

/**
 * Cassandra specific {@link PersistentEntity} abstraction.
 * 
 * @author Alex Shvid
 * @author Matthew T. Adams
 */
public interface CassandraPersistentEntity<T> extends MutablePersistentEntity<T, CassandraPersistentProperty>,
		ApplicationContextAware {

	/**
	 * Returns whether this entity represents a composite primary key.
	 */
	boolean isCompositePrimaryKey();

	List<CassandraPersistentProperty> getCompositePrimaryKeyProperties();

	/**
	 * Returns the table name to which the entity shall be persisted.
	 */
	CqlIdentifier getTableName();

	void setTableName(CqlIdentifier tableName);

	CassandraMappingContext getMappingContext();

	ApplicationContext getApplicationContext();

	void setForceQuote(boolean forceQuote);


	/**
	 * Returns {@link TableOption}s and values associated with the entity
	 */
	Map<TableOption, Object> getTableOptions();

	EntityDiscriminator<T> getEntityDiscriminator();

}
