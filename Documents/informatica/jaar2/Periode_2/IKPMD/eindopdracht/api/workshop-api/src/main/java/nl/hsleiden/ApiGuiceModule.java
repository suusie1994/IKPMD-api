package nl.hsleiden;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import nl.hsleiden.model.*;
import org.hibernate.SessionFactory;

/**
 *
 * @author Peter van Vliet
 */
public class ApiGuiceModule extends AbstractModule {
        
    public static final HibernateBundle<ApiConfiguration> hibernateBundle = new HibernateBundle<ApiConfiguration>(
        User.class, Pagina.class, Developer.class, Counter.class) {

        @Override
        public DataSourceFactory getDataSourceFactory(ApiConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };
    
    public ApiGuiceModule(Bootstrap<ApiConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    protected void configure() {
    }
    
    @Provides
    public SessionFactory provideSessionFactory() {
        return hibernateBundle.getSessionFactory();
    }
}
