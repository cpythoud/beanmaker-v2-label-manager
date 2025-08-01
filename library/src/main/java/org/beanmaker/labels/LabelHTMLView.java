// Generated by BeanMaker V2, on September 21, 2022 at 9:12:19 AM COT
// Library Version #1.0-SNAPSHOT-build#20919

package org.beanmaker.labels;

import javax.annotation.processing.Generated;

import org.beanmaker.v2.runtime.DbBeanLanguage;
import org.beanmaker.v2.runtime.HttpRequestParameters;

import java.util.HashMap;
import java.util.Map;

@Generated(value = "org.beanmaker.v2.codegen.BeanHTMLViewSourceFile", date = "2022-09-21T14:12:19.721931300Z", comments = "EDITABLE,1.0-SNAPSHOT-20919")
public final class LabelHTMLView extends LabelHTMLViewBase {

	private Map<Language, String> values = new HashMap<>();

	public LabelHTMLView(LabelEditor labelEditor, DbBeanLanguage dbBeanLanguage) {
		super(labelEditor, dbBeanLanguage);
	}

	@Override
	public void setAllFields(HttpRequestParameters parameters) {
		super.setAllFields(parameters);

		values.clear();
		for (Language language: Language.getAll()) {
			String tag = language.getTag();
			if (parameters.hasParameter(tag))
				values.put(language, parameters.getValue(tag));
		}
	}

	@Override
	public void updateDB() {
		labelEditor.updateDB();
		labelEditor.updateValues(values);
	}

}
