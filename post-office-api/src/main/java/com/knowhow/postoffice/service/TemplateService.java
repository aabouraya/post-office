package com.knowhow.postoffice.service;

import java.util.Map;

public interface TemplateService {

    String load(String templateName, Map<String, Object> model);
}
