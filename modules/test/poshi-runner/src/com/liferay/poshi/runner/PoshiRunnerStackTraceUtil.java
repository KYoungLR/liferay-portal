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

package com.liferay.poshi.runner;

import com.liferay.poshi.runner.util.Validator;

import java.util.Stack;

import org.dom4j.Element;

/**
 * @author Karen Dang
 * @author Michael Hashimoto
 */
public final class PoshiRunnerStackTraceUtil {

	public static void emptyStackTrace() {
		while (!_stackTrace.isEmpty()) {
			_stackTrace.pop();
		}
	}

	public static String getStackTrace() {
		return getStackTrace(null);
	}

	public static String getStackTrace(String msg) {
		StringBuilder sb = new StringBuilder();

		sb.append("\nBUILD FAILED:");

		if (Validator.isNotNull(msg)) {
			sb.append(" ");
			sb.append(msg);
		}

		Stack<String> stackTrace = (Stack<String>)_stackTrace.clone();

		sb.append("\n");
		sb.append(_filePaths.peek());
		sb.append(":");
		sb.append(_currentElement.attributeValue("line-number"));

		while (!stackTrace.isEmpty()) {
			sb.append("\n");
			sb.append(stackTrace.pop());
		}

		sb.append("\n");

		return sb.toString();
	}

	public static void popStackTrace() {
		_filePaths.pop();
		_stackTrace.pop();
	}

	public static void printStackTrace() {
		printStackTrace(null);
	}

	public static void printStackTrace(String msg) {
		System.out.println(getStackTrace(msg));
	}

	public static void pushStackTrace(Element element) throws Exception {
		_stackTrace.push(
			_filePaths.peek() + ":" + element.attributeValue("line-number"));

		String classCommandName = null;
		String classType = null;

		if (element.attributeValue("function") != null) {
			classCommandName = element.attributeValue("function");
			classType = "function";
		}
		else if (element.attributeValue("macro") != null) {
			classCommandName = element.attributeValue("macro");
			classType = "macro";
		}
		else if (element.attributeValue("macro-desktop") != null) {
			classCommandName = element.attributeValue("macro-desktop");
			classType = "macro";
		}
		else if (element.attributeValue("macro-mobile") != null) {
			classCommandName = element.attributeValue("macro-mobile");
			classType = "macro";
		}
		else {
			printStackTrace();

			throw new Exception(
				"Missing (function|macro|macro-desktop|macro-mobile) " +
					"attribute");
		}

		_pushFilePath(classCommandName, classType);
	}

	public static void setCurrentElement(Element currentElement) {
		_currentElement = currentElement;
	}

	public static void startStackTrace(
		String classCommandName, String classType) {

		_pushFilePath(classCommandName, classType);
	}

	private static void _pushFilePath(
		String classCommandName, String classType) {

		String className =
			PoshiRunnerGetterUtil.getClassNameFromClassCommandName(
				classCommandName);

		String fileExtension =
			PoshiRunnerGetterUtil.getFileExtensionFromClassType(classType);

		_filePaths.push(
			PoshiRunnerContext.getFilePathFromFileName(
				className + "." + fileExtension));
	}

	private static Element _currentElement;
	private static final Stack<String> _filePaths = new Stack<>();
	private static final Stack<String> _stackTrace = new Stack<>();

}