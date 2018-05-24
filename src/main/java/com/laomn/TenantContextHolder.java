/**
 *    Copyright 2009-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.laomn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author xuruqing
 *
 */
public class TenantContextHolder {

	private static ThreadLocal<String> tenantThreadLocal = new ThreadLocal<String>();
	private static Map<String, String> concurrentHashMap = new HashMap<String, String>();
	// private static String KEY = Thread.currentThread().getName() + ":" +
	// Thread.currentThread().getId();

	public static final void setTenant(String key1, String scheme) {
		String key = Thread.currentThread().getName() + ":" + Thread.currentThread().getId();
		System.out.println(key);
		System.out.println(key);
		tenantThreadLocal.set(scheme);
		concurrentHashMap.put(key1, scheme);
	}

	public static final String getTenant(String key1) {
		System.out.println(key1);
		String key = Thread.currentThread().getName() + ":" + Thread.currentThread().getId();
		System.out.println(key);

		System.out.println(key1.equals(key));
		// String scheme = tenantThreadLocal.get();
		// if (scheme == null) {
		// scheme = "";
		// }

		System.out.println(concurrentHashMap.size());
		int size = concurrentHashMap.size();
		c.putAll(concurrentHashMap);
		System.out.println(c.size());
		Set<String> set = c.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String keyy = it.next();
			System.out.println(keyy + "  :    " + (keyy.equals(key1)));

		}
		String scheme = concurrentHashMap.get(key1);
		return scheme;
	}

	static Map<String, String> c = new HashMap<String, String>();

	public static final void remove(String key1) {
		String key = Thread.currentThread().getName() + ":" + Thread.currentThread().getId();
		System.out.println(key);
		System.out.println(key1);
		tenantThreadLocal.remove();
		concurrentHashMap.remove(key1);
		System.out.println(concurrentHashMap.size());
	}

}