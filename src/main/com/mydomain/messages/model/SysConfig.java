package com.mydomain.messages.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SysConfig {

	private String configKey;
	private String configValue;
	private String description;

	@Id
	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
