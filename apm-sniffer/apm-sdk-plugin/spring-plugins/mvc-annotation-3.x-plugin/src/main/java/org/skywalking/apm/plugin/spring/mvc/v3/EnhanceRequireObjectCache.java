/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.plugin.spring.mvc.v3;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.NativeWebRequest;

public class EnhanceRequireObjectCache {
    private PathMappingCache pathMappingCache;
    private NativeWebRequest nativeWebRequest;

    public void setPathMappingCache(PathMappingCache pathMappingCache) {
        this.pathMappingCache = pathMappingCache;
    }

    public HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse)nativeWebRequest.getNativeResponse();
    }

    public void setNativeWebRequest(NativeWebRequest nativeWebRequest) {
        this.nativeWebRequest = nativeWebRequest;
    }

    public String findPathMapping(Method method) {
        return pathMappingCache.findPathMapping(method);
    }

    public void addPathMapping(Method method, String url) {
        pathMappingCache.addPathMapping(method, url);
    }

    public PathMappingCache getPathMappingCache() {
        return pathMappingCache;
    }
}