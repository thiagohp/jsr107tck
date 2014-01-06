/**
 *  Copyright 2011 Terracotta, Inc.
 *  Copyright 2011 Oracle, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.jsr107.tck.annotations.tapestryioc.test;

import javax.cache.annotation.BeanProvider;

import manager.BlogManager;

import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;
import org.jsr107.ri.annotations.tapestryioc.module.CacheAnnotationsModule;

/**
 * Tapestry-IoC specific bean provider that loads up Tapestry-IoC modules when constructed.
 *
 * @author Thiago H. de Paula Figueiredo
 * @version $Revision$
 */
public class TapestryIoCBeanProvider implements BeanProvider {

  final private Registry registry;
  
  public TapestryIoCBeanProvider() {
    super();
    registry = RegistryBuilder.buildAndStartupRegistry(CacheAnnotationsModule.class, HarnessModule.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getBeanByType(Class<T> beanClass) {
    return (T) registry.getService(beanClass.getSimpleName(), BlogManager.class);
  }

}
