package org.beanmaker.labels;

import org.beanmaker.v2.runtime.dbutil.LabelHelper;

import org.beanmaker.v2.util.Strings;

import org.dbbeans.sql.DB;

public class Configuration {

    private static Configuration currentConfiguration;

    private final String languageTable;
    private final String labelTable;
    private final String labelDataTable;
    private final DB db;
    private final long defaultLanguageID;
    private final LabelHelper labelHelper;

    private Configuration(String languageTable, String labelTable, String labelDataTable, DB db, long defaultLanguageID) {
        if (Strings.isEmpty(languageTable))
            throw new IllegalStateException("Missing language table name");
        if (Strings.isEmpty(labelTable))
            throw new IllegalStateException("Missing label table name");
        if (Strings.isEmpty(labelDataTable))
            throw new IllegalStateException("Missing label data table name");
        if (db == null)
            throw new IllegalStateException("Missing DB parameter");
        if (defaultLanguageID < 1)
            throw new IllegalStateException("Illegal value for ID language: " + defaultLanguageID);

        this.languageTable = languageTable;
        this.labelTable = labelTable;
        this.labelDataTable = labelDataTable;
        this.db = db;
        this.defaultLanguageID = defaultLanguageID;

        labelHelper = new LabelHelper(labelTable, labelDataTable);
    }

    public static ConfigurationBuilder builder() {
        return new ConfigurationBuilder();
    }

    public static void setCurrentConfiguration(Configuration configuration) {
        currentConfiguration = configuration;
    }

    public static Configuration getCurrentConfiguration() {
        return currentConfiguration;
    }

    public String getLanguageTable() {
        return languageTable;
    }

    public String getLabelTable() {
        return labelTable;
    }

    public String getLabelDataTable() {
        return labelDataTable;
    }

    public DB getDb() {
        return db;
    }

    public long getDefaultLanguageID() {
        return defaultLanguageID;
    }

    public LabelHelper getLabelHelper() {
        return labelHelper;
    }

    public static class ConfigurationBuilder {

        private String languageTable = "languages";
        private String labelTable = "labels";
        private String labelDataTable = "label_data";
        private DB db;
        private long defaultLanguageID = 1;

        private ConfigurationBuilder() { }

        public ConfigurationBuilder setLanguageTable(String languageTable) {
            this.languageTable = languageTable;
            return this;
        }

        public ConfigurationBuilder setLabelTable(String labelTable) {
            this.labelTable = labelTable;
            return this;
        }

        public ConfigurationBuilder setLabelDataTable(String labelDataTable) {
            this.labelDataTable = labelDataTable;
            return this;
        }

        public ConfigurationBuilder setDb(DB db) {
            this.db = db;
            return this;
        }

        public ConfigurationBuilder setDefaultLanguageID(long defaultLanguageID) {
            this.defaultLanguageID = defaultLanguageID;
            return this;
        }

        public Configuration create() {
            return new Configuration(languageTable, labelTable, labelDataTable, db, defaultLanguageID);
        }

    }

}
