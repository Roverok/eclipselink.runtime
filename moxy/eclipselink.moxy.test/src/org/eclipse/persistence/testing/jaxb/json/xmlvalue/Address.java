/*******************************************************************************
 * Copyright (c) 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Denise Smith - 2.4
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.json.xmlvalue;

import java.util.List;

import javax.xml.bind.annotation.XmlValue;

public class Address {
       
	@XmlValue
    private List<String> addressInfo;
   
    /*
    public List<String>  getStreets() {
        return streets;
    }

    public void setStreet(List<String>  streets) {
        this.streets = streets;
    }

    public String getCity() {
        return city;
    }
    	public void setCity(String city) {
        this.city = city;
    }
*/
    public List<String> getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(List<String> addressInfo) {
		this.addressInfo = addressInfo;
	}



    public String toString(){
        //String s = "Address:" +  getStreet() +" " + getCity();
    	String s = "Address:" +  " ";
    	for(int i=0; i<getAddressInfo().size(); i++){
    		s += " " + getAddressInfo().get(i);
    	}
    	
        return s;
    }

    public boolean equals(Object obj) {
        Address add;
        try {
            add = (Address) obj;
        } catch (ClassCastException cce) {
            return false;
        }
       // return city.equals(add.city);// && street.equals(add.street);
        if(addressInfo.size() != add.getAddressInfo().size()){
        	return false;
        }
        
        return addressInfo.containsAll(add.getAddressInfo()) && add.getAddressInfo().containsAll(addressInfo);
    }

}