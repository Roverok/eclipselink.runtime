/*******************************************************************************
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Martin Vojtek - 2.6 - Initial contribution
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.externalizedmetadata.xmlid;

import javax.xml.bind.annotation.XmlValue;

public class MyID {

    @XmlValue
    public String representation;

    @Override
    public String toString() {
        return "MyID [representation=" + representation + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((representation == null) ? 0 : representation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyID other = (MyID) obj;
        if (representation == null) {
            if (other.representation != null)
                return false;
        } else if (!representation.equals(other.representation))
            return false;
        return true;
    }


}
