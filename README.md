## Override the onLoadConfig in Play 2.3 Java App

This is a simple application that show how to override Play's application configuration via the onLoadConfig in the GlobalSettings class. 
This is a good approach if you need to pull in deployment specific configuration via a properties file

Using Play 2.3, will be slightly different in [2.4](https://www.playframework.com/documentation/2.4.x/JavaDependencyInjection#Advanced:-Extending-the-GuiceApplicationLoader)

### Basic setup

In conf/application.conf

    application.global=global.Global
    
Override the onLoadConfig in the GlobalSettings

    @Override
    public Configuration onLoadConfig(Configuration configuration, File file, ClassLoader classLoader,
            Mode mode) {
        final Properties override = new Properties();
        override.put("globalsetting", "Global Settings Override");
        final Config config = ConfigFactory.parseProperties(override).withFallback(configuration.underlying());
        final Configuration newConfiguration = new Configuration(config);
        return newConfiguration;
    }

Get the value of the property:

    Play.application().configuration().getString("globalsetting")
    