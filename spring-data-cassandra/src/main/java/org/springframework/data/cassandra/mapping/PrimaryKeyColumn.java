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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;

/**
 * Identifies the annotated field of a composite primary key class as a primary key field that is either a partition or
 * cluster key field.
 * 
 * @author Matthew T. Adams
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
public @interface PrimaryKeyColumn {

	/**
	 * The name of the column in the table.
	 */
	String name() default "";

	/**
	 * The order of this column relative to other primary key columns.
	 */
	int ordinal();

	/**
	 * The type of this key column. Default is {@link PrimaryKeyType#CLUSTERED}.
	 */
	PrimaryKeyType type() default PrimaryKeyType.CLUSTERED;

	/**
	 * The cluster ordering of this column if {@link #type()} is {@link PrimaryKeyType#CLUSTERED}, otherwise ignored.
	 * Default is {@link Ordering#ASCENDING}.
	 */
	Ordering ordering() default Ordering.ASCENDING;

	/**
	 * Whether to cause the column name to be force-quoted.
	 */
	boolean forceQuote() default false;

	/**
	 * A free-form, human-readable comment describing the column.
	 */
	String comment() default "";
}
