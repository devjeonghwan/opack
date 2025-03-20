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

package com.realtimetech.opack.test.opacker.single;

import com.realtimetech.opack.Opacker;
import com.realtimetech.opack.exception.DeserializeException;
import com.realtimetech.opack.exception.SerializeException;
import com.realtimetech.opack.test.OpackAssert;
import com.realtimetech.opack.test.opacker.array.StringArrayTest;
import com.realtimetech.opack.value.OpackValue;
import org.junit.jupiter.api.Test;

public class StringTest {
    @SuppressWarnings("ALL")
    public static class StringClass {
        private String stringValue;

        private String unicodeStringValue;

        private String jsonStringValue;

        private String stringNullValue;

        public StringClass() {
            this.stringValue = "Hello, World!";
            this.unicodeStringValue = "\u0161 and \u003d is Unicode Character";
            this.jsonStringValue = "{what} [if] {is} [to:o] {b,o,r,i,n,g}";
            this.stringNullValue = null;
        }
    }

    @Test
    public void test() throws SerializeException, DeserializeException, OpackAssert.AssertException {
        Opacker opacker = Opacker.Builder.create().build();
        StringArrayTest.StringArrayClass originalObject = new StringArrayTest.StringArrayClass();

        OpackValue serialized = opacker.serialize(originalObject);
        assert serialized != null;
        StringArrayTest.StringArrayClass deserialized = opacker.deserialize(StringArrayTest.StringArrayClass.class, serialized);

        OpackAssert.assertEquals(originalObject, deserialized);
    }
}
