package org.beanmaker.labels;

import java.util.List;

public class HtmlWrapper {

    public List<Language> getLanguages() {
        return Language.getAll();
    }

    public String getAddLabelSymbol() {
        return HeroIcons.getSVGCode("plus", "w-7 h-7");
    }

}
