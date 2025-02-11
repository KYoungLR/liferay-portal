/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.headless.web.experience.resource.v1_0;

import com.liferay.headless.web.experience.dto.v1_0.StructuredContent;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-web-experience/v1.0
 *
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public interface StructuredContentResource {

	public Page<StructuredContent> getContentSpaceContentStructureStructuredContentsPage(
				Long contentSpaceId,Long contentStructureId,Filter filter,Pagination pagination,Sort[] sorts)
			throws Exception;
	public Page<StructuredContent> getContentSpaceStructuredContentsPage(
				Long contentSpaceId,Filter filter,Pagination pagination,Sort[] sorts)
			throws Exception;
	public StructuredContent postContentSpaceStructuredContent(
				Long contentSpaceId,StructuredContent structuredContent)
			throws Exception;
	public boolean deleteStructuredContent(
				Long structuredContentId)
			throws Exception;
	public StructuredContent getStructuredContent(
				Long structuredContentId)
			throws Exception;
	public StructuredContent patchStructuredContent(
				Long structuredContentId,StructuredContent structuredContent)
			throws Exception;
	public StructuredContent putStructuredContent(
				Long structuredContentId,StructuredContent structuredContent)
			throws Exception;

	public void setContextCompany(Company contextCompany);

}