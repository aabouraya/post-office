package com.knowhow.postoffice.service.impl;

import com.knowhow.postoffice.service.TemplateService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final SpringTemplateEngine templateEngine;

    @Override
    public String load(String templateName, Map<String, Object> model) {
        Context context = new Context();
        context.setVariables(model);
        return templateEngine.process(templateName, context);
    }
}
