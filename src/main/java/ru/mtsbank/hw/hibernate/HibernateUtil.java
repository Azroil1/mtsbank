package ru.mtsbank.hw.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardServiceRegistry;


    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null) {
            try {
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }catch (Exception e){
                e.printStackTrace();
                if(standardServiceRegistry != null){
                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                }
            }
        }
        return sessionFactory;
    }
}
