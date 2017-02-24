/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2017 the original author or authors.
 */
package org.assertj.core.api.float_;

import org.assertj.core.api.FloatAssert;
import org.assertj.core.api.FloatAssertBaseTest;
import org.assertj.core.data.Offset;

import static org.assertj.core.data.Offset.offset;
import static org.mockito.Mockito.verify;


/**
 * Tests for <code>{@link FloatAssert#isNotCloseTo(float, Offset)}</code>.
 *
 * @author Chris Arnott
 */
public class FloatAssert_isNotCloseTo_float_Test extends FloatAssertBaseTest {

  private final Offset<Float> offset = offset(5f);

  @Override
  protected FloatAssert invoke_api_method() {
    return assertions.isNotCloseTo(8f, offset);
  }

  @Override
  protected void verify_internal_effects() {
    verify(floats).assertIsNotCloseTo(getInfo(assertions), getActual(assertions), 8f, offset);
  }
}
