/**
 * Copyright 2009-2013 Oy Vaadin Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lunifera.dsl.dto.lib.services.filters;

/**
 * This filter allows you to implement filtering on joined tables using
 * Hibernate, which lacks support for automatic joins. EclipseLink supports
 * automatic joins, which allows you to filter by e.g.
 * <code>new Equal("skills.skill", s)</code>, while Hibernate requires you to do
 * the same using this filter e.g.
 * <code>new JoinFilter("skills", new Equal("skill", s))</code>
 */
public class LJoinFilter extends LAbstractJunctionFilter {

	private final String joinProperty;

	/**
	 * Constructs a HibernateJoin filter.
	 * 
	 * @param joinProperty
	 *            the property that should be joined
	 * @param filters
	 *            a set of filters filtering on the joined property. By default
	 *            all filters much pass for the item to be matched.
	 */
	public LJoinFilter(String joinProperty, ILFilter... filters) {
		super(filters);
		this.joinProperty = joinProperty;
	}

	/**
	 * @return the property that is joined on
	 */
	public String getJoinProperty() {
		return joinProperty;
	}
}
