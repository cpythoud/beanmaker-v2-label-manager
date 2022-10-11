package org.beanmaker.labels;

import org.beanmaker.v2.runtime.BeanMakerBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateLabelNameServlet extends BeanMakerBaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idLabel = getExpectedLongParameter(request, "idLabel");
        String value = getExpectedStringParameter(request, "value");

        var label = new LabelEditor(idLabel);
        label.setName(value);
        String json;
        if (label.isNameUnique()) {
            label.updateDB();
            json = getJsonOk();
        } else {
            json = """
                    {
                        "status": "error",
                        "errorMessage": "%s"
                    }"""
                    .formatted(LabelManager.get("label-manager-not-unique-error", Configuration.getCurrentConfiguration().getDefaultLanguage()));
        }

        response.setContentType("text/json; charset=UTF-8");
        response.getWriter().println(json);
    }

}
