/*******************************************************************************
 * Copyright (c) 2006, 2011 Oracle. All rights reserved.
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

import java.util.Collection;
import java.util.List;
import org.eclipse.persistence.jpa.jpql.WordParser;

/**
 * Bulk delete operation apply to entities of a single entity class (together with its subclasses,
 * if any).
 * <p>
 * <div nowrap><b>BNF:</b> <code>delete_statement ::= delete_clause [where_clause]</code><p>
 *
 * @version 2.4
 * @since 2.3
 * @author Pascal Filion
 */
public final class DeleteStatement extends AbstractExpression {

	/**
	 * The 'DELETE' clause of this expression.
	 */
	private DeleteClause deleteClause;

	/**
	 * Determines whether a whitespace was parsed after the <b>DELETE</b> clause.
	 */
	private boolean hasSpace;

	/**
	 * The optional 'WHERE' clause of this expression.
	 */
	private AbstractExpression whereClause;

	/**
	 * Creates a new <code>DeleteStatement</code>.
	 *
	 * @param parent The parent of this expression
	 */
	public DeleteStatement(AbstractExpression parent) {
		super(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void acceptChildren(ExpressionVisitor visitor) {
		getDeleteClause().accept(visitor);
		getWhereClause().accept(visitor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addChildrenTo(Collection<Expression> children) {
		children.add(getDeleteClause());
		children.add(getWhereClause());
	}

	/**
	 * Manually adds the delete clause to this delete statement.
	 */
	public DeleteClause addDeleteClause() {
		return deleteClause = new DeleteClause(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addOrderedChildrenTo(List<Expression> children) {

		children.add(deleteClause);

		if (hasSpace) {
			children.add(buildStringExpression(SPACE));
		}

		children.add(whereClause);
	}

	/**
	 * Returns the {@link Expression} representing the <b>DELETE</b> clause.
	 *
	 * @return The expression that was parsed representing the <b>DELETE</b> expression
	 */
	public DeleteClause getDeleteClause() {
		return deleteClause;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPQLQueryBNF getQueryBNF() {
		return getQueryBNF(DeleteStatementBNF.ID);
	}

	/**
	 * Returns the {@link Expression} representing the <b>WHERE</b> clause.
	 *
	 * @return The expression representing the <b>WHERE</b> clause
	 */
	public Expression getWhereClause() {
		if (whereClause == null) {
			whereClause = buildNullExpression();
		}
		return whereClause;
	}

	/**
	 * Determines whether a whitespace was found after the <b>DELETE FROM</b> clause. In some cases,
	 * the space is owned by a child of the <b>DELETE FROM</b> clause.
	 *
	 * @return <code>true</code> if there was a whitespace after the <b>DELETE FROM</b> clause and
	 * owned by this expression; <code>false</code> otherwise
	 */
	public boolean hasSpaceAfterDeleteClause() {
		return hasSpace;
	}

	/**
	 * Determines whether the <b>WHERE</b> clause is defined.
	 *
	 * @return <code>true</code> if the query that got parsed had the <b>WHERE</b> clause
	 */
	public boolean hasWhereClause() {
		return whereClause != null &&
		      !whereClause.isNull();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void parse(WordParser wordParser, boolean tolerant) {

	    // Parse 'DELETE FROM'
		deleteClause = new DeleteClause(this);
		deleteClause.parse(wordParser, tolerant);

		hasSpace = wordParser.skipLeadingWhitespace() > 0;

		// Parse 'WHERE'
		if (wordParser.startsWithIdentifier(WHERE)) {
			whereClause = new WhereClause(this);
			whereClause.parse(wordParser, tolerant);
		}

		// Now fully qualify attribute names with a virtual identification variable
		accept(FullyQualifyPathExpressionVisitor.instance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void toParsedText(StringBuilder writer, boolean actual) {

	    deleteClause.toParsedText(writer, actual);

		if (hasSpace) {
			writer.append(SPACE);
		}

		if (whereClause != null) {
			whereClause.toParsedText(writer, actual);
		}
	}
}