/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.similarity;

import org.apache.lucene.search.similarities.Similarity;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.script.ScriptService;

/**
 * Provider for {@link Similarity} instances
 */
public interface SimilarityProvider {

    /**
     * Returns the name associated with the Provider
     *
     * @return Name of the Provider
     */
    String name();

    /**
     * Returns the {@link Similarity} the Provider is for
     *
     * @return Provided {@link Similarity}
     */
    Similarity get();

    /** Factory of {@link SimilarityProvider} */
    @FunctionalInterface
    interface Factory {
        /** Create a new {@link SimilarityProvider}. */
        SimilarityProvider create(String name, Settings settings, Settings indexSettings, ScriptService scriptService);
    }
}
