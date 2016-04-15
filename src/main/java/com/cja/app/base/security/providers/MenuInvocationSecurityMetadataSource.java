package com.cja.app.base.security.providers;

import org.springframework.stereotype.Service;


@Service("menuSecurityMetadataSource")
public class MenuInvocationSecurityMetadataSource{
//implements
//		FilterInvocationSecurityMetadataSource, InitializingBean {
//	private final Logger logger = LoggerFactory.getLogger(MenuInvocationSecurityMetadataSource.class);
//
//	@Resource(name = "core.menuDao")
//	private MenuDao menuDao;
//
//	private Map<String, List<MenuFilterItem>> MenuFilterItemMap;
//	private final static String PARENT_MENU_URL = "#";
//
//	private String removeSessionId(String uri) {
//		int i = uri.indexOf(';');
//		if (i != -1) {
//			uri = uri.substring(0, i);
//		}
//		return uri;
//	}
//
//	public MenuInvocationSecurityMetadataSource() {
//	}
//
//
//	@Override
//	@Transactional(readOnly = true)
//	public Collection<ConfigAttribute> getAttributes(Object object)
//			throws IllegalArgumentException {
//		if ((object == null) || !this.supports(object.getClass())) {
//			throw new IllegalArgumentException(
//					"Object must be a FilterInvocation");
//		}
//
//		FilterInvocation fi = (FilterInvocation) object;
//
//		return lookupAttributes(fi.getHttpRequest());
//	}
//
//	/**
//	 * 1)对url除去参数精确匹配,大小写敏感。 2)对参数精确匹配 3)url带上下文根路径
//	 * 
//	 * @param req
//	 * @return
//	 */
//	private Collection<ConfigAttribute> lookupAttributes(HttpServletRequest req) {
//		String uri = req.getRequestURI();
//		String contextPath = req.getContextPath();
//		String url = req.getRequestURL().toString();
//		String queryString = req.getQueryString();
//		String _uri = removeSessionId(uri);
//		String debugStr = null;
//		if (logger.isDebugEnabled()) {
//			debugStr = "handle request, \nurl=[" + url + "]; \nuri=[" + uri
//					+ "];\nremoveSessionIdUri=[" + _uri + "]; \nqueryString=["
//					+ queryString + "], \ncontextPath=[" + contextPath + "].";
//		}
//		List<String> params = parseParams(req.getQueryString());
//
//		List<MenuFilterItem> items = MenuFilterItemMap.get(_uri);
//		MenuFilterItem item = null;
//		if (items != null) {
//			item = lookupAttributes(items, params);
//		}
//		Collection<ConfigAttribute> configAttributes = null;
//		if (item != null) {
//			configAttributes = item.ConfigAttributes;
//			req.setAttribute(Utils.FUN_ID, item.funId);
//		}
//
//		if (logger.isDebugEnabled()) {
//			if (item == null) {
//				debugStr = debugStr + "\nno matched item.";
//			} else {
//				debugStr = debugStr + "\n matched item:\n" + item.toString();
//			}
//			logger.debug(debugStr);
//		}
//		return configAttributes;
//	}
//
//	/**
//	 * 无视参数顺序，精确匹配URL参数(大小写敏感)，匹配funid，取得权限信息
//	 * 
//	 * 1)如果子集匹配项和父集匹配项同时命中，取子集权限信息 说明:
//	 * 有2个权限信息，分别对应a=1和a=1&b=2。则称a=1&b=2是a=1的子集，a=1是a=1&b=2的父集
//	 * 
//	 * 2)如果多个深度相同匹配项命中，则取第一个命中的匹配项的权限信息，且不保证相同参数在第一次命中的匹配项是同一个匹配项，虽然大部分情况是同一个。
//	 * 说明: a=1的深度为1
//	 * a=1&b=2,a=1&c=3,a=2&c=3的深度为2。如果输入客户请求的参数是a=1&b=2&c=3，且不存在a=1&
//	 * b=2&c=3匹配项，那么将取a=1&b=2,a=1&c=3,a=2&c=3中第一个命中的权限信息。
//	 * 
//	 * 3)无视参数顺序，精确匹配URL参数(参数名和参数值) 说明:
//	 * a=1&b=2,b=2&a=1,foo=bar&b=2&a=1被认为是相同的匹配项(如果不存在foo=bar&b=2&a=1的匹配项)。
//	 * a=1&b=2,a=2&=b=2被认为是不同的匹配项
//	 * 
//	 */
//	private MenuFilterItem lookupAttributes(List<MenuFilterItem> items,
//			List<String> params) {
//		int nearestDeep = 0;
//		MenuFilterItem nearestValue = null;
//		for (MenuFilterItem item : items) {
//			if (params.containsAll(item.params)) {
//				if (nearestValue == null) {
//					nearestDeep = item.params.size();
//					nearestValue = item;
//					continue;
//				}
//				if (nearestDeep < item.params.size()) {
//					nearestDeep = item.params.size();
//					nearestValue = item;
//				}
//			}
//		}
//		return nearestValue;
//	}
//
//	/**
//	 * 添加Value,如果存在相同的参数匹配项，则抛出异常
//	 * 
//	 * @param items
//	 * @param item
//	 */
//	private void addMenuFilterItem(List<MenuFilterItem> items,
//			MenuFilterItem item) throws Exception {
//		for (MenuFilterItem mfi : items) {
//			if (mfi.params.containsAll(item.params)) {
//				if (mfi.params.size() == item.params.size()) {
//					throw new Exception("memu url [" + item.menuUrl
//							+ "] already existed");
//				}
//			}
//		}
//
//		items.add(item);
//	}
//
//	private List<String> parseParams(String paramsStr) {
//		ArrayList<String> list = new ArrayList<String>();
//		if (paramsStr == null || paramsStr.length() == 0) {
//			return list;
//		}
//
//		String[] ss = paramsStr.split("&");
//		for (String str : ss) {
//			if (str.length() != 0) {
//				list.add(str);
//			}
//		}
//
//		list.trimToSize();
//		return list;
//	}
//
//	private final class MenuFilterItem {
//
//		public MenuFilterItem(final String srcUrl, final String funId,
//				final String[] attributeTokens) {
//			this.attributeTokens = attributeTokens;
//			this.funId = funId;
//			StringBuilder sb = new StringBuilder();
//			boolean flag = false;
//			for (String s : attributeTokens) {
//				if (flag) {
//					sb.append(',');
//				} else {
//					flag = true;
//				}
//				sb.append(s);
//			}
//			this.attributes = sb.toString();
//			menuUrl = srcUrl;
//			ConfigAttributes = new ArrayList<ConfigAttribute>();
//
//			for (String role : attributeTokens) {
//				ConfigAttribute ca = new SecurityConfig(role);
//				ConfigAttributes.add(ca);
//			}
//
//			int i = srcUrl.indexOf('?');
//			if (i == -1) {
//				uri = srcUrl;
//				paramsStr = null;
//			} else {
//				uri = srcUrl.substring(0, i);
//				paramsStr = srcUrl.substring(i + 1);
//			}
//			params = parseParams(paramsStr);
//
//		}
//
//		private final String[] attributeTokens;
//		public final String funId;
//		public final String uri;
//		public final String menuUrl;
//		public final List<String> params;
//		public final String paramsStr;
//		public final String attributes;
//		public final Collection<ConfigAttribute> ConfigAttributes;
//
//		@Override
//		public final String toString() {
//			StringBuilder sb = new StringBuilder();
//
//			sb.append("uri=[");
//			sb.append(uri);
//			sb.append("]; menuUrl=[");
//			sb.append(menuUrl);
//			sb.append("], paramsStr=[");
//			sb.append(paramsStr);
//			sb.append("], funId=[");
//			sb.append(funId);
//			sb.append("], attributes=[");
//			sb.append(attributes);
//			sb.append("];\nparams=[");
//			boolean flag = false;
//
//			for (String param : params) {
//				if (flag) {
//					sb.append(", ");
//					sb.append(param);
//				} else {
//					sb.append(param);
//					flag = true;
//				}
//			}
//
//			sb.append("].");
//
//			return sb.toString();
//		}
//	}
//
//	@Override
//	public Collection<ConfigAttribute> getAllConfigAttributes() {
//		return null;
//	}
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return true;
//	}
//
//	public void afterPropertiesSet() throws Exception {
//		HashMap<String, ArrayList<MenuFilterItem>> map = new HashMap<String, ArrayList<MenuFilterItem>>();
//		List<Menu> menus = menuDao.getAllMenus();
//
//		for (Menu menu : menus) {
//			String url = menu.getUrl();
//			// 忽略空url
//			if (url == null) {
//				continue;
//			}
//			String s = url.trim();
//			// 忽略父菜单
//			if (s.length() == 0 || s.equals(PARENT_MENU_URL)) {
//				continue;
//			}
//			// 忽略没有角色限制的菜单
//			String[] roles = menu.getNeedRoles();
//			if (roles.length == 0) {
//				continue;
//			}
//			// funId不能为空
//			String funId = menu.getFunCode();
//			if (funId == null) {
//				throw new Exception("menu, id=" + menu.getFunCode() + ", url="
//						+ menu.getUrl() + ", funid can not be null!");
//			}
//
//			// String[] ss = new String[roles.size()];
//			// ss = roles.toArray(ss);
//			MenuFilterItem item = new MenuFilterItem(url, funId, roles);
//			ArrayList<MenuFilterItem> items = map.get(item.uri);
//			if (items == null) {
//				items = new ArrayList<MenuFilterItem>();
//				map.put(item.uri, items);
//			}
//			addMenuFilterItem(items, item);
//			if (logger.isDebugEnabled()) {
//				logger.debug("added menu. \n" + item.toString());
//			}
//		}
//
//		// 重整
//		Map<String, List<MenuFilterItem>> tmp = new HashMap<String, List<MenuFilterItem>>();
//		for (Entry<String, ArrayList<MenuFilterItem>> e : map.entrySet()) {
//			ArrayList<MenuFilterItem> l = e.getValue();
//			l.trimToSize();
//			tmp.put(e.getKey(), Collections.unmodifiableList(l));
//		}
//
//		MenuFilterItemMap = Collections.unmodifiableMap(tmp);
//	}
}
