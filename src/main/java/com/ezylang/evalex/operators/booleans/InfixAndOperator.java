/*
  Copyright 2012-2022 Udo Klimaschewski

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.ezylang.evalex.operators.booleans;

import static com.ezylang.evalex.operators.OperatorIfc.OPERATOR_PRECEDENCE_AND;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.operators.AbstractOperator;
import com.ezylang.evalex.operators.InfixOperator;
import com.ezylang.evalex.parser.Token;
import java.io.Serializable;

/** Boolean AND of two values. */
@InfixOperator(precedence = OPERATOR_PRECEDENCE_AND, operandsLazy = true)
public class InfixAndOperator extends AbstractOperator implements Serializable {

  @Override
  public EvaluationValue evaluate(
      Expression expression, Token operatorToken, EvaluationValue... operands)
      throws EvaluationException {
    return expression.convertValue(
        expression.evaluateSubtree(operands[0].getExpressionNode()).getBooleanValue()
            && expression.evaluateSubtree(operands[1].getExpressionNode()).getBooleanValue());
  }
}
