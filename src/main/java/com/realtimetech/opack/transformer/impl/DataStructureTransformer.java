/*
 * Copyright (C) 2022 REALTIMETECH All Rights Reserved
 *
 * Licensed either under the Apache License, Version 2.0, or (at your option)
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation (subject to the "Classpath" exception),
 * either version 2, or any later version (collectively, the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     http://www.gnu.org/licenses/
 *     http://www.gnu.org/software/classpath/license.html
 *
 * or as provided in the LICENSE file that accompanied this code.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.realtimetech.opack.transformer.impl;

import com.realtimetech.opack.Opacker;
import com.realtimetech.opack.exception.DeserializeException;
import com.realtimetech.opack.exception.SerializeException;
import com.realtimetech.opack.transformer.Transformer;
import com.realtimetech.opack.value.OpackValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DataStructureTransformer implements Transformer {
    /**
     * Serializes the element to {@link OpackValue OpackValue}
     *
     * @param context the opacker context
     * @param element the element to be serialized
     * @return the serialized value
     * @throws SerializeException if a problem occurs during serializing
     */
    protected abstract @Nullable Object serializeObject(@NotNull Opacker.Context context, @Nullable Object element) throws SerializeException;

    /**
     * Deserializes the {@link OpackValue OpackValue}
     *
     * @param context     the opacker
     * @param genericType the generic type of data structure to deserialize an object
     * @param element     the element to be deserialized
     * @return the deserialized element
     * @throws DeserializeException if a problem occurs during deserializing
     */
    protected abstract @Nullable Object deserializeObject(@NotNull Opacker.Context context, @Nullable Class<?> genericType, @Nullable Object element) throws DeserializeException;

}
