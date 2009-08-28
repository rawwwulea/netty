/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.util.internal;

/**
 * Accesses the system property swallowing a {@link SecurityException}.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev$, $Date$
 *
 */
public class SystemPropertyUtil {

    /**
     * Returns the value of the Java system property with the specified
     * {@code key}.
     *
     * @return the property value.
     *         {@code null} if there's no such property or if an access to the
     *         specified property is not allowed.
     */
    public static String get(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns the value of the Java system property with the specified
     * {@code key}, while falling back to the specified default value if
     * the property access fails.
     *
     * @return the property value.
     *         {@code def} if there's no such property or if an access to the
     *         specified property is not allowed.
     */
    public static String get(String key, String def) {
        String value = get(key);
        if (value == null) {
            value = def;
        }
        return value;
    }

    private SystemPropertyUtil() {
        // Unused
    }
}
