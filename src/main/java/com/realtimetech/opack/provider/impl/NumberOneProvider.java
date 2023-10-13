/*
 * Copyright (C) 2023 REALTIMETECH All Rights Reserved
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

package com.realtimetech.opack.provider.impl;

import com.realtimetech.opack.Opacker;
import com.realtimetech.opack.bake.BakedType;
import com.realtimetech.opack.provider.DefaultValueProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NumberOneProvider implements DefaultValueProvider {
    /**
     * Deserialize opack value
     *
     * @param opacker  the opacker
     * @param object   the property owner
     * @param property the property to provide default value
     * @return the default value
     */
    @Override
    public @Nullable Object provide(@NotNull Opacker opacker, @NotNull Object object, BakedType.@NotNull Property property) {
        return 1;
    }
}
