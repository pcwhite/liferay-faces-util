/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.util.el.internal;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.ProjectStage;
import javax.faces.context.FacesContext;


/**
 * This class provides a compatibility layer that isolates differences between JSF1 and JSF2.
 *
 * @author  Neil Griffin
 */
public abstract class I18nMapCompat implements Map<String, Object>, Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 170055432633295830L;

	// Protected Data Members
	protected boolean cacheEnabled;

	public I18nMapCompat() {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		if (facesContext == null) {
			this.cacheEnabled = true;
		}
		else {
			this.cacheEnabled = !facesContext.isProjectStage(ProjectStage.Development);
		}
	}
}
