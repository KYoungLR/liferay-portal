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

package com.liferay.headless.foundation.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.headless.foundation.dto.v1_0.Category;
import com.liferay.headless.foundation.dto.v1_0.Creator;
import com.liferay.headless.foundation.dto.v1_0.ParentCategory;
import com.liferay.headless.foundation.dto.v1_0.ParentVocabulary;
import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.vulcan.pagination.Pagination;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URL;

import java.util.Date;

import javax.annotation.Generated;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public abstract class BaseCategoryResourceTestCase {

	@BeforeClass
	public static void setUpClass() {
		RestAssured.defaultParser = Parser.JSON;
	}

	@Before
	public void setUp() throws Exception {
		testGroup = GroupTestUtil.addGroup();

		_resourceURL = new URL(
			"http://localhost:8080/o/headless-foundation/v1.0");
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testDeleteCategory() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testGetCategory() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testPutCategory() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testGetCategoryCategoriesPage() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testPostCategoryCategory() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testGetVocabularyCategoriesPage() throws Exception {
			Assert.assertTrue(true);
	}
	@Test
	public void testPostVocabularyCategory() throws Exception {
			Assert.assertTrue(true);
	}

	protected Response invokeDeleteCategory(
				Long categoryId)
			throws Exception {

			RequestSpecification requestSpecification = _createRequestSpecification();

				return requestSpecification.when(
				).delete(
					_resourceURL + "/categories/{category-id}",
					categoryId
				);
	}
	protected Response invokeGetCategory(
				Long categoryId)
			throws Exception {

			RequestSpecification requestSpecification = _createRequestSpecification();

				return requestSpecification.when(
				).get(
					_resourceURL + "/categories/{category-id}",
					categoryId
				);
	}
	protected Response invokePutCategory(
				Long categoryId,Category category)
			throws Exception {

			RequestSpecification requestSpecification = _createRequestSpecification();

				return requestSpecification.body(
					category
				).when(
				).put(
					_resourceURL + "/categories/{category-id}",
					categoryId
				);
	}
	protected Response invokeGetCategoryCategoriesPage(
				Long categoryId,Filter filter,Pagination pagination,Sort[] sorts)
			throws Exception {

			RequestSpecification requestSpecification = _createRequestSpecification();

				return requestSpecification.when(
				).get(
					_resourceURL + "/categories/{category-id}/categories",
					categoryId,filter,sorts
				);
	}
	protected Response invokePostCategoryCategory(
				Long categoryId,Category category)
			throws Exception {

			RequestSpecification requestSpecification = _createRequestSpecification();

				return requestSpecification.body(
					category
				).when(
				).post(
					_resourceURL + "/categories/{category-id}/categories",
					categoryId
				);
	}
	protected Response invokeGetVocabularyCategoriesPage(
				Long vocabularyId,Filter filter,Pagination pagination,Sort[] sorts)
			throws Exception {

			RequestSpecification requestSpecification = _createRequestSpecification();

				return requestSpecification.when(
				).get(
					_resourceURL + "/vocabularies/{vocabulary-id}/categories",
					vocabularyId,filter,sorts
				);
	}
	protected Response invokePostVocabularyCategory(
				Long vocabularyId,Category category)
			throws Exception {

			RequestSpecification requestSpecification = _createRequestSpecification();

				return requestSpecification.body(
					category
				).when(
				).post(
					_resourceURL + "/vocabularies/{vocabulary-id}/categories",
					vocabularyId
				);
	}

	protected Category randomCategory() {
		return new CategoryImpl() {
			{

						creatorId = RandomTestUtil.randomLong();
						dateCreated = RandomTestUtil.nextDate();
						dateModified = RandomTestUtil.nextDate();
						description = RandomTestUtil.randomString();
						hasCategories = RandomTestUtil.randomBoolean();
						id = RandomTestUtil.randomLong();
						name = RandomTestUtil.randomString();
						parentVocabularyId = RandomTestUtil.randomLong();
	}
		};
	}

	protected Group testGroup;

	protected class CategoryImpl implements Category {

	public String[] getAvailableLanguages() {
				return availableLanguages;
	}

	public void setAvailableLanguages(String[] availableLanguages) {
				this.availableLanguages = availableLanguages;
	}

	@JsonIgnore
	public void setAvailableLanguages(
				UnsafeSupplier<String[], Throwable> availableLanguagesUnsafeSupplier) {

				try {
					availableLanguages = availableLanguagesUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected String[] availableLanguages;
	public ParentCategory getParentCategory() {
				return parentCategory;
	}

	public void setParentCategory(ParentCategory parentCategory) {
				this.parentCategory = parentCategory;
	}

	@JsonIgnore
	public void setParentCategory(
				UnsafeSupplier<ParentCategory, Throwable> parentCategoryUnsafeSupplier) {

				try {
					parentCategory = parentCategoryUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected ParentCategory parentCategory;
	public Creator getCreator() {
				return creator;
	}

	public void setCreator(Creator creator) {
				this.creator = creator;
	}

	@JsonIgnore
	public void setCreator(
				UnsafeSupplier<Creator, Throwable> creatorUnsafeSupplier) {

				try {
					creator = creatorUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Creator creator;
	public Long getCreatorId() {
				return creatorId;
	}

	public void setCreatorId(Long creatorId) {
				this.creatorId = creatorId;
	}

	@JsonIgnore
	public void setCreatorId(
				UnsafeSupplier<Long, Throwable> creatorIdUnsafeSupplier) {

				try {
					creatorId = creatorIdUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Long creatorId;
	public Date getDateCreated() {
				return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
				this.dateCreated = dateCreated;
	}

	@JsonIgnore
	public void setDateCreated(
				UnsafeSupplier<Date, Throwable> dateCreatedUnsafeSupplier) {

				try {
					dateCreated = dateCreatedUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Date dateCreated;
	public Date getDateModified() {
				return dateModified;
	}

	public void setDateModified(Date dateModified) {
				this.dateModified = dateModified;
	}

	@JsonIgnore
	public void setDateModified(
				UnsafeSupplier<Date, Throwable> dateModifiedUnsafeSupplier) {

				try {
					dateModified = dateModifiedUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Date dateModified;
	public String getDescription() {
				return description;
	}

	public void setDescription(String description) {
				this.description = description;
	}

	@JsonIgnore
	public void setDescription(
				UnsafeSupplier<String, Throwable> descriptionUnsafeSupplier) {

				try {
					description = descriptionUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected String description;
	public Boolean getHasCategories() {
				return hasCategories;
	}

	public void setHasCategories(Boolean hasCategories) {
				this.hasCategories = hasCategories;
	}

	@JsonIgnore
	public void setHasCategories(
				UnsafeSupplier<Boolean, Throwable> hasCategoriesUnsafeSupplier) {

				try {
					hasCategories = hasCategoriesUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Boolean hasCategories;
	public Long getId() {
				return id;
	}

	public void setId(Long id) {
				this.id = id;
	}

	@JsonIgnore
	public void setId(
				UnsafeSupplier<Long, Throwable> idUnsafeSupplier) {

				try {
					id = idUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Long id;
	public String getName() {
				return name;
	}

	public void setName(String name) {
				this.name = name;
	}

	@JsonIgnore
	public void setName(
				UnsafeSupplier<String, Throwable> nameUnsafeSupplier) {

				try {
					name = nameUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected String name;
	public ParentVocabulary getParentVocabulary() {
				return parentVocabulary;
	}

	public void setParentVocabulary(ParentVocabulary parentVocabulary) {
				this.parentVocabulary = parentVocabulary;
	}

	@JsonIgnore
	public void setParentVocabulary(
				UnsafeSupplier<ParentVocabulary, Throwable> parentVocabularyUnsafeSupplier) {

				try {
					parentVocabulary = parentVocabularyUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected ParentVocabulary parentVocabulary;
	public Long getParentVocabularyId() {
				return parentVocabularyId;
	}

	public void setParentVocabularyId(Long parentVocabularyId) {
				this.parentVocabularyId = parentVocabularyId;
	}

	@JsonIgnore
	public void setParentVocabularyId(
				UnsafeSupplier<Long, Throwable> parentVocabularyIdUnsafeSupplier) {

				try {
					parentVocabularyId = parentVocabularyIdUnsafeSupplier.get();
	}
				catch (Throwable t) {
					throw new RuntimeException(t);
	}
	}

	@JsonProperty
	protected Long parentVocabularyId;

	}

	private RequestSpecification _createRequestSpecification() {
		return RestAssured.given(
		).auth(
		).preemptive(
		).basic(
			"test@liferay.com", "test"
		).header(
			"Accept", "application/json"
		).header(
			"Content-Type", "application/json"
		);
	}

	private final static ObjectMapper _inputObjectMapper = new ObjectMapper() {
		{
			setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
	};
	private final static ObjectMapper _outputObjectMapper = new ObjectMapper();

	private URL _resourceURL;

}