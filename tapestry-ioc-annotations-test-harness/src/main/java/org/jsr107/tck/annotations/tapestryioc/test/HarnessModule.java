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

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import manager.BlogManager;
import manager.CacheNameOnEachMethodBlogManagerImpl;
import manager.ClassLevelCacheConfigBlogManagerImpl;
import manager.UsingDefaultCacheNameBlogManagerImpl;

import org.apache.tapestry5.ioc.ServiceBinder;

/**
 * Tapestry-IoC module class for this test harness.
 *
 * @author Thiago H. de Paula Figueiredo
 * @version $Revision$
 */
public class HarnessModule {

  private HarnessModule() {}
  
  public static void bind(ServiceBinder binder) {
	bindWithId(binder, UsingDefaultCacheNameBlogManagerImpl.class); 
    bindWithId(binder, CacheNameOnEachMethodBlogManagerImpl.class);
    bindWithId(binder, ClassLevelCacheConfigBlogManagerImpl.class);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static void bindWithId(ServiceBinder binder, Class implementationClass) {
    binder.bind(BlogManager.class, implementationClass).withId(implementationClass.getSimpleName());
  }
  
  public static CacheManager buildCacheManager() {
    CachingProvider provider = Caching.getCachingProvider();
    return provider.getCacheManager(provider.getDefaultURI(), provider.getDefaultClassLoader());    
  }

}
