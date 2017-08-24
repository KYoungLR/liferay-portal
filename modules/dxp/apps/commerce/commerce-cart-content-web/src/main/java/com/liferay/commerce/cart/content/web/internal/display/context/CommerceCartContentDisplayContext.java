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

package com.liferay.commerce.cart.content.web.internal.display.context;

import com.liferay.commerce.constants.CommerceConstants;
import com.liferay.commerce.model.CommerceCart;
import com.liferay.commerce.model.CommerceCartItem;
import com.liferay.commerce.product.display.context.util.CPRequestHelper;
import com.liferay.commerce.product.util.CPDefinitionHelper;
import com.liferay.commerce.service.CommerceCartItemService;
import com.liferay.commerce.util.CommerceCartHelper;
import com.liferay.commerce.util.PriceCalculationHelper;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marco Leo
 * @author Alessio Antonio Rendina
 */
public class CommerceCartContentDisplayContext {

	public CommerceCartContentDisplayContext(
		HttpServletRequest httpServletRequest,
		CommerceCartHelper commerceCartHelper,
		CommerceCartItemService commerceCartItemService,
		CPDefinitionHelper cpDefinitionHelper,
		PriceCalculationHelper priceCalculationHelper) {

		this.httpServletRequest = httpServletRequest;
		_commerceCartHelper = commerceCartHelper;
		_commerceCartItemService = commerceCartItemService;
		this.cpDefinitionHelper = cpDefinitionHelper;
		_priceCalculationHelper = priceCalculationHelper;

		CPRequestHelper cpRequestHelper = new CPRequestHelper(
			httpServletRequest);

		liferayPortletRequest = cpRequestHelper.getLiferayPortletRequest();
		liferayPortletResponse = cpRequestHelper.getLiferayPortletResponse();
	}

	public CommerceCart getCommerceCart() throws PortalException {
		if (_commerceCart != null) {
			return _commerceCart;
		}

		_commerceCart = _commerceCartHelper.getCurrentCommerceCart(
			httpServletRequest, getCommerceCartType());

		return _commerceCart;
	}

	public long getCommerceCartId() throws PortalException {
		CommerceCart commerceCart = getCommerceCart();

		if (commerceCart == null) {
			return 0;
		}

		return commerceCart.getCommerceCartId();
	}

	public double getCommerceCartItemPrice(long commerceCartItemId)
		throws PortalException {

		return _priceCalculationHelper.getPrice(commerceCartItemId);
	}

	public double getCommerceCartTotal() throws PortalException {
		return _priceCalculationHelper.getTotal(getCommerceCartId());
	}

	public int getCommerceCartType() {
		return ParamUtil.getInteger(
			httpServletRequest, "type",
			CommerceConstants.COMMERCE_CART_TYPE_CART);
	}

	public String getCPDefinitionURL(
			long cpDefinitionId, ThemeDisplay themeDisplay)
		throws PortalException {

		return cpDefinitionHelper.getFriendlyURL(cpDefinitionId, themeDisplay);
	}

	public PortletURL getPortletURL() throws PortalException {
		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		String delta = ParamUtil.getString(httpServletRequest, "delta");

		if (Validator.isNotNull(delta)) {
			portletURL.setParameter("delta", delta);
		}

		String deltaEntry = ParamUtil.getString(
			httpServletRequest, "deltaEntry");

		if (Validator.isNotNull(deltaEntry)) {
			portletURL.setParameter("deltaEntry", deltaEntry);
		}

		return portletURL;
	}

	public SearchContainer<CommerceCartItem> getSearchContainer()
		throws PortalException {

		if (_searchContainer != null) {
			return _searchContainer;
		}

		_searchContainer = new SearchContainer<>(
			liferayPortletRequest, getPortletURL(), null, null);

		_searchContainer.setEmptyResultsMessage("no-items-were-found");

		int total = _commerceCartItemService.getCommerceCartItemsCount(
			getCommerceCartId());

		_searchContainer.setTotal(total);

		List<CommerceCartItem> results =
			_commerceCartItemService.getCommerceCartItems(
				getCommerceCartId(), _searchContainer.getStart(),
				_searchContainer.getEnd());

		_searchContainer.setResults(results);

		return _searchContainer;
	}

	protected final CPDefinitionHelper cpDefinitionHelper;
	protected final HttpServletRequest httpServletRequest;
	protected final LiferayPortletRequest liferayPortletRequest;
	protected final LiferayPortletResponse liferayPortletResponse;

	private CommerceCart _commerceCart;
	private final CommerceCartHelper _commerceCartHelper;
	private final CommerceCartItemService _commerceCartItemService;
	private final PriceCalculationHelper _priceCalculationHelper;
	private SearchContainer<CommerceCartItem> _searchContainer;

}