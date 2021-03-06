/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.elasticsearch.core.facet;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Simple type to test facets
 *
 * @author Artur Konczak
 * @author Mohsin Husen
 */

@Document(indexName = "logs", type = "log", shards = 1, replicas = 0, refreshInterval = "-1", indexStoreType = "memory")
public class LogEntity {

	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Id
	private String id;

	private String action;

	private long sequenceCode;

	@Field(type = FieldType.Date, format = DateFormat.basic_date_time)
	private Date date;

	private LogEntity() {
	}

	public LogEntity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public String toString() {
		return new StringBuffer().append("{id:").append(id).append(",action:").append(action).append(",code:").append(sequenceCode).append(",date:").append(format.format(date)).append("}").toString();
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getSequenceCode() {
		return sequenceCode;
	}

	public void setSequenceCode(long sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
