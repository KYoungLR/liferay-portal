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

package com.liferay.wiki.uad.anonymizer;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalService;
import com.liferay.wiki.uad.constants.WikiUADConstants;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the wiki page UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link WikiPageUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseWikiPageUADAnonymizer
	extends DynamicQueryUADAnonymizer<WikiPage> {

	@Override
	public void autoAnonymize(
			WikiPage wikiPage, long userId, User anonymousUser)
		throws PortalException {

		if (wikiPage.getUserId() == userId) {
			wikiPage.setUserId(anonymousUser.getUserId());
			wikiPage.setUserName(anonymousUser.getFullName());

			autoAnonymizeAsset(wikiPage, anonymousUser);
		}

		if (wikiPage.getStatusByUserId() == userId) {
			wikiPage.setStatusByUserId(anonymousUser.getUserId());
			wikiPage.setStatusByUserName(anonymousUser.getFullName());
		}

		wikiPageLocalService.updateWikiPage(wikiPage);
	}

	@Override
	public void delete(WikiPage wikiPage) throws PortalException {
		wikiPageLocalService.deletePage(wikiPage);
	}

	@Override
	public Class<WikiPage> getTypeClass() {
		return WikiPage.class;
	}

	protected void autoAnonymizeAsset(WikiPage wikiPage, User anonymousUser) {
		AssetEntry assetEntry = fetchAssetEntry(wikiPage);

		if (assetEntry != null) {
			assetEntry.setUserId(anonymousUser.getUserId());
			assetEntry.setUserName(anonymousUser.getFullName());

			assetEntryLocalService.updateAssetEntry(assetEntry);
		}
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return wikiPageLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return WikiUADConstants.USER_ID_FIELD_NAMES_WIKI_PAGE;
	}

	protected AssetEntry fetchAssetEntry(WikiPage wikiPage) {
		return assetEntryLocalService.fetchEntry(
			WikiPage.class.getName(), wikiPage.getPageId());
	}

	@Reference
	protected AssetEntryLocalService assetEntryLocalService;

	@Reference
	protected WikiPageLocalService wikiPageLocalService;

}