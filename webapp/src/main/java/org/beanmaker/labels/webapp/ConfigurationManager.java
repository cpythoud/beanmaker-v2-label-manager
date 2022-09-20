package org.beanmaker.labels.webapp;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.beanmaker.labels.Configuration;

import org.dbbeans.sql.DBFromDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.beans.PropertyVetoException;

@WebListener
public class ConfigurationManager implements ServletContextListener {

    private static ComboPooledDataSource DATA_SOURCE;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DATA_SOURCE = new ComboPooledDataSource();
        try {
            DATA_SOURCE.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException propertyVetoException) {
            throw new RuntimeException(propertyVetoException);
        }
        DATA_SOURCE.setJdbcUrl("jdbc:mysql://localhost:3306/label-manager-test");
        DATA_SOURCE.setUser("label-test");
        DATA_SOURCE.setPassword("ltestpwd");
        DATA_SOURCE.setMaxStatements(180);
        DATA_SOURCE.setTestConnectionOnCheckout(true);

        Configuration.setCurrentConfiguration(
                Configuration.builder()
                        .setDb(new DBFromDataSource(DATA_SOURCE))
                        .usePlatformLabels(false)
                        .create()
        );

        System.out.println("INITIALIZATION COMPLETED");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (DATA_SOURCE != null)
            DATA_SOURCE.close();
    }

}
