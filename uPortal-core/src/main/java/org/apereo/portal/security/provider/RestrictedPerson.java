/**
 * Licensed to Apereo under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright ownership. Apereo
 * licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at the
 * following location:
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apereo.portal.security.provider;

import java.util.List;
import java.util.Map;
import org.apereo.portal.EntityIdentifier;
import org.apereo.portal.security.IPerson;
import org.apereo.portal.security.ISecurityContext;

/**
 * An IPerson object that wraps another IPerson object and prevents access to the underlying
 * security context.
 */
public class RestrictedPerson implements IPerson {
    private static final long serialVersionUID = 1L;

    private final IPerson person;

    public RestrictedPerson(IPerson person) {
        this.person = person;
    }

    @Override
    public Object getAttribute(String key) {
        return this.person.getAttribute(key);
    }

    @Override
    public Object[] getAttributeValues(String key) {
        return this.person.getAttributeValues(key);
    }

    @Override
    public Map<String, List<Object>> getAttributeMap() {
        return this.person.getAttributeMap();
    }

    @Override
    public String getFullName() {
        return this.person.getFullName();
    }

    @Override
    public int getID() {
        return this.person.getID();
    }

    @Override
    public String getUserName() {
        return person.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        person.setUserName(userName);
    }

    @Override
    public boolean isGuest() {
        return this.person.isGuest();
    }

    @Override
    public void setAttribute(String key, Object value) {
        this.person.setAttribute(key, value);
    }

    @Override
    public void setAttribute(String key, List<Object> values) {
        this.person.setAttribute(key, values);
    }

    @Override
    public void setAttributes(Map<String, List<Object>> attrs) {
        this.person.setAttributes(attrs);
    }

    @Override
    public void setFullName(String sFullName) {
        this.person.setFullName(sFullName);
    }

    @Override
    public void setID(int sID) {
        this.person.setID(sID);
    }

    /**
     * RestrictedPerson's implementation of getSecurityContext prevents access to the security
     * context by always returning null.
     *
     * @return null
     */
    @Override
    public ISecurityContext getSecurityContext() {
        return null;
    }

    /** RestrictedPerson's implementation of setSecurityContext does nothing. */
    @Override
    public void setSecurityContext(ISecurityContext securityContext) {
        // Part of RestrictedPerson's restrictedness is to do nothing
        // when this method is invoked.
    }

    @Override
    public EntityIdentifier getEntityIdentifier() {
        return this.person.getEntityIdentifier();
    }

    @Override
    public String getName() {
        return this.person.getName();
    }
}
