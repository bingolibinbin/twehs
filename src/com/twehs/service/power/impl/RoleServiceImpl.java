package com.twehs.service.power.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.twehs.service.power.RoleService;
import com.twehs.service.power.dto.RoleDTO;
//import com.twehs.service.power.dto.UserDTO;

import com.twehs.dao.power.MenuDAO;
import com.twehs.dao.power.RoleDAO;
import com.twehs.dao.power.RoleMenuDAO;
import com.twehs.dao.power.UserDAO;
import com.twehs.pojo.Menu;
import com.twehs.pojo.Role;
import com.twehs.pojo.User;
import com.twehs.pojo.example.MenuExample;
import com.twehs.pojo.example.MenuExample.Criteria;
//import com.twehs.pojo.example.UserExample;
import com.twehs.pojo.example.RoleMenuExample;

import com.twehs.pojo.RoleMenuKey;
import com.twehs.utils.pubutil.ComboData;
import com.twehs.utils.pubutil.Page;
import com.twehs.utils.pubutil.TreeNodeChecked;

@SuppressWarnings("unchecked")
public class RoleServiceImpl implements RoleService {

	private RoleDAO roleDAO;
	private UserDAO userDAO;
	private RoleMenuDAO roleMenuDAO;
	private MenuDAO menuDAO;

	public void setBaseDao(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	/*
	 * 分页查询角色列表
	 */
	public void findPageRole(Page page) throws SQLException {
		List<Role> listRole = roleDAO.selectByPaper(page.getStart(),
				page.getLimit());
		List dtoList = RoleDTO.createDtos(listRole); // 无法转换 这里是从role到user的转换，不对
		int total = roleDAO.countAll(); // 这里countAll是自己改写的，本身不提供这个函数
		page.setRoot(dtoList); // 输入到page中表现出来
		page.setTotal(total);
	}

	/*
	 * 保存/修改角色
	 */
	public void saveOrUpdateRole(RoleDTO dto) throws SQLException {

		Role role = new Role();
		if (dto.getRoleid() != null) {
			role = (Role) roleDAO.selectByPrimaryKey(dto.getRoleid());
			role.setRolename(dto.getRolename()); // 更新
			role.setBz(dto.getBz());
			roleDAO.updateByPrimaryKeySelective(role);
		}
		role.setRolename(dto.getRolename()); // 插入
		role.setBz(dto.getBz());
		roleDAO.insert(role);
	}

	/*
	 * 删除角色
	 */
	public boolean deleteRole(Integer roleid) throws SQLException {
		User user = userDAO.selectByroleid(roleid); // 鉴于example可能

		if (user != null) {
			userDAO.deleteByPrimaryKey(roleid);
			return true;
		}
		return false;
	}

	/*
	 * 角色下拉数据
	 */
	public List findRoleType() throws SQLException {
		List list = new ArrayList();
		// List<Role> roleList = baseDao.listAll("Role");
		// select * from Role;
		/*
		 * RoleExample roleexample = new RoleExample(); Criteria rolecriteria =
		 * roleexample.createCriteria(); rolecriteria.andRoleidIsNotNull();
		 * List<Role> roleList = roleDAO.selectByExample(roleexample);
		 */
		List<Role> rolelist = roleDAO.selectAll();
		// 展示所有列表
		for (Role role : rolelist) {
			ComboData dto = new ComboData();
			dto.setValue(role.getRoleid().toString());
			dto.setText(role.getRolename());
			list.add(dto);
		}
		return list;
	}

	/*
	 * 查询角色菜单
	 */
	public List findRoleMenu(Integer roleid) throws SQLException {
		MenuExample example2 = new MenuExample();
		Criteria criteria2 = example2.createCriteria();
		example2.setOrderByClause("ordernum asc");
		List<Menu> menuList = menuDAO.selectByExample(example2); // 返回所有权限列表
		// System.out.println(menuList.size());
		RoleMenuExample example3 = new RoleMenuExample();
		RoleMenuExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andRoleidEqualTo(roleid);
		List<RoleMenuKey> roleMenuList = roleMenuDAO.selectByExample(example3);
		// 返回的是rolemenu实例，需要的是对应的menu实例
		// System.out.println(roleMenuList.size());
		ArrayList menlist = new ArrayList();
		for (RoleMenuKey roleMiterater : roleMenuList) {
			Menu men = menuDAO.selectByPrimaryKey(roleMiterater.getMenuid());
			menlist.add(men.getMenuid()); // 对应的role所拥有的权限菜单
		} // 数据到这都没错
			// menuList ，所有权限对应的id的列表
			// menlist 该用户的权限列表
		List<?> treeNodeList = this.getTreeNode(0, menuList, menlist);
		// 这里树形列表的生成需要注意
		return treeNodeList;
	}

	private List getTreeNode(Integer menuid, List listFunc, List listRoleFunc)
			throws SQLException {
		List resultList = new ArrayList();
		// 当前级菜单集合
		List list = this.getChildrens(listFunc, menuid);
		for (Object obj : list) {
			Menu menu = (Menu) obj;
			Menu bingo = menuDAO.selectByPrimaryKey(menu.getMenuid());
			// System.out.println("menu中值：："+menu.getMenuname());
			TreeNodeChecked treeNodeChecked = new TreeNodeChecked();
			treeNodeChecked.setText(menu.getMenuname());
			treeNodeChecked.setId(menu.getMenuid().toString());
			treeNodeChecked.setIconCls(menu.getIcon() == null ? "" : menu
					.getIcon());
			if (listRoleFunc.contains(menu.getMenuid())) {
				treeNodeChecked.setChecked(true);
			} else {
				treeNodeChecked.setChecked(false);
			}
			treeNodeChecked.setChildren(getTreeNode(menu.getMenuid(), listFunc,
					listRoleFunc));// 递归
			resultList.add(treeNodeChecked);
		}
		return resultList;
	}

	// 子集合
	private List getChildrens(List funcs, Integer menuid) {
		List resultList = new ArrayList();
		Menu func = null;
		for (Object obj : funcs) {
			func = (Menu) obj;
			if (func.getPid().equals(menuid)) {// 父节点id
				resultList.add(func);
			}
		}
		return resultList;
	}

	/*
	 * 保存角色权限,经过测试无问题
	 */
	public void saveRoleMenu(Integer roleid, String menuids)
			throws SQLException {
		RoleMenuExample rmexample = new RoleMenuExample();
		RoleMenuExample.Criteria criteriaa = rmexample.createCriteria();
		criteriaa.andRoleidEqualTo(roleid);
		List<RoleMenuKey> rmlist = roleMenuDAO.selectByExample(rmexample); // 这种写法有错误
		ArrayList<Menu> menulist = new ArrayList();
		for (RoleMenuKey rmiterater : rmlist) {
			Menu menu = menuDAO.selectByPrimaryKey(rmiterater.getMenuid());
			menulist.add(menu);
		}

		// RoleExample example3 = new RoleExample;
		// 页面勾选权限id
		String[] mids = menuids.split(",");
		// 页面存在数据库不存在就添加
		// 添加到数据库RoleMenu
		if (mids.length > 0) {
			for (String menuid : mids) {
				if (this.isContain(menulist, menuid)) {
					RoleMenuKey rolemenu = new RoleMenuKey();
					rolemenu.setRoleid(roleid);
					rolemenu.setMenuid(Integer.valueOf(menuid));
					roleMenuDAO.insert(rolemenu);

				}
			}
		}
		// 数据库存在而页面不存在就删除
		// 对RoleMenu进行更新
		for (Menu menu : menulist) {
			String menuid = menu.getMenuid().toString();
			if (this.isContain(mids, menuid)) {
				RoleMenuExample rolemenuexample2 = new RoleMenuExample();
				RoleMenuExample.Criteria criteria2 = rolemenuexample2
						.createCriteria();
				criteria2.andMenuidEqualTo(Integer.valueOf(menuid));
				roleMenuDAO.deleteByExample(rolemenuexample2);

			}
		}
	}

	private boolean isContain(String[] mids, String menuid) {
		for (String mid : mids) {
			if (menuid.equals(mid))
				return false;
		}
		return true;
	}

	private boolean isContain(List<Menu> menuList, String menuid) {
		for (Menu menu : menuList) {
			if (menuid.equals(menu.getMenuid().toString()))
				return false;
		}
		return true;
	}

	public MenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public RoleMenuDAO getRoleMenuDAO() {
		return roleMenuDAO;
	}

	public void setRoleMenuDAO(RoleMenuDAO roleMenuDAO) {
		this.roleMenuDAO = roleMenuDAO;
	}

}
