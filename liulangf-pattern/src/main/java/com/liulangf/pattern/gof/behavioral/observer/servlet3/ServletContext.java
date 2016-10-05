/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 *
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liulangf.pattern.gof.behavioral.observer.servlet3;

import java.util.EventListener;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestListener;

/**
 * Defines a set of methods that a servlet uses to communicate with its
 * servlet container, for example, to get the MIME type of a file, dispatch
 * requests, or write to a log file.
 *
 * <p>There is one context per "web application" per Java Virtual Machine.  (A
 * "web application" is a collection of servlets and content installed under a
 * specific subset of the server's URL namespace such as <code>/catalog</code>
 * and possibly installed via a <code>.war</code> file.) 
 *
 * <p>In the case of a web
 * application marked "distributed" in its deployment descriptor, there will
 * be one context instance for each virtual machine.  In this situation, the 
 * context cannot be used as a location to share global information (because
 * the information won't be truly global).  Use an external resource like 
 * a database instead.
 *
 * <p>The <code>ServletContext</code> object is contained within 
 * the {@link ServletConfig} object, which the Web server provides the
 * servlet when the servlet is initialized.
 *
 * @author 	Various
 *
 * @see 	Servlet#getServletConfig
 * @see 	ServletConfig#getServletContext
 */

public interface ServletContext {

    /**
     * Adds the listener with the given class name to this ServletContext.
     *
     * <p>The class with the given name will be loaded using the
     * classloader associated with the application represented by this
     * ServletContext, and must implement one or more of the following
     * interfaces:
     * <ul>
     * <li>{@link ServletContextAttributeListener}</tt>
     * <li>{@link ServletRequestListener}</tt>
     * <li>{@link ServletRequestAttributeListener}</tt>
     * <li>{@link javax.servlet.http.HttpSessionListener}</tt>
     * <li>{@link javax.servlet.http.HttpSessionAttributeListener}</tt>
     * </ul>
     *
     * <p>If this ServletContext was passed to 
     * {@link ServletContainerInitializer#onStartup}, then the class with
     * the given name may also implement {@link ServletContextListener},
     * in addition to the interfaces listed above.
     *
     * <p>As part of this method call, the container must load the class
     * with the specified class name to ensure that it implements one of 
     * the required interfaces.
     *
     * <p>If the class with the given name implements a listener interface
     * whose invocation order corresponds to the declaration order (i.e.,
     * if it implements {@link ServletRequestListener},
     * {@link ServletContextListener}, or
     * {@link javax.servlet.http.HttpSessionListener}),
     * then the new listener will be added to the end of the ordered list of
     * listeners of that interface.
     *
     * <p>This method supports resource injection if the class with the
     * given <tt>className</tt> represents a Managed Bean.
     * See the Java EE platform and JSR 299 specifications for additional
     * details about Managed Beans and resource injection.
     *
     * @param className the fully qualified class name of the listener
     *
     * @throws IllegalArgumentException if the class with the given name
     * does not implement any of the above interfaces, or if it implements
     * {@link ServletContextListener} and this ServletContext was not
     * passed to {@link ServletContainerInitializer#onStartup}
     *
     * @throws IllegalStateException if this ServletContext has already
     * been initialized
     *
     * @throws UnsupportedOperationException if this ServletContext was
     * passed to the {@link ServletContextListener#contextInitialized} method
     * of a {@link ServletContextListener} that was neither declared in
     * <code>web.xml</code> or <code>web-fragment.xml</code>, nor annotated
     * with {@link javax.servlet.annotation.WebListener}
     *
     * @since Servlet 3.0
     */
    public void addListener(String className);


    /**
     * Adds the given listener to this ServletContext.
     *
     * <p>The given listener must be an instance of one or more of the
     * following interfaces:
     * <ul>
     * <li>{@link ServletContextAttributeListener}</tt>
     * <li>{@link ServletRequestListener}</tt>
     * <li>{@link ServletRequestAttributeListener}</tt>
     * <li>{@link javax.servlet.http.HttpSessionListener}</tt>
     * <li>{@link javax.servlet.http.HttpSessionAttributeListener}</tt>
     * </ul>
     *
     * <p>If this ServletContext was passed to 
     * {@link ServletContainerInitializer#onStartup}, then the given
     * listener may also be an instance of {@link ServletContextListener},
     * in addition to the interfaces listed above.
     *
     * <p>If the given listener is an instance of a listener interface whose
     * invocation order corresponds to the declaration order (i.e., if it
     * is an instance of {@link ServletRequestListener},
     * {@link ServletContextListener}, or
     * {@link javax.servlet.http.HttpSessionListener}),
     * then the listener will be added to the end of the ordered list of
     * listeners of that interface.
     *
     * @param t the listener to be added
     *
     * @throws IllegalArgumentException if the given listener is not
     * an instance of any of the above interfaces, or if it is an instance
     * of {@link ServletContextListener} and this ServletContext was not
     * passed to {@link ServletContainerInitializer#onStartup}
     *
     * @throws IllegalStateException if this ServletContext has already
     * been initialized
     *
     * @throws UnsupportedOperationException if this ServletContext was
     * passed to the {@link ServletContextListener#contextInitialized} method
     * of a {@link ServletContextListener} that was neither declared in
     * <code>web.xml</code> or <code>web-fragment.xml</code>, nor annotated
     * with {@link javax.servlet.annotation.WebListener}
     *
     * @since Servlet 3.0
     */
    public <T extends EventListener> void addListener(T t);


    /**
     * Adds a listener of the given class type to this ServletContext.
     *
     * <p>The given <tt>listenerClass</tt> must implement one or more of the
     * following interfaces:
     * <ul>
     * <li>{@link ServletContextAttributeListener}</tt>
     * <li>{@link ServletRequestListener}</tt>
     * <li>{@link ServletRequestAttributeListener}</tt>
     * <li>{@link javax.servlet.http.HttpSessionListener}</tt>
     * <li>{@link javax.servlet.http.HttpSessionAttributeListener}</tt>
     * </ul>
     *
     * <p>If this ServletContext was passed to 
     * {@link ServletContainerInitializer#onStartup}, then the given
     * <tt>listenerClass</tt> may also implement
     * {@link ServletContextListener}, in addition to the interfaces listed
     * above.
     *
     * <p>If the given <tt>listenerClass</tt<> implements a listener
     * interface whose invocation order corresponds to the declaration order
     * (i.e., if it implements {@link ServletRequestListener},
     * {@link ServletContextListener}, or
     * {@link javax.servlet.http.HttpSessionListener}),
     * then the new listener will be added to the end of the ordered list
     * of listeners of that interface.
     *
     * <p>This method supports resource injection if the given
     * <tt>listenerClass</tt> represents a Managed Bean.
     * See the Java EE platform and JSR 299 specifications for additional
     * details about Managed Beans and resource injection.
     *
     * @param listenerClass the listener class to be instantiated
     *
     * @throws IllegalArgumentException if the given <tt>listenerClass</tt>
     * does not implement any of the above interfaces, or if it implements
     * {@link ServletContextListener} and this ServletContext was not passed
     * to {@link ServletContainerInitializer#onStartup}
     *
     * @throws IllegalStateException if this ServletContext has already
     * been initialized
     *
     * @throws UnsupportedOperationException if this ServletContext was
     * passed to the {@link ServletContextListener#contextInitialized} method
     * of a {@link ServletContextListener} that was neither declared in
     * <code>web.xml</code> or <code>web-fragment.xml</code>, nor annotated
     * with {@link javax.servlet.annotation.WebListener}
     *
     * @since Servlet 3.0
     */
    public void addListener(Class <? extends EventListener> listenerClass);


    /**
     * Instantiates the given EventListener class.
     *
     * <p>The specified EventListener class must implement at least one of
     * the <code>{@link ServletContextListener}</code>,
     * <code>{@link ServletContextAttributeListener}</code>,
     * <code>{@link ServletRequestListener}</code>,
     * <code>{@link ServletRequestAttributeListener}</code>,
     * <code>{@link javax.servlet.http.HttpSessionListener}</code>, or
     * <code>{@link javax.servlet.http.HttpSessionAttributeListener}</code>
     * interfaces.
     *
     * <p>The returned EventListener instance may be further customized
     * before it is registered with this ServletContext via a call to
     * {@link #addListener(EventListener)}.
     *
     * <p>The given EventListener class must define a zero argument
     * constructor, which is used to instantiate it.
     *
     * <p>This method supports resource injection if the given
     * <tt>clazz</tt> represents a Managed Bean.
     * See the Java EE platform and JSR 299 specifications for additional
     * details about Managed Beans and resource injection.
     *
     * @param clazz the EventListener class to instantiate
     *
     * @return the new EventListener instance
     *
     * @throws ServletException if the given <tt>clazz</tt> fails to be
     * instantiated
     *
     * @throws UnsupportedOperationException if this ServletContext was
     * passed to the {@link ServletContextListener#contextInitialized} method
     * of a {@link ServletContextListener} that was neither declared in
     * <code>web.xml</code> or <code>web-fragment.xml</code>, nor annotated
     * with {@link javax.servlet.annotation.WebListener}
     *
     * @throws IllegalArgumentException if the specified EventListener class
     * does not implement any of the
     * <code>{@link ServletContextListener}</code>,
     * <code>{@link ServletContextAttributeListener}</code>,
     * <code>{@link ServletRequestListener}</code>,
     * <code>{@link ServletRequestAttributeListener}</code>,
     * <code>{@link javax.servlet.http.HttpSessionListener}</code>, or
     * <code>{@link javax.servlet.http.HttpSessionAttributeListener}</code>
     * interfaces.
     *
     * @since Servlet 3.0
     */
    public <T extends EventListener> T createListener(Class<T> clazz)
        throws ServletException; 



}