package com.esvo.impl;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;



//@Document(indexName = "tanjunceshi",type= "test", indexStoreType = "string")
@Document(indexName = "hello_es",type= "test", indexStoreType = "string")
public class TempVo {
	public static final String indexName = "hello_es";
	
//	@Id
//    private String id;

	@Id
	private UserBean userBean;

	@Field(type = FieldType.Long)
	private long age;
	 
	@Field(type = FieldType.String)
	private String name;

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*@Override
	public String toString() {
		return "TempVo{" +
				"id='" + id + '\'' +
				", age=" + age +
				", name='" + name + '\'' +
				'}';
	}*/

	@Override
	public String toString() {
		return "TempVo{" +
				"userBean=" + userBean.toString() +
				", age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}
