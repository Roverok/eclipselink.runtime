/*******************************************************************************
 * Copyright (c) 2006, 2014 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.persistence.jpa.jpql.parser;

/**
 * The query BNF for a scalar expression.
 * <p>
 * JPA 1.0:
 * <div><b>BNF:</b> <code>scalar_expression ::= simple_arithmetic_expression |
 *                                                     string_primary |
 *                                                     enum_primary |
 *                                                     datetime_primary |
 *                                                     boolean_primary</code><p></div>
 *
 * JPA 2.0
 * <div><b>BNF:</b> <code>scalar_expression ::= simple_arithmetic_expression |
 *                                                     string_primary |
 *                                                     enum_primary |
 *                                                     datetime_primary |
 *                                                     boolean_primary |
 *                                                     case_expression |
 *                                                     entity_type_expression</code><p></div>
 *
 * @version 2.5
 * @since 2.3
 * @author Pascal Filion
 */
@SuppressWarnings("nls")
public final class ScalarExpressionBNF extends JPQLQueryBNF {

	/**
	 * The unique identifier of this BNF rule.
	 */
	public static final String ID = "scalar_expression";

	/**
	 * Creates a new <code>SelectExpressionBNF</code>.
	 */
	public ScalarExpressionBNF() {
		super(ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initialize() {
		super.initialize();
		setFallbackBNFId(ID);
		setFallbackExpressionFactoryId(LiteralExpressionFactory.ID);
		registerChild(SimpleArithmeticExpressionBNF.ID);
		registerChild(StringPrimaryBNF.ID);
		registerChild(EnumPrimaryBNF.ID);
		registerChild(DateTimePrimaryBNF.ID);
		registerChild(BooleanPrimaryBNF.ID);
	}
}