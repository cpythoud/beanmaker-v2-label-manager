package org.beanmaker.labels;

import org.beanmaker.v2.runtime.BeanMakerBaseServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateLabelServlet extends BeanMakerBaseServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idLabel = getExpectedLongParameter(request, "idLabel");
        long idLanguage = getExpectedLongParameter(request, "idLanguage");
        String value = getExpectedStringParameter(request, "value");

        LabelEditor.quickUpdate(idLabel, idLanguage, value);

        response.setContentType("text/json; charset=UTF-8");
        response.getWriter().println(getJsonOk());
    }

}
