/*
 * Copyright (c) 2014 Intelligent Software Solutions
 * Unpublished-all rights reserved under the copyright laws of the
 * United States.
 *
 * This software was developed under sponsorship from the
 * Air Force Research Laboratory under FA8750-06-D-005 and FA8750-09-R-0022.
 *
 * Contractor: Intelligent Software Solutions,
 * 5450 Tech Center Drive, Suite 400, Colorado Springs, 80919.
 * http://www.issinc.com
 * Expiration Date: June 2015
 *
 * Intelligent Software Solutions has title to the rights in this computer
 * software. The Government's rights to use, modify, reproduce, release,
 * perform, display, or disclose these technical data are restricted by
 * paragraph (b)(1) of the Rights in Technical Data-Noncommercial Items
 * clause contained in Contract No. FA8750-06-D-005 and No. FA8750-09-R-0022.
 * Any reproduction of technical data or portions thereof marked with this
 * legend must also reproduce the markings.
 *
 * Intelligent Software Solutions does not grant permission inconsistent with
 * the aforementioned unlimited government rights to use, disclose, copy,
 * or make derivative works of this software to parties outside the
 * Government.
 */
package global;

import java.io.File;
import java.util.Properties;
import play.Configuration;
import play.GlobalSettings;
import play.Mode;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Global extends GlobalSettings {


    @Override public Configuration onLoadConfig(Configuration configuration, File file, ClassLoader classLoader,
            Mode mode) {
        final Properties override = new Properties();
        override.put("systemname", "System Name Override");
        final Config config = ConfigFactory.parseProperties(override).withFallback(configuration.underlying());
        final Configuration newConfiguration = new Configuration(config);
        return newConfiguration;
    }
}
