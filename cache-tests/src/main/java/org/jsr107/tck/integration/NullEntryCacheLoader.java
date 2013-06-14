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
package org.jsr107.tck.integration;

import javax.cache.Cache;
import javax.cache.integration.CacheLoader;
import java.util.Collections;
import java.util.Map;

/**
 * A {@link CacheLoader} implementation that always returns <code>null</code>
 * {@link Cache} entries for each key requested.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 * @author Brian Oliver
 */
public class NullEntryCacheLoader<K, V> implements CacheLoader<K, V> {

  /**
   * {@inheritDoc}
   */
  @Override
  public Cache.Entry<K, V> load(K key) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<K, V> loadAll(Iterable<? extends K> keys) {
    return Collections.EMPTY_MAP;
  }
}
