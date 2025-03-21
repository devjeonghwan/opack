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

package com.realtimetech.opack.test.opacker.array;

import com.realtimetech.opack.Opacker;
import com.realtimetech.opack.exception.DeserializeException;
import com.realtimetech.opack.exception.SerializeException;
import com.realtimetech.opack.test.OpackAssert;
import com.realtimetech.opack.test.RandomUtil;
import com.realtimetech.opack.value.OpackValue;
import org.junit.jupiter.api.Test;

public class PrimitiveArrayTest {
    @SuppressWarnings("ALL")
    public static class PrimitiveArrayClass {
        private boolean[] booleanArrayValue;

        private byte[] byteArrayValue;
        private char[] charArrayValue;

        private short[] shortArrayValue;

        private int[] intArrayValue;
        private float[] floatArrayValue;

        private double[] doubleArrayValue;
        private long[] longArrayValue;

        public PrimitiveArrayClass() {
            int length = RandomUtil.nextInt(1024) + 512;

            this.booleanArrayValue = new boolean[length];
            for (int index = 0; index < length; index++) {
                this.booleanArrayValue[index] = RandomUtil.nextBoolean();
            }

            this.byteArrayValue = new byte[length];
            for (int index = 0; index < length; index++) {
                this.byteArrayValue[index] = (byte) RandomUtil.nextInt();
            }

            this.charArrayValue = new char[length];
            for (int index = 0; index < length; index++) {
                this.charArrayValue[index] = (char) RandomUtil.nextInt();
            }

            this.shortArrayValue = new short[length];
            for (int index = 0; index < length; index++) {
                this.shortArrayValue[index] = (short) RandomUtil.nextInt();
            }

            this.intArrayValue = new int[length];
            for (int index = 0; index < length; index++) {
                this.intArrayValue[index] = RandomUtil.nextInt();
            }

            this.floatArrayValue = new float[length];
            for (int index = 0; index < length; index++) {
                this.floatArrayValue[index] = RandomUtil.nextFloat();
            }

            this.doubleArrayValue = new double[length];
            for (int index = 0; index < length; index++) {
                this.doubleArrayValue[index] = RandomUtil.nextDouble();
            }

            this.longArrayValue = new long[length];
            for (int index = 0; index < length; index++) {
                this.longArrayValue[index] = RandomUtil.nextLong();
            }
        }
    }

    @Test
    public void test() throws SerializeException, DeserializeException, OpackAssert.AssertException {
        Opacker opacker = Opacker.Builder.create().build();
        PrimitiveArrayClass originalObject = new PrimitiveArrayClass();

        OpackValue serialized = opacker.serialize(originalObject);
        assert serialized != null;
        PrimitiveArrayClass deserialized = opacker.deserialize(PrimitiveArrayClass.class, serialized);

        OpackAssert.assertEquals(originalObject, deserialized);
    }
}
