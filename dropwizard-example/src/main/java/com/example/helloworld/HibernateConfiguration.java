package com.example.helloworld;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.collect.Lists;

@SuppressWarnings({ "FieldMayBeFinal", "UnusedDeclaration" })
public class HibernateConfiguration {
	@NotNull
    @JsonProperty
    private String username = null;

    @NotNull
    @JsonProperty
    private String dialect = null;


    @JsonProperty
    private String password = "";

    @NotNull
    @JsonProperty
    private String url = null;

    @NotNull
    @JsonProperty
    private int poolSize = 1;
    
    @NotNull
    @JsonProperty
    private List<String> entityClasses = Lists.newArrayList();
    
    public List<String> getEntityClasses() {
		return entityClasses;
	}
    
    public String getDialect() {
		return dialect;
	}
    public String getPassword() {
		return password;
	}
    public int getPoolSize() {
		return poolSize;
	}
    public String getUrl() {
		return url;
	}
    public String getUsername() {
		return username;
	}
}
