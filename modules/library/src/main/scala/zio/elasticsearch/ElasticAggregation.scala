/*
 * Copyright 2022 LambdaWorks
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

package zio.elasticsearch

import zio.elasticsearch.aggregation._

object ElasticAggregation {
  def multipleAggregations: Multiple =
    Multiple(aggregations = Nil)

  def termsAggregation(name: String, field: Field[_, String], multiField: Option[String] = None): Terms =
    Terms(name = name, field = field.toString ++ multiField.map("." ++ _).getOrElse(""), subAggregations = Nil)

  def termsAggregation(name: String, field: String): Terms =
    Terms(name = name, field = field, subAggregations = Nil)
}
