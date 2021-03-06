/*******************************************************************************
 * Copyright (c) 2011, 2013 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.persistence.jpa.tests.jpql.tools;

import org.eclipse.persistence.jpa.jpql.parser.EclipseLinkJPQLGrammar1;
import org.eclipse.persistence.jpa.jpql.parser.EclipseLinkJPQLGrammar2_0;
import org.eclipse.persistence.jpa.jpql.parser.EclipseLinkJPQLGrammar2_1;
import org.eclipse.persistence.jpa.jpql.parser.EclipseLinkJPQLGrammar2_2;
import org.eclipse.persistence.jpa.jpql.parser.EclipseLinkJPQLGrammar2_3;
import org.eclipse.persistence.jpa.jpql.parser.EclipseLinkJPQLGrammar2_4;
import org.eclipse.persistence.jpa.jpql.parser.EclipseLinkJPQLGrammar2_5;
import org.eclipse.persistence.jpa.jpql.tools.model.EclipseLinkJPQLQueryBuilder;
import org.eclipse.persistence.jpa.jpql.tools.model.IJPQLQueryBuilder;
import org.eclipse.persistence.jpa.jpql.tools.model.JPQLQueryBuilder1_0;
import org.eclipse.persistence.jpa.jpql.tools.model.JPQLQueryBuilder2_0;
import org.eclipse.persistence.jpa.jpql.tools.model.JPQLQueryBuilder2_1;
import org.eclipse.persistence.jpa.tests.jpql.JPQLTestRunner;
import org.eclipse.persistence.jpa.tests.jpql.tools.model.IJPQLQueryBuilderTestHelper;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The root test suite containing the unit-tests testing the refactoring functionality when the JPA
 * version is 1.0.
 *
 * @version 2.5
 * @since 2.4
 * @author Pascal Filion
 */
@SuiteClasses({
	RefactoringToolTest1_0.class
})
@RunWith(JPQLTestRunner.class)
public final class AllRefactoringToolTest1_0 {

	private AllRefactoringToolTest1_0() {
		super();
	}

	@IJPQLQueryBuilderTestHelper
	static IJPQLQueryBuilder[] buildJPQLQueryBuilders() {
		return new IJPQLQueryBuilder[] {
			new JPQLQueryBuilder1_0(),
			new JPQLQueryBuilder2_0(),
			new JPQLQueryBuilder2_1(),
			new EclipseLinkJPQLQueryBuilder(EclipseLinkJPQLGrammar1.instance()),
			new EclipseLinkJPQLQueryBuilder(EclipseLinkJPQLGrammar2_0.instance()),
			new EclipseLinkJPQLQueryBuilder(EclipseLinkJPQLGrammar2_1.instance()),
			new EclipseLinkJPQLQueryBuilder(EclipseLinkJPQLGrammar2_2.instance()),
			new EclipseLinkJPQLQueryBuilder(EclipseLinkJPQLGrammar2_3.instance()),
			new EclipseLinkJPQLQueryBuilder(EclipseLinkJPQLGrammar2_4.instance()),
			new EclipseLinkJPQLQueryBuilder(EclipseLinkJPQLGrammar2_5.instance())
		};
	}
}